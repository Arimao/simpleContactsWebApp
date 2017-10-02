# Simple Contacts App

This is a simple contacts app developed using Spring MVC, Maven and Hibernate with Java.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

```
Tomcat 9
MySQL 5
```

### Installing

Under `src\main\resources\application.properties` set up your MySQL settings.

```
#Database related properties
database.driver=com.mysql.jdbc.Driver
database.url=jdbc:mysql://localhost:3306/testDB
database.user=root
database.password=pass
```

For testing purposes hbm2ddl.auto is set to create-drop, which means after you close the live session, all of the data will be erased. You can also change this in properties file.

```
hibernate.hbm2ddl.auto=create-drop
```

After you're done setting it up just run it through your IDE with Tomcat and navigate to Tomcat homepage. http://localhost:8080

## Built With

* [Spring MVC](https://spring.io/) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [Hibernate](http://hibernate.org/) - Used to generate persistent data

As my IDE I have used IntelliJ IDEA as it seemed to have the most features and easy-to-use interface. Maven made dependency management really easy. In general Spring made it really easy to build the system. I was also able to use .jsp files with MVC.