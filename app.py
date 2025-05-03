from db import db, User, Category, Tag
from flask import Flask, request
import json

app = Flask(__name__)
db_filename = "idea.db"

app.config["SQLALCHEMY_DATABASE_URI"] = "sqlite:///%s" % db_filename
app.config["SQLALCHEMY_TRACK_MODIFICATIONS"] = False
app.config["SQLALCHEMY_ECHO"] = True

db.init_app(app)
with app.app_context():
    db.create_all()


def success_response(data, code=200):
    return json.dumps(data), code

def failure_response(message, code=404):
    return json.dumps({"error": message}), code

# Add User
# ----------------------------
# Body (JSON): { "name": "Alice" }
# Description: Creates a new user with the given name.
@app.route("/users/", methods=["POST"])
def add_user():
    body = json.loads(request.data)
    if body.get("name") is None:
        return failure_response("Missing name", 400)
    new_user = User(name=body["name"])
    db.session.add(new_user)
    db.session.commit()
    return success_response(new_user.serialize())

# Add Tag to User
# ----------------------------
# Body (JSON): { "tag_name": "CS1998", "category_id": 1 }
# Description: Adds a tag to a user. If the tag doesn't exist under that category, it will be created.
@app.route("/users/<int:user_id>/tags/", methods=["POST"])
def add_tag_to_user(user_id):
    body = json.loads(request.data)
    tag_name = body.get("tag_name")
    category_id = body.get("category_id")

    if not tag_name or not category_id:
        return failure_response("Missing tag_name or category_id", 400)

    user = User.query.get(user_id)
    if not user:
        return failure_response("User not found", 404)

    category = Category.query.get(category_id)
    if not category:
        return failure_response("Category not found", 404)

    # check if tag exist
    tag = Tag.query.filter_by(name=tag_name, category_id=category_id).first()

    # creates tag if it doesn't exist
    if not tag:
        tag = Tag(name=tag_name, category_id=category_id)
        db.session.add(tag)
        db.session.commit()

    # add tag to the user
    if tag not in user.tags:
        user.tags.append(tag)
        db.session.commit()

    return success_response(user.serialize())

# Add Category
# ----------------------------
# Body (JSON): { "name": "Course" }
# Description: Creates a new category.  
@app.route("/categories/", methods=["POST"])
def add_category():
    body = json.loads(request.data)
    if body.get("name") is None:
        return failure_response("Missing category name", 400)
    
    new_category = Category(name=body["name"])
    db.session.add(new_category)
    db.session.commit()
    return success_response(new_category.serialize(), 201)

# Delete Category
# ----------------------------
# Description: Deletes a category and all its associated tags.
@app.route("/categories/<int:category_id>/", methods=["DELETE"])
def delete_category(category_id):
    category = Category.query.get(category_id)
    if not category:
        return failure_response("Category not found", 404)

    db.session.delete(category)
    db.session.commit()
    return success_response({"message": f"Category {category_id} deleted."})

# Remove Tag from User
# ----------------------------
# Description: Unlinks a tag from a user without deleting the tag itself.
@app.route("/users/<int:user_id>/tags/<int:tag_id>/", methods=["DELETE"])
def remove_tag_from_user(user_id, tag_id):
    user = User.query.get(user_id)
    if not user:
        return failure_response("User not found", 404)

    tag = Tag.query.get(tag_id)
    if not tag:
        return failure_response("Tag not found", 404)

    if tag not in user.tags:
        return failure_response("Tag not associated with this user", 400)

    user.tags.remove(tag)
    db.session.commit()

    return success_response(user.serialize())

# Delete User
# ----------------------------
# Description: Permanently deletes a user and all tag associations.
@app.route("/users/<int:user_id>/", methods=["DELETE"])
def delete_user(user_id):
    user = User.query.filter_by(id = user_id).first()
    if not user:
        return failure_response("User not found")
    db.session.delete(user)
    db.session.commit()
    return success_response(user.serialize())

# Get Users from Tag
# ----------------------------
# Description: Returns a list of users who have the specified tag.
@app.route("/tags/<int:tag_id>/users/", methods=["GET"])
def get_users_from_tag(tag_id):
    tag = Tag.query.filter_by(id = tag_id).first()
    if not tag:
        return failure_response("Tag not found")
    users = [user.serialize() for user in tag.users]
    return success_response(users)

# Get User by ID
# ----------------------------
# Description: Returns the user and their associated tags by user ID.
@app.route("/users/<int:user_id>/", methods=["GET"])
def get_user_by_id(user_id):
    user = User.query.get(user_id)
    if not user:
        return failure_response("User not found", 404)
    return success_response(user.serialize())

# Creating preset categories
category = Category("Courses")
db.session.add(category)
category_two = Category("Clubs")
db.session.add(category_two)
category_three = Category("Hobbies")
db.session.add(category_three)
category_four = Category("Looking for:")
db.session.add(category_four)
db.session.commit()

if __name__ == "__main__":
    app.run(debug=True)

