from flask_sqlalchemy import SQLAlchemy

db = SQLAlchemy()

# your classes here
user_tags = db.Table(
    "user_tags",
    db.Column("user_id", db.Integer, db.ForeignKey("users.id")),
    db.Column("tag_id", db.Integer, db.ForeignKey("tags.id")),
)

class Category(db.Model):
    '''
    Category model
    One-to-many relationship with tag model
    '''
    __tablename__ = "categories"
    id = db.Column(db.Integer, primary_key=True, autoincrement=True)
    name = db.Column(db.String, nullable=False)
    tags = db.relationship("Tag", cascade="delete")

    def __init__(self, **kwargs):
      """
      Initialize a category object
      """
      self.name = kwargs.get("name")

    def serialize(self):
        data = {
            "id": self.id,
            "name": self.name,
            "tags": [t.serialize() for t in self.tags],
        }
        return data

class Tag(db.Model):
    '''
    Tag model
    Many-to-one relationship with category model
    Many-to-many relationship with user model
    '''
    __tablename__ = "tags"
    id = db.Column(db.Integer, primary_key=True, autoincrement=True)
    name = db.Column(db.String, nullable=False)
    category_id = db.Column(db.Integer, db.ForeignKey("categories.id"), nullable=False)
    users = db.relationship("User", secondary=user_tags, back_populates="tags")
    
    def __init__(self, **kwargs):
      """
      Initialize a tag object
      """
      self.name = kwargs.get("name")
      self.category_id = kwargs.get("category_id")

    def serialize(self):
        data = {
            "id": self.id,
            "name": self.name,
            "category_id": self.category_id,
            "users": [u.serialize() for u in self.users]
        }
        return data

class User(db.Model):
    '''
    User model
    Many-to-many relationship with tag model
    '''
    __tablename__ = "users"
    id = db.Column(db.Integer, primary_key=True, autoincrement=True)
    name = db.Column(db.String, nullable=False)
    tags = db.relationship("Tag", secondary=user_tags, back_populates="users")

    def __init__(self, **kwargs):
      """
      Initialize a user object
      """
      self.name = kwargs.get("name")

    def serialize(self):
        data = {
            "id": self.id,
            "name": self.name,
            "tags": [t.serialize() for t in self.tags]
        }
        return data