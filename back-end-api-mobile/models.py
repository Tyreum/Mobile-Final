from flask_sqlalchemy import SQLAlchemy
from __init__ import db

class LoginTable(db.Model):
    __tablename__ = 'login'

    id =  db.Column(db.Integer, primary_key=True)
    email = db.Column(db.String(40), nullable=False, unique=True)
    senha = db.Column(db.String(20), nullable=False)

    def __init__(self, email, senha):
        self.email = email
        self.senha = senha

class BairroTable(db.Model):
    __tablename__ = 'bairro'

    id = db.Column(db.Integer, primary_key=True)
    nome_bairro = db.Column(db.String(30), nullable=False, unique=True)

    #Relacionamentos
    fk_alimento_bairro = db.relationship('AlimentosTable', backref='alimento_bairro')


    def __init__(self, nome_bairro):
        self.nome_bairro = nome_bairro

class AlimentosTable(db.Model):
    __tablename__ = 'alimentos'

    id = db.Column(db.Integer, primary_key=True)
    nome_alimento = db.Column(db.String(30), nullable=False)
    validade = db.Column(db.DateTime, nullable=False)
    ali_idbairro = db.Column(db.Integer, db.ForeignKey('bairro.id'))

    def __init__(self, nome_alimento, validade, ali_idbairro):
        self.nome_alimento = nome_alimento
        self.validade = validade
        self.ali_idbairro = ali_idbairro