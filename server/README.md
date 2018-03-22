# Server REST API

Ce squelette d'application construit une API et 2 types d'interfaces :
- L'API au centre permet de manipuler l'ensemble des données
- Une interface graphique en javascript exploitant l'API
- Une interface graphique en html généré par le serveur

## Description de l'API

### Description des données d'une entreprise

Une entreprise est formatée dans le standard JSON.

Elle est de la forme :

```
{
	"name": <exemple>,
	"domain": <domain.fr>
}
```
Le champs "name" contient le nom unique de l'entreprise.

Le champs "domain" est le nom de domaine unique des emails de l'entreprise.

#### Créer une entreprise

| **Opération** | **URI**   | **Action**           | **Retourne** |
| ------------- |:---------:|:--------------------:|:------------:|
| POST          | /corp | Créer une entreprise | **201** si l'entreprise est créée ainsi que l'entreprise  <br/> **400** si les informations envoyées ne sont pas correctes |

#### Récupérer une entreprise par nom

| **Opération** | **URI**    | **Action**                             | **Retourne** |
| ------------- |:--------------:|:--------------------------------------:|:------------:|
| GET           | /corp/{name} | Retourne une entreprise de nom name | **200** si l'entreprise est trouvée ainsi que l'entreprise <br/> **404** si l'entreprise n'existe pas |

### Description des données d'un utilisateur

Une utilisateur est formaté dans le standard JSON.

Il est de la forme :

```
{
	"uno": <10>,
	"login": <exemple@domaine.fr>,
	"pass": <coucou12345>,
	"nom": <Dupont>,
	"prenom": <Jean>,
	"fonction": <Cadre>,
	"corp": <exemple>
}
```
Le champs "uno est le numéro automatique de l'utilisateur.

Le champs "login" est l'adresse email d'entreprise unique de l'utilisateur.

Le champ "pass" est le mot de passe de l'utilisateur.

Les champs "nom" et "prenom" contient le nom et prenom de l'utilisateur.

Le champs "fonction" contient la fonction de l'utilisateur dans son entreprise.

Le champs "corp" contient le nom de l'entreprise.

#### Créer un utilisateur

| **Opération** | **URI**   | **Action**           | **Retourne** |
| ------------- |:---------:|:--------------------:|:------------:|
| POST          | /register | Créer un utilisateur | **201** si l'utilisateur est créé ainsi que l'utilisateur<br/> **400** si les informations envoyées ne sont pas correctes |

#### Authentifier un utilisateur

| **Opération** | **URI**   | **Action**           | **Retourne** |
| ------------- |:---------:|:--------------------:|:------------:|
| GET          | /auth | Authentifier un utilisateur | **200** si l'utilisateur est trouvé ainsi que l'utilisateur <br/> **404** si l'utilisateur n'existe pas |
