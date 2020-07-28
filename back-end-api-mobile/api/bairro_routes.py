from flask import Flask, request, jsonify, Blueprint
from flask_sqlalchemy import SQLAlchemy
from __init__ import db
from models import BairroTable

bp_bairro = Blueprint('bairro', __name__)

@bp_bairro.route('/bairro', methods=['POST'])
def create():
    nome = request.json['nome']

    new_bairro = BairroTable(nome)

    db.session.add(new_bairro)
    db.session.commit()

    return jsonify({'message':'Bairro inserido com sucesso!', 'status':200})

@bp_bairro.route('/bairro', methods=['GET'])
def show_all():

    all_bairros = BairroTable.query.all()

    output = []
    cont = 0

    for b in all_bairros:
        output.append({"id":all_bairros[cont].id,"nome":all_bairros[cont].nome_bairro})
        cont = cont + 1
    
    return jsonify(output)

@bp_bairro.route('/bairro/<id>', methods=['GET'])
def show_by_id(id):
    
    bairro = BairroTable.query.get(id)

    output = {"id":bairro.id,"nome": bairro.nome_bairro}

    return jsonify(output)
    