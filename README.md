# offer-technical-test

# Présentation du projet Spring Boot JPA + H2

## Clone du projet dans votre repo local : 
  >cd ../localpath
  >git clone https://github.com/Amarasofiane/offer-technical-test.git
  
ensuite build maven run

## Base de données embarquée H2
Le modèle de donnée est créé à chaque lancement du projet via hibernate vous pouvez manager la BD H2 depuis le serveur après avoir lancé le projet http://localhost:8080/h2-console

Identifiant : "sa" // password = "password"

## API 
Il est conseillé d'avoir installé postman ci-dessous les différentes étapes afin de pouvoir interroger les different endpoint de l'api :

Intégrez le fichier postman collection Sofiane.postman_collection.json dans votre postman afin de générer les exemples de requête à effectuée sur l'api

## Endpoint :
- POST /api/users/register 
- GET  /api/users/email/{email}
- GET  /api/users/all
