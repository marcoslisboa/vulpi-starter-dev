# vulpi-starter-dev

## 8 DevStarter: Deploy Java Apps with Spring Boot

## Requirements
This app is build with Java 1.8.

## H2 Console - Memory Database
```
http://localhost:8080/h2-console
URL: jdbc:h2:mem:testdb
user: sa
pass:
```

## Swagger API Doc
```
http://localhost:8080/swagger-ui.html
```

## Run My Application
```
./mvnw spring-boot:run
```
or compile and execute
```
./mvnw clean install 
java -jar target/vulpi-starter-dev-0.0.1-SNAPSHOT.jar
```


## Deploy with Docker

#### Build Image
```bash
docker build -t vulpi-starter-dev:v1 .
```

#### List all Docker Local Images
```bash
docker images
```

#### Run Docker Container
```bash
 docker run -d -it -p 8080:8080 --name=vulpi-starter-container vulpi-starter-dev:v1
```

## Deploy with Docker Compose

#### Start
```bash
./docker-compose-start.sh
```

#### Stop
```bash
./docker-compose-stop.sh
```

#### Redeploy
```bash
./docker-compose-redeploy.sh
```

## Deploy Google App Engine
 
#### Install [Google Cloud SDK](https://cloud.google.com/sdk/?hl=pt-br)
```bash

curl https://sdk.cloud.google.com | bash

``` 

#### Login 
```bash
./google-cloud-sdk/bin/gcloud init
``` 
 
#### Deploy

```bash
./mvnw appengine:deploy
```

## Deploy Google Kubernetes Engine 

* Create [Google Cloud](https://cloud.google.com) Acoount
* Access Cloud Shell 
* Clone this Repository

#### Register and Push Docker Image
```bash
./mvnw com.google.cloud.tools:jib-maven-plugin:build -Dimage=gcr.io/$GOOGLE_CLOUD_PROJECT/vulpi-dev-starter:v1
```

#### Create Kubernetes Cluster
```bash
gcloud container clusters create dev-starter-cluster \
  --num-nodes 3 \
  --machine-type n1-standard-1 \
  --zone us-central1-a
```

#### Deploy Docker Image into Cluster
```bash
kubectl run vulpi-dev-starter \
  --image=gcr.io/$GOOGLE_CLOUD_PROJECT/vulpi-dev-starter:v1 \
  --port=8080
```

#### List Deployments
```bash
kubectl get deployments
```

#### List Pods
```bash
kubectl get pods
```

#### Scale
```bash
kubectl scale deployment vulpi-dev-starter --replicas=4
```

#### Allow Trafic (Expose Service)
```bash
kubectl expose deployment vulpi-dev-starter --type=LoadBalancer
```

#### List Service
```bash
kubectl get services
```

#### Release Docker Image
```bash
./mvnw com.google.cloud.tools:jib-maven-plugin:build -Dimage=gcr.io/$GOOGLE_CLOUD_PROJECT/vulpi-dev-starter:v2
```

#### Deploy Release Image
```bash
kubectl set image deployment/vulpi-dev-starter \
  vulpi-dev-starter=gcr.io/$GOOGLE_CLOUD_PROJECT/vulpi-dev-starter:v2
```

#### Roll back Deployments
```bash
kubectl rollout undo deployment/vulpi-dev-starter
```


## Guides
The following guides illustrate how to use some features concretely:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Validating Form Input](https://spring.io/guides/gs/validating-form-input/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Handling Form Submission](https://spring.io/guides/gs/handling-form-submission/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Building a RESTful Web Service with Spring Boot Actuator](https://spring.io/guides/gs/actuator-service/)
