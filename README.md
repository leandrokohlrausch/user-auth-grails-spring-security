# Sample Grails 4 Spring Security Authentication 

- Database postgresql
- Gradle 5.6.2 
- Grails 4.0.3
- Java JDK 11
- Spring security 4.0.0

Usage

* 1 - Open postgresql DB and create database 'user-auth_test-db';
* 2 - Create tables structure (file structure_db.sql has table design)
* 3 - Alter ./grails-app/conf/application.yml with username and password to access Database
* 4 - Command line inside project folder:
* grails clean
* grails compile
* grails run-app
* 5 - App listen on 8080 (if your not change)      


PS: JAVA_HOME and GRAILS_HOME need set.
