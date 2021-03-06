# Trip Pricer sample

## WARNING FOR MAVEN USERS: THE 'TARGET' FOLDER IS REPLACED BY A FOLDER NAMED 'BUILD'
This is for two reasons:
- the first is that 'build' is more accurate than 'target'.
- the second is that it is the same as gradle.  
We can say that we killed two birds with one stone.

## Summary
1. [Description](#Description)
2. [Planning of the workshop](#Planning-of-the-workshop)
3. [Take-away](#Take-away)
4. [Requirements](#Requirements)
5. [Plan](#Plan)

## Description
Even if many have heard of it but few have seen it, the hexagonal architecture is not an Arlesian.
The goal here will be to show everyone, both beginners and experts, that this architecture is really simple to implement.
It has many advantages:

- separation of business and technical code,
- establishment of a Domain Specific Language,
- testability of the business code,
- scalability of the technical code relating to infrastructure,
- facility for technological monitoring.

In short, everything is good in hexagonal architecture.

The result of this workshop was implemented on new projects in the banking sector. This made it possible to avoid recurring pitfalls on the testability and quality of the developed code ^^.

## Planning of the workshop
This three-hour session will be divided as follows:

- a presentation of 30 minutes maximum alternating definition of each of its concepts and their implementation in a Java project.
- a kata of 60 minutes max on a business domain to be used in the next part
- implementation for 60 minutes max of adapters showing the power and simplicity of this architecture.
- 15 minutes of Q / A and concept development

## Take-away
- Of course the concept(s) of hexagonal architecture ^^.
- For the implementation of this architecture, we will use Cucumber to play tests in natural language format. If you know little or nothing about Cucumber, this will also be the time to learn more about it,
- You will also be able to generate a living documentation based on the previous part: runnable specification by examples,  
- Use of shell scripts called in a Makefile to simulate the stages/jobs of a CI/CD pipeline.

## Requirements
Regarding your development environment, you will need to have on your machine
- a jdk 17 minimum
- be able to execute Makefile
- In case you want to use docker and kubernetes please, install the docker daemon and the kubernetes client.

In terms of knowledge:
- Java project based on Maven and/or Gradle
- Docker and/or Kubernetes if you want to use it
- Bash for understanding the scripts and make it evolve

If you do not want to weigh down your machine, support via GitPod is possible.
## IF you use GitPod execute the followng command to have the correct JDK: 'sdk install java 17-open && sdk default java 17-open'

##  __It is advised to run the following command on the master branch: make ci__
This will allow you to download the project's dependencies in advance.
Convenient when the wifi connection or the 4G network is weak.

## Plan
### 1 domain module
In this module, you will develop the component of your business. There is no technical code.
Two branches:
- domain_without_code: branches with steps to implement in the Cucumber glue code
- domain_with_code: code with a possible solution

You start by doing your business like a kata. After that you add an interface representing a port (a java interface).
This port is an intent to provide elements/data to the domain (repository) or help deliver message (recipient).
This port will in a second part be faked into the test part (glue code).

### 2 repository module
In this module, you will develop some technical code driven by the domain based on the port of the domain. 
There is pure technical code (database access, sending message, ...) with no business logic.
Two branches:
- repository_without_code: branch with empty integration tests. An implementation with hard coded values can be done in TDD mode. SpringData and JDBCTemplate code are implemented.
- repository_with_code: code with a possible solution

### 3 application module
In this module, you will develop the links between the domain and the repository parts and some technical specificities needing this links.  
The specificities can be the transactional part for example.

Two branches:
- application_without_code: branches with steps to implement in the Cucumber glue code
- application_with_code: code with a possible solution

### 4 exposition module
In this module, you will develop what will drive the business from an external actor.  
For example, it can be rest api or web service server.  

Two branches:
- exposition_without_code: branches with steps to implement in the Cucumber glue code
- exposition_with_code: code with a possible solution









________________________________________________________________________________________________________________________

#### Description
M??me si beaucoup en ont entendu parler mais que peu l'ont vu, l'architecture hexagonale n'est pas une arl??sienne.  
Le but sera ici de montrer ?? tous, d??butants comme experts, que cette architecture est vraiment simple ?? mettre en ??uvre.  
Elle poss??de de nombreux avantages :
- s??paration du code m??tier et technique,
- mise en place d'un Domain Specific Language,
- testabilit?? du code m??tier,
- ??volutivit?? du code technique relatif ?? l'infrastructure,
- facilit?? pour faire de la veille technologique.

En bref, tout est bon dans l'architecture hexagonale.

Le r??sultat de ce workshop a ??t?? mis en place sur de nouveaux projets dans le milieu bancaire.  
Cela a permis d'??viter les ??cueils r??currents sur la testabilit?? et qualit?? du code produit ^^.

#### Planning
Cette session de trois heures sera d??coup??e comme suit :
- une pr??sentation de 30 minutes maximum alternant d??finition de chacun de ses concepts et leur impl??mentation dans un projet Java.
- un kata de 60 minutes max sur un domaine m??tier ?? utiliser dans la partie suivante
- impl??mentation pendant 60 minutes max d'adaptateurs montrant la puissance et n??anmoins simplicit?? de cette architecture.
- 15 minutes de Q/A et d'approfondissements des concepts

####  Take-away
- Bien entendu le(s) concept(s) de l'architecture hexagonale ^^.
- Pour la mise en place de cette architecture, nous utiliserons Cucumber pour jouer des tests au format langage naturel. Si vous ne connaissez pas ou peu Cucumber, ce sera aussi le moment d'en apprendre plus sur le sujet.
- Utilisation de scripts shell appel?? dans un Makefile pour simuler les stages/jobd d'une pipeline de CI/CD.

#### Pr??-requis
Concernant votre environnement de d??veloppement il vous faudra avoir sur votre machine
- un jdk 17 minimum
- ??tre capable d???ex??cuter des Makefile
- Si vous souhaitez utiliser docker et kubernetes, veuillez installer le d??mon docker et le client kubernetes.

En terme de connaissances :
- Projet Java bas?? sur Maven et/ou Gradle
- Docker et/ou Kubernetes si vous souhaitez l'utiliser
- Bash pour comprendre les scripts et les faire ??voluer

Si vous ne souhaitez pas alourdir votre machine, la prise en charge en passant par GitPod est possible.

###  __Il est conseill?? d???ex??cuter la commande suivante sur la branche master : make ci__
Cela vous permettra de t??l??charger ne avance les d??pendances du projet.  
Pratique quand la connexion wifi ou le r??seau 4G sont de faible d??bit.
________________________________________________________________________________________________________________________


