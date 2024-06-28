from flask import render_template, flash, redirect, url_for
from app import app
from app.forms import Loginform

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

@app.route('/login', methods=['GET','POST'])
def login():
    form = Loginform()
    if form.validate_on_submit():
        flash('Login requested form the user {},  remember_me={}'
              .format(form.username.data, form.remember_me.data))
        return redirect(url_for('index'))
    return render_template('login.html', title='Sign in', form=form)

