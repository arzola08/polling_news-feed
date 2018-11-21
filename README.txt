
1. Running this script in order to create the accurate database (news_feed):

     news_feed-dump.sql

    -The table items will be created automatically by the system at the runtime based on the
    entity class

2. Modifying user credentials for the local database in the properties file:

    # Username
    spring.datasource.username = ""
    # Password
    spring.datasource.password = ""

    src/main/resources/application.properties

3. Generating .jar and launching

     mvn clean package

     java -jar target/polling-news-feed-1.0-SNAPSHOT.jar

* just running below class (possible from the IDE) is also possible to start the application
 src\main\java\com\javacode\App.java
 

 ToDo: to add proper tests and exceptions treatment
