# Discount Store

This is a simple SpringBoot application that implements a discount service for a Retail Store.

# Info
* The application is intialise using https://start.spring.io/
* The application is an example of MVC restservices
* The application uses H2 in memory database to store the users and items/products
* The h2 db console is published under the URL http://localhost:9090/h2-console
* The application is build on Java 1.8
* The unit testing is done with a mindset to have a code coverage of above 80%


## Swagger API Specs

Swagger API documentation specs are auto-generated when the server runs. The specs will be published under the URL http://localhost:9090/swagger-ui.html#/

## Installing

After checking out the git repo run the following maven command

```bash
mvn install
```

This should install all packages, run all unit tests and exit successfully

## Starting

To start the server please run the following maven command

```bash
mvn spring-boot:run
```

## Testing

To execute the unit tests against the business logic service classes please run the following maven command

```bash
mvn test
```

## Testing

*Rest api- testing is doing using postman
Sample request
[![Run in Postman](https://run.pstmn.io/button.svg)](https://app.getpostman.com/run-collection/a08bac24b9bf465da1da)

![alt text](https://github.com/hissamus/discount-demo/blob/master/src/main/resources/static/Capture1.JPG)
![alt text](https://github.com/hissamus/discount-demo/blob/master/src/main/resources/static/Capture2.JPG)
![alt text](https://github.com/hissamus/discount-demo/blob/master/src/main/resources/static/Capture3.JPG)
