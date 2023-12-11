#JeuDeLaVie

Projet ESGI dans le cadre du cours de Design Pattern.

Ce projet propose une liste de fonctionnalités en lien avec le jeu de la vie telles que :

- Définir la taille du plateau de jeu

- Définir les règles du jeu(nombre min/max de cellules pour la survie + nombre de cellules pour la création de cellules)

- Définir la couleur des cellules

- Définir la vitesse d'affichage des générations

Pour lancer le code il suffit d'exécuter la fonction main.

Pour ce faire, 3 designs patterns ont été implémentés :

- Singleton (Class: Data)

- Observer (Class: Algo, Cellule, Listerner Interface: Observer)

- Command (Class: CommandButton, CommandColor, CommandGrid, CommandRules, Fenetre Interface : Command)



Le design pattern Singleton a été implémenté afin de faciliter le stockage ainsi que la réutilisation des données de jeu telles que les options ou même les données du tableau de jeu. L'instanciation unique permet aussi de gagner en mémoire.

Le design pattern Observer permet de mettre à jour tous les états des cellules lorsque la prochaine génération a fini d'être calculée.

Le design pattern Command permet de simplifier le code de l'interface utilisateur. Les différentes fonctionnalités sont reparties en 4 thèmes :
État du jeu
-Taille de tableau
-Règles du jeu
-Couleur des cellules
