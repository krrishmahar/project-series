from werkzeug.security import generate_password_hash, check_password_hash
from datetime import datetime, timezone
from typing import Optional
import sqlalchemy as sa
import sqlalchemy.orm as so
from flask_login import UserMixin
from app import db, login
from hashlib import md5

class User(UserMixin, db.Model):
    id: so.Mapped[int] = so.mapped_column(primary_key=True)
    username: so.Mapped[str] = so.mapped_column(sa.String(64), index=True, unique=True)
    email: so.Mapped[str] = so.mapped_column(sa.String(120), index=True, unique=True)
    password_hash: so.Mapped[Optional[str]] = so.mapped_column(sa.String(256))
    posts: so.WriteOnlyMapped['Post'] = so.relationship(back_populates='author')
    about_me : so.Mapped[Optional[str]] = so.mapped_column(sa.String(140)) 
    last_seen: so.Mapped[Optional[datetime]] = so.mapped_column(
        default=lambda : datetime.now(timezone.utc))
    # mapping rows with datatype like idL so.Mapped[int] will make it non-nullable and int type while Optional[] mkaesit nullable

    def __repr__(self):
        return f'<User {self.username}>'
    
    def set_password(self, password):
        self.password_hash = generate_password_hash(password)

    def check_password(self, password):
        return check_password_hash(self.password_hash, password)

    def avatar(self, size):
        digest = md5(self.email.lower().encode('utf-8')).hexdigest()
        return f'https://www.gravatar.com/avatar/{digest}?d=identicon&s={size}'


    # this method will be called when you print the object of User class, basically reresentation
    # author and posts are high level integration of two column by relationship func()
    #  These two attributes allow the application to access the connected user and post entries.

@login.user_loader
def load_user(id):
    return db.session.get(User, int(id))

class Post(db.Model):
    id: so.Mapped[int] = so.mapped_column(primary_key=True)
    body: so.Mapped[str] = so.mapped_column(sa.String(140))
    timestamp: so.Mapped[datetime] = so.mapped_column(
        index=True, default=lambda: datetime.now(timezone.utc)) 
    user_id: so.Mapped[int] = so.mapped_column(sa.ForeignKey(User.id),index=True)
    author: so.Mapped[User]= so.relationship(back_populates='posts')

    def __repr__(self):
        return f'<Post {self.body}>'
# This modules creates the schema of database and for changes like update/delete, we gotta make them -> store then in migration script -> exceute them in sequence & to do that, we need to create a migration script, which is done by alembic
# in root/ -> open bash -> cmd "flask db init"
