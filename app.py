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

# add_user
@app.route("/users", methods=["POST"])
def add_user():
    body = json.loads(request.data)
    if body.get("name") is None:
        return failure_response("Missing name", 400)
    new_user = User(name=body["name"])
    db.session.add(new_user)
    db.session.commit()
    return success_response(new_user.serialize())

#add_tag_to_user
@app.route("/users/<int:user_id>/tags", methods=["POST"])
def add_tag_to_user(user_id):
    body = json.loads(request.data)
    tag = Tag.query.filter_by(name=body["tag_name"]).first()
    if not tag:
        return failure_response("Tag not found")
    user = User.query.filter_by(id = user_id).first()
    user.tags.append(tag)
    db.session.commit()
    return success_response(user.serialize())


# DELETE tags
@app.route("/tags/<int:tag_id>", methods=["DELETE"])
def delete_tag(tag_id):
    tag = Tag.query.filter_by(id = tag_id).first()
    if not tag:
        return failure_response("Tag not found")
    db.session.delete(tag)
    db.session.commit()
    return success_response(tag.serialize())

# DELETE users
@app.route("/users/<int:user_id>", methods=["DELETE"])
def delete_user(user_id):
    user = User.query.filter_by(id = user_id).first()
    if not user:
        return failure_response("User not found")
    db.session.delete(user)
    db.session.commit()
    return success_response(user.serialize())

# GET tags
@app.route("/tags/<int:tag_id>/users", methods=["GET"])
def get_users_from_tag(tag_id):
    tag = Tag.query.filter_by(id = tag_id).first()
    if not tag:
        return failure_response("Tag not found")
    users = [user.serialize() for user in tag.users]
    return success_response(users)

if __name__ == "__main__":
    app.run(debug=True)
