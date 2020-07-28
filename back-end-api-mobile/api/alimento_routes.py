from flask import Flask, request, jsonify, Blueprint
from flask_sqlalchemy import SQLAlchemy
from __init__ import db
from models import AlimentosTable, BairroTable
import datetime

bp_alimentos = Blueprint('alimentos', __name__)

@bp_alimentos.route('/alimentos', methods=['POST'])
def create():
    nome_bairro = request.json['bairro']
    alimento = request.json['alimento']
    validade = request.json['validade']

    data = '01/'+validade

    validade = datetime.datetime.strptime(data,'%d/%m/%y')
    bairro = BairroTable.query.filter_by(nome_bairro=nome_bairro).first()

    new_alimento = AlimentosTable(alimento, validade, bairro.id)

    db.session.add(new_alimento)
    db.session.commit()

    return jsonify({"message":"Alimento cadastrado com sucesso!"})

@bp_alimentos.route('/alimentos/<idBairro>', methods=['GET'])
def show_ball(idBairro):

    all_alimentos = AlimentosTable.query.filter_by(ali_idbairro=idBairro).all()

    output = []
    cont = 0

    for a in all_alimentos:
        validade = all_alimentos[cont].validade
        validade = validade.strftime('%m/%y')
        output.append({'alimento':all_alimentos[cont].nome_alimento, 'validade':validade})
        cont = cont + 1

    return jsonify(output)
    