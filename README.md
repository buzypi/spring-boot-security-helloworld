This project shows a fully functioning Spring Boot application which demonstrates how to build an authentication service in your web application. The application makes use of users in a MySQL database to authenticate and decide whether the requesst must be allowed or not.

# Running this application
1. Create a database and a user using the following commands:
```
CREATE DATABASE contactsdb;
CREATE USER 'john'@'localhost' identified by 'yourpasswordhere';
GRANT ALL ON contactsdb.* to 'john'@'localhost';
```

2. Import this project into Eclipse or Visual Studio Code

3. Configure application.properties with the appropriate values
4. Run the DemoApplication from your IDE
5. Access your application at: [http://localhost:8080/](http://localhost:8080/)
6. Login with user admin or user with the credentials (currently hard-coded in DemoApplication.java)