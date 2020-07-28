from flask import Flask
from __init__ import app
from api.bairro_routes import bp_bairro
from api.login_routes import bp_auth
from api.alimento_routes import bp_alimentos

app.register_blueprint(bp_bairro)
app.register_blueprint(bp_auth)
app.register_blueprint(bp_alimentos)


if __name__ == '__main__':
    app.run()