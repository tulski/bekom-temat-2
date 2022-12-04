from flask import Flask, request, send_file
import os

app = Flask(__name__)

@app.route('/static', methods=['GET'])
def get_file():
    assets = os.path.abspath('assets')
    file = request.args.get('file')
    path = assets + '/' + file
    print(path)
    return send_file(path)

if __name__ == "__main__":
 app.run(debug=True,host="0.0.0.0")


    
