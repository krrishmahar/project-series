from flask import Flask
from flask_login import LoginManager
from config import Config
from flask_sqlalchemy import SQLAlchemy
from flask_migrate import Migrate

app = Flask(__name__)
app.config.from_object(Config)
db = SQLAlchemy(app)
migrate = Migrate(app, db)
login = LoginManager(app)
login.login_view = 'login'
# going to use other modules by creating instance of flask(module), module is where mainly flaskk.conf will contains

from app import routes, models
# importing route at bottom generally avoid circular imports problem i.e, app() -> func() -> app() again
# note: In Flask, handlers for the application routes are written as Python functions, called view functions.
# to directly use 'flask run' cmds, set env path of microblog.py with its absolute path