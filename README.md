# JeuDeLaVie

Projet ESGI dans le cadre du cours de Design Pattern.





Ce projet propose une liste de fonctionnalité en lien avec le jeu de la vie tel que :

- Définir la taille du plateau de jeu

- Définir les règles du jeu (nombre min/max de cellules pour la survie + nombre de cellule pour la création de cellule)

- Définir la couleur des cellules

- Définir la vitesse d'affichage des générations



Pour se faire 3 designs patterns ont été implémentés :

- Singleton (Class : Data)

- Observer (Class : Algo, Cellule, Listerner Interface : Observer)

- Command (Class : CommandButton, CommandColor, CommandGrid, CommandRules, Fenetre Interface : Command)



Le design pattern Singleton a été implémenté afin de faciliter le stockage ainsi que la réutilisation des données de jeu tel que les options ou même les données du tableau de jeu. L'instanciation unique permet aussi de gagner en mémoire.

Le design pattern Observer permet de mettre a jour tous les etats des cellules lorsque la prochaine génération a fini d'étre calculée

Le design pattern Command permet de simplifier le code de l'interface utilisateur. Les differentes fonctionalités sont repartie en 4 themes :
- Etat du jeu
- Taille de tableau
- Regles du jeu
- Couleur des cellules

