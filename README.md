# exercise

Description  :
 
Un fichier de log contient des lignes avec du texte séparé par un espace, formatées comme ceci:
 
<timestamp unix> <hostname> <hostname>
 
Par exemple:
 
1366815793 quark garak
1366815795 brunt quark
1366815811 lilac garak
 
Chaque ligne correspond à une connexion, depuis un serveur (<hostname> à gauche) vers un autre serveur (<hostname> à droite) à un instant donné. 
 
Les lignes sont approximativement triées par timestamp. L'approximation est de l'ordre de 5 minutes.
 
Le programme doit produire à chaque heure:
* la liste des serveurs qui ont été connectés à un serveur donné durant cette heure
* la liste des serveurs auxquels un serveur donné s'est connecté durant cette heure
* le serveur qui a généré le plus de connections durant cette heure
 
Le nombre de lignes dans le fichier de log peut être très important. Considérez une implémentation performante vis à vis du CPU et de la mémoire. 
