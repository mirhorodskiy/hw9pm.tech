## Compose sample application
### Java application with Spring framework and a Postgres database

Project structure:
```
.
??? hw9
?   ??? docker-compose.yaml
?   ??? Dockerfile
?   ??? BUILD.md
??? ??? ...


```

[_docker-compose.yaml_](docker-compose.yaml)
```
version: "3.7"
services:
  backend:
    build: ./
    ports:
      - 8080:8080
    networks:
      - myApp

networks:
  myApp:
```
The compose file defines an application with one service `backend`.
When deploying the application, docker-compose maps port 8080 of the backend service container to port 8080 of the host as specified in the file.
Make sure port 8080 on the host is not already being in use.

## Deploy with docker-compose

```
$ docker-compose up -d
docker-compose up -d            
Creating network "hw9_myApp" with the default driver
Creating hw9_backend_1 ... done
```

## Expected result

Listing containers must show the container running and the port mapping as below:
```
 docker ps
CONTAINER ID   IMAGE         COMMAND                  CREATED              STATUS              PORTS                                       NAMES
c6a0fc9880aa   hw9_backend   "java -cp app:app/li?"   About a minute ago   Up About a minute   0.0.0.0:8080->8080/tcp, :::8080->8080/tcp   hw9_backend_1
     Up 28 seconds       0.0.0.0:8080->8080/tcp   spring-postgres_backend_1
```



Stop and remove the containers
```
docker-compose down
Stopping hw9_backend_1 ... done
Removing hw9_backend_1 ... done
Removing network hw9_myApp

```
