## -*- coding: cp1252 -*-
"""
arquivo: hello.py

$ pip instal flask

$ python hello.py

Chrome/Firefox http://localhost:5000
"""

from flask import Flask

app = Flask(__name__)

@app.route('/')
def hello():
    return '<h1 style="color:blue;">O kaio é viado. acesse:. <h1>\n''<h1 style="color:green;">De: kaiogay.com.br <h1>'

import tabuada

if __name__ == '__main__':
    app.run()
