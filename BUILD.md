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
docker-compose up -d
Creating network "hw9_myApp" with the default driver
Creating hw9_db_1      ... done
Creating hw9_backend_1 ... done

```

## Expected result

Listing containers must show the container running and the port mapping as below:
```
 docker ps
CONTAINER ID   IMAGE           COMMAND                  CREATED              STATUS              PORTS                                       NAMES
e9eb3eeb233e   93b04afc7e48    "java -cp app:app/li?"   About a minute ago   Up About a minute   0.0.0.0:8080->8080/tcp, :::8080->8080/tcp   hw9_backend_1
8e024434ff0d   oscarfonts/h2   "/bin/sh -c 'java -c?"   About a minute ago   Up About a minute   81/tcp, 1521/tcp, 0.0.0.0:63932->8081/tcp   hw9_db_1

```

After the application starts, navigate to ```http://localhost:8080/employees/getEmployeeByManager?managerName=Myrhorodskyi``` in your web browse or run:
```
C:\Users\work>curl localhost:8080/employees/getEmployeeByManager?managerName=Myrhorodskyi
{"message":"Manager with that name not exists","dateOfError":"05/09/2021 22:29:45"}
```


Stop and remove the containers
```
docker-compose down
Stopping hw9_backend_1 ... done
Stopping hw9_db_1      ... done
Removing hw9_backend_1 ... done
Removing hw9_db_1      ... done
Removing network hw9_myApp


```
