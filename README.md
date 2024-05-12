* To compile the maven project we can use the command

```
mvn clean install
```

* Navigate to the root of the project via command line and execute the command

```
kill -9 $(lsof -ti :9091) && mvn spring-boot:run
```