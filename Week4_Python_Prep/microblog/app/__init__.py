from flask import Flask

app = Flask(__name__)
# going to use other modules by creating instance of flask(module), module is where mainly flaskk.conf will contains

from app import routes
# importing route at bottom generally avoid circular imports problem i.e, app() -> func() -> app() again
# note: In Flask, handlers for the application routes are written as Python functions, called view functions.
# to directly use 'flask run' cmds, set env path of microblog.py with its absolute path