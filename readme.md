Exercise for Sopra Steria
=========================
Calculator Microservice
=================

This application is a calculator POC version for Sanitas and Sopra Steria.

Contacts
========
* dlopezo@gmail.com

Dependencies
============
* Java 11
* Apache Maven

Building
========
````sh
mvn clean install
````
## Run
```sh
mvn spring-boot:run
```

Using calculator
================
Open your browser and type this url `localhost:8081/sopracalc/operation/{Type Operation}/{Number 1}/{Number 2}`

Only use the follow type operation: `sum` and `sub`
Example:
[calculator sum 100+100](http://localhost:8081/sopracalc/operation/sum/100/100)

Note: Maximum five decimal places