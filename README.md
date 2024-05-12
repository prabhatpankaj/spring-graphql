* To compile the maven project we can use the command

```
mvn clean install
```

* Navigate to the root of the project via command line and execute the command

```
kill -9 $(lsof -ti :9091) && mvn spring-boot:run
```

* run migration via flyway

* Make sure to place this SQL script in your Flyway migrations directory with an appropriate version prefix (e.g., V1__create_models_table.sql) and Flyway will execute it during the application startup.

```
mvn flyway:migrate -Dflyway.url=jdbc:mysql://localhost:3306/superapp -Dflyway.user=root -Dflyway.password=root
```
