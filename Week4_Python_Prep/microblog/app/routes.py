from flask import render_template
from app import app

@app.route('/')
@app.route('/index')
def index():
    user = {"username" : "krrish"}
    posts = [
    {
        'author': {'username': 'John'},
        'body': 'Beautiful day in Portland!'
    },
    {
        'author': {'username': 'Susan'},
        'body': 'The Avengers movie was so cool!'
    }
]
    
    return  render_template('index.html', title='Home', user=user, posts=posts)
# The operation that converts a template into a complete HTML page is called rendering done by flask.render_template().
#  Jinga template engine replace {{}} with value and other stuffs {% if this %} or {% for post in post %}
