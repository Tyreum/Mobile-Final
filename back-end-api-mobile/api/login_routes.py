from flask import Flask, request, jsonify, Blueprint
from flask_sqlalchemy import SQLAlchemy
from __init__ import db
from models import LoginTable

bp_auth = Blueprint('auth', __name__)

@bp_auth.route('/login', methods=['POST'])
def login():
    email = request.json['email']
    senha = request.json['senha']

    login = LoginTable.query.filter_by(email=email, senha=senha).first()

    if login:
        return jsonify({"status":True})
    else:
        return jsonify({"status":False})

@bp_auth.route('/cadastrar', methods=['POST'])
def register():
    email = request.json['email']
    senha = request.json['senha']

    try:
	    new_account = LoginTable(email, senha)

	    db.session.add(new_account)
	    db.session.commit()

	    return jsonify({"status": True})
    except Exception as e:
    	return jsonify({"status": False})
