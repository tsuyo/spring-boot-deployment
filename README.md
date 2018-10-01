# Spring Boot + Maven Deployment Best Practice

Your Spring Boot application is typically deployed to many environments like Dev, QA, Production.
Each environment has each configurations (properties).
Spring Boot in combination with Spring Profile, Maven Profile and @ConfigurationProperties
forms some typical best practices and here is a sample skelton.

## How to use
To run/package the app with default config (application.properties), execute the followings
```
$ ./mvnw spring-boot:run
...
2018-10-01 14:46:08.741  INFO 10582 --- [           main] c.g.t.s.SpringBootDeploymentApplication  : title: title
2018-10-01 14:46:08.742  INFO 10582 --- [           main] c.g.t.s.SpringBootDeploymentApplication  : player: QuestProperties.Player(name=name0, level=0)
2018-10-01 14:46:08.742  INFO 10582 --- [           main] c.g.t.s.SpringBootDeploymentApplication  : player: QuestProperties.Player(name=name1, level=1)
2018-10-01 14:46:08.742  INFO 10582 --- [           main] c.g.t.s.SpringBootDeploymentApplication  : prop: key0=val0
2018-10-01 14:46:08.742  INFO 10582 --- [           main] c.g.t.s.SpringBootDeploymentApplication  : prop: key1=val1
...
$ ./mvnw -DskipTests clean package                           # build a package with default config
$ java -jar target/spring-boot-deployment-0.0.1-SNAPSHOT.jar # the same output above
```
To run/package the app with production config (application-prod.properties), execute the followings
```
$ ./mvnw -Pprod spring-boot:run
...
2018-10-01 14:52:54.247  INFO 10760 --- [           main] c.g.t.s.SpringBootDeploymentApplication  : title: title-prod
2018-10-01 14:52:54.248  INFO 10760 --- [           main] c.g.t.s.SpringBootDeploymentApplication  : player: QuestProperties.Player(name=name0-prod, level=20)
2018-10-01 14:52:54.248  INFO 10760 --- [           main] c.g.t.s.SpringBootDeploymentApplication  : player: QuestProperties.Player(name=name1-prod, level=21)
2018-10-01 14:52:54.248  INFO 10760 --- [           main] c.g.t.s.SpringBootDeploymentApplication  : prop: key0=val0-prod
2018-10-01 14:52:54.248  INFO 10760 --- [           main] c.g.t.s.SpringBootDeploymentApplication  : prop: key1=val1-prod
...
$ ./mvnw -DskipTests -Pprod clean package                    # build a package with production config
$ java -jar target/spring-boot-deployment-0.0.1-SNAPSHOT.jar # the same output above
```