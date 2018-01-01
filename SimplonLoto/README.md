# java-web-Loto

Projet simple utilisable pour présenter Java Web et plus précisément les servlets et les JSP.

## Présentation

Il s'agit d'une interface permettant de valider en ligne un billet de loto. L'utilisateur saisie son nom, son prénom et le numéro du ticket. Le système stocke aussi la date et l'heure de validation du formulaire. Un système de gestion d'erreur basique a été implémenté :
* En cas de non remplissage d'un champ
* En cas d'utilisation d'un même numéro de ticket plusieurs fois

Après un validation d'un formulaire avec des valeurs correctes, un message récapitulatif est affiché. Il est aussi possible d'afficher un tableau récapitulatif de l'ensemble des tickets ayant été enregistrés avec les informations associées.

Les données sont stockées en cache de manière volatile (effacement à chaque redémarrage du serveur).

## Aspect pédagogique

Ce projet a été pensé pour servir de base à une étude de code sur les servlets, JSP et les entités associées. 

Il peut aussi être utilisé comme projet de base pour la mise en place d'une persistence en base de donnée.
