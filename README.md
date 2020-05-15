# projet-annuaire-electronique

à faire dans un nouveau projet :
On souhaite implémenter un annuaire électronique, qui donne pour chaque nom de contact,
ses coordonnées (N°tel & Adresse).
1) Définir la classe Coordonnees, composée des 2 attributs tel et adr.
2) Définir la classe Annuaire qui gère l’annuaire électronique à l’aide d’une collection de type HashMap.
Cette collection associe à chaque nom (personne), un objet de type Coordonnees.
La classe Annuaire implémente les méthodes suivantes :
- ajout (String n, Coordonnees c) : Ajout d’un nouveau contact
- affichCoord (String n): Affichage des coordonnées d’un contact donné.
- modifCoord (String n, Coordonnees c): Modification des coordonnées d’un contact donné.
- suppression (String n): Suppression d’un contact donné.
- listerNoms (): Affichage de la liste des contacts (tous les noms).
- listerTel ():Affichage de la liste des N°de Tel disponibles dans l’annuaire.
- listerAdr ():Affichage de la liste des Adresses disponibles dans l’annuaire.
- affichAnnuaire ():Affichage de la totalité de l’annuaire (nom : tel, adresse) dans l'ordre croissant des noms.
- statistiques () : Affiche le nombre de contact pas type de numéro ( voir les types dans les contraintes )
3) Écrire un programme principal, présentant un menu pour la gestion d’un annuaire électronique.
 le menu interactif contient les actions suivantes, selon le nombre saisi :
 0 - quitte l'application.
 1 - ajout personne à l'annuaire
 2 - affichage coordonnée d'une personne.
 3 - modification coordonnées
 et toutes les autres actions 
vous pouvez avoir des sous-menu
contraintes :
- une personne n'est présente qu'une seule fois dans l'annuaire.
- un numéro de téléphone n'est présent qu'une seule fois dans l'annuaire.
- le numéro de téléphone est composé de 10 chiffres et commence par l'un des cas :
-- 06 : terminaux mobiles.
-- 08 : numéros à tarification spéciale.
-- 03 : numéros fixes.
- les numéros de téléphones sont affichés sous le format : XX.XX.XX.XX.XX
4) Ultra plus ;-)  et à faire dans un autre package.
refaire le même exercice en mettant comme clé pour la hashMap un nouveau type Personne (attributs nom + prénom + id)
