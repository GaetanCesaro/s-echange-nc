# S-ECHANGE-NC

Service backend pour Echange.nc - SpringBoot/GraphQL

## Build
- Build de l'image de container via **Google Cloud Build** :
```
gcloud builds submit --tag gcr.io/echangenc/s-echange-nc
```

## Run
- Run en local du projet Spring-boot via Maven
```
./mvnw spring-boot:run
```

## Déploiement
- Deploy vers Google Cloud Run
```
gcloud beta run deploy s-echange-nc --image gcr.io/echangenc/s-echange-nc --platform managed --allow-unauthenticated
```
NB : A la création uniquementOptionel :
``` 
--region asia-east1
```

## Usefull URLs
- [Console GraphIQL](http://localhost:8080/graphiql)
- [GraphQL schema](http://localhost:8080/graphql/schema.json)
- [H2 Console](http://localhost:8080/h2-console)





