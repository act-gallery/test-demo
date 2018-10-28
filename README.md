# ActFramework Automate Test Demo

This application demonstrates how to write automate test scenario

## Start the application

Start the application in dev mode

```
mvn clean compile act:run
```

Run automate test

```
mvn clean compile act:test
```

Start the application in prod mode

```
mvn clean package
cd target/dist
tar xzf *.gz
./run
```

