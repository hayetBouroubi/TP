# Master iLORD - Tests et intégration de logiciels distribués 

## Environnement de développement
Vous travaillez en binôme avec des machines disposant des logiciels Git et IntelliJ.
Vous pouvez travaillez sur vos propres machines à condition d'installer ces deux logiciels :

- Git : https://git-scm.com/downloads
- IntelliJ IDEA édition **Utimate** : https://www.jetbrains.com/idea/#chooseYourEdition

## Modalités d'évaluation

Les TPs donnent lieu à une note construite sur la base : 

- de votre assiduité et de votre attitude en TP ;
- de vos contributions sur le projet qui seront révélées par l'historique des commits sur votre projet Github.
 
## TP1 - Découverte de l'environnement de travail

### 1. Création d'un compte Github et récupération du projet "AssessedCompetencies"

- Rendez vous sur le plateforme Web [Github](https://github.com/) et créez un compte sur la plateforme.
- Rendez vous sur le devoir correspondant à nos [travaux pratiques](https://classroom.github.com/g/XlBQK3HL).
- *Clonez* le projet dans votre espace de travail en utilisant la commande *git clone https://..."*

Dans la suite du TP, le terme "M1" désigne le premier membre de votre binôme et "M2" désigne le deuxième membre du binôme. Les énoncés des 
questions préfixés par "M1:" sont à réaliser par M1 uniquement alors que les énoncés préfixés par "M2:" sont à réaliser par M2 uniquement.

- M1: Créez la branche *develop* dans votre repository local et *pushez* la branche sur Github à l'aide de la commande suivante :
*"git push -u origin develop"* . 
- M2: Récupérez la branche develop qui a été créee sur Github à l'aide de la commande suivante : *"git pull origin develop"*
- Ouvrez le projet avec IntelliJ.

### 2. Premiers pas avec Maven

- Étudiez la structure du projet ainsi que le fichier pom.xml.
- Construisez le projet et lancez les tests avec Maven.
- Lancez les tests avec IntelliJ.
- Construisez le site maven du projet et parcourez le contenu du site créé.
- Consultez le rapport de couverture du code par les tests.

### 3. Premiers pas avec Spring-Boot et la notion de "repository"

- Étudiez le code source du projet.
- Appuyez vous sur la documentation de [Spring Data JPA](http://docs.spring.io/spring-data/jpa/docs/1.11.0.M1/reference/html/) pour comprendre le code de l'application.
- Complétez l'application de telle sorte que le service *CompetenceService* permette la sauvegarde d'un objet de type Categorie (ajout de la méthode *saveCategory(Category cat)*) puis d'un objet de type Comptence (ajout de la méthode *saveCompetence(Competence comp)*).
- À l'issue de votre travail la couvertude du code par les tests doit être supérieure à 90% ; les tests doivent tester les cas de succès, les cas d'erreur, etc.

## TP2 - Mise en place de l'intégration continue

### 1. Mise en place de Travis CI

- Créez un compte sur la plateforme [Travis-CI](https://travis-ci.org/) en vous authentifiant via votre compte Github.
- En vous appuyant sur la [documentation de Travis-CI](https://docs.travis-ci.com/), faites en sorte que votre projet déclenche
l'exécution des tests de manière automatique sur Travis-CI.

### 2. Mise en place de Coveralls

- Créez un compte sur la plateforme [Coveralls](https://coveralls.io/) en vous authentifiant via votre compte Github.
- Mettez en place le [plugin maven](https://github.com/trautonen/coveralls-maven-plugin) permettant d'interfacer un projet Maven avec Coveralls.
- Modifiez votre fichier de configuration travis pour qu'en cas de succès, le rapport des tests cobertura soit envoyé sur Coveralls.
- Testez votre configuration et visitez les différents rapports Coveralls de votre projet.

## TP3 - Développement d'un Web Services REST et déploiement sur Heroku

### 1. Développement d'un Web Services REST

- Complétez votre application de telle sorte qu'à son démarrage plusieurs compétences soient enregistrées dans la base de données.
- Complétez la classe CompetenceService de telle sorte qu'elle contienne la méthode dont la signature est la suivante : *public List<Competence> findAllCompetences()*.
Vous pourrez vous appuyer sur le *CompetenceRepository* en vous inspirant du [guide Spring Boot adapté](https://spring.io/guides/gs/accessing-data-jpa/).
- Créez un Web service *RESTful* qui expose l'opération *findAllCompetences* de votre service et accessible via l'URL *http://<serveur hébergeant l''application>:<port>/competences*. 
Vous pouvez vous inspirez du [guide Spring boot adapté](https://spring.io/guides/gs/rest-service/).
- Lancez votre appication localement et vérifiez que vous accédez bien à la liste des compétences en vous connectant à l'URL [http://localhost:8080/competences](http://localhost:8080/competences)

### 2. Déploiement sur Heroku
Heroku est une plateforme permettant d'héberger des applications Web. Il est possible de créer un compte et de déployer une application gratuitement pour un usage restreint. 
L'objectif de cette partie du TP est de déployer automatique  votre application sur la plateforme Heroku en cas de succès du *build* sur Travis.

- Créez un compte sur Heroku.
- Mettez en oeuvre le déploiement de votre application sans passer par Travis en vous inspirant de
 [la documentation Heroku pour le déploiement d'application Spring Boot](https://devcenter.heroku.com/articles/deploying-spring-boot-apps-to-heroku). 
- Une fois le déploiement "manuel" opérationnel, mettez en oeuvre le déploiement automatique via Travis en vous appuyant sur [la documentation Travis ad-hoc](https://docs.travis-ci.com/user/deployment/heroku/). 
- Vérifiez que l'application se déploie bien automatiquement via Travis. 

## TP 4 - Écriture d'un client JavaFX 

JavaFX est un ensemble de packages Java permettant de construire des applications clientes riches. 

L'objectif est ici de construire une application JavaFX qui affiche 
la liste des compétences exposées par le Web service REST développé dans le TP 3.
Ce travail est un travail exploratoire et peu guidé. Seules les exigences clés sont fournies :

1. Le code source de votre application est gérée via Git et Github. Le repository de votre application sur Github est accessible via
[le lien d'invitation Github](https://classroom.github.com/g/8SVjlwP3)
2. L'application cliente est développée sous la forme d'un projet Java Maven dans IntelliJ.
3. Les tests sur l'application doivent être réalisés avec le framework de test Spock.
4. Les tests unitaires permettront de tester certaines parties de l'application sans avoir à lancer l'appication serveur (utilisation de "Mock objects" requise).
3. Travis-CI et Coveralls doivent être mis en œuvre sur ce projet.
4. La couverture du code par les tests automatisés unitaires sur votre projet doit être maximale (seule les parties interfaces 
utilisateur ne feront pas l'objet de tests).



 