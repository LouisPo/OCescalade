# OCescalade
Pour l'application

1er: définir un serveur dans Eclipse, on utilise un wizard afin de créer un serveur Tomcat v8. Puis, sélectionnez le JRE qui est le JRE v1.8.

2eme: créer un projet maven sous eclipse. Puis on rajoute les librairies Mysqlconnector afin de pouvoir se connecter à une base de donnée,
 puis les librairies hibernate. Dans le fichier pom.xml, on va créer la dépendance Mysql afin que l'application puisse être connecter à la BDD du projet.

3eme:Se placer sur la racine du projet en cours, puis faire un import de tous les fichiers dans l'application courante.

4eme: Faire un maven-clean et maven-install à la base du projet.

5eme: run SpringbootcrudapiApplication.java.

6eme: Dans le navigateur, rentrez l'URL http://localhost:8080/homeOcescalade.

Pour la BDD

1er: installer phpmyadmin et mysql.

2:emeCréer une nouvelle base, nommée la ocescalade

3eme: configurer le port de la bdd sur 3306.

4eme: cliquez sur l'onglet import, puis cliquez sur le bouton parcourir et choisissez le document ocescalde.sql.

5eme: vérifier que le jeu de caractére du fichier soit utf-8, puis cliquer sur exécuter.