# Bank Account Kata
L'énoncé original est disponible à l'adresse https://github.com/kirinux/ing-bank-account-kata.

## Environnement technique
* Java 14
* Base de données PostgreSQL 12.3
* Serveur Apache Tomcat 7.0
* Maven 3.6.3

Développé sur IntelliJ.

## Architecture du projet
Le projet se découpe en 4 modules :
* le module **bank-account-kata-business** qui contient les interfaces et classes Manager sur lesquelles reposent la logique métier de l'application
* le module **bank-account-kata-consumer** qui permet d'interagir avec les services extérieurs (base de données) grâce aux DAO
* le module **bank-account-kata-model** qui contient les beans
* le module **bank-account-kata-webapp** qui comporte l'application web

## Lancement du projet et tests
### Base de données
Un fichier scripts.sql est disponible à la racine du projet. Il permet de créer les tables nécessaires au fonctionnement du projet et contient un jeu de données.
L'accès à la base de données (DB_BANK) se fait grâce au login "postgres" et au mot de passe "admin" sur l'url jdbc:postgresql://localhost:5432/DB_BANK.

### Interface utilisateur
Une fois le projet déployé, l'interface est accessible à l'adresse http://localhost:8080/bank-account-kata-webapp.

### Tests unitaires
Des tests sont disponibles dans le module **bank-account-kata-webapp**.
