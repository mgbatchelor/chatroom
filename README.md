NationBuilder Chatroom
=============

Code Design
------------

The code follows a simple design.  Each chat event extends the same abstract class, and implements the formatEvent in their own way, adding additional copy for the event type.  The group and summary events were able to extend the same abstract class in order to display the contents on the same view.

The view depends on the events to provide all of the formatting for each of the events.

Test Cases
——--------
There were a few parts of the implementation that needed test cases.

### ChatEventFactoryTest
This test suite tests that the factory would create the appropriate event object provided valid event types.

### ChatEventTest
This test suite tests all of the formatting for each of the history-based chat events: Comment, High-five, enter, and exit.

### ChatSummaryEventTest
This test suite tests that each of the history events would be formatted correctly, and the correct plural tense for the ‘people/person’ and ‘comment/comments’.

### ChatSummaryGroupTest
This test suite tests the formatting for a time group, which would have multiple summary events.  This test also verifies that the formatting of the time range selected for the summary view.


Build/Test/Run Design
------------
This application was written with Java and Maven.  To build and test the code execute

> mvm clean install

This will download the dependencies from the web and begin the compilation and test phases.

To run the application, an embedded container can be started by executing

> mvm jetty:run

This will begin two servlets, the Spring Servlet running the web application (localhost:8080/chatroom/), and the H2 Web access servlet (localhost:8080/chatroom/console).

To access the database open localhost:8080/chatroom/console in a browser, connect to the database with the following configuration:

> Driver Class  : org.h2.Driver
> JDBC URL      : jdbc:h2:/tmp/chatroom;AUTO_SERVER=TRUE
> User Name     : sa
> Password      : <BLANK>


The database will be empty, so the database install script at src/main/resources/db.install.sql can be run on the database and src/main/resources/db.seed.sql.

After the database has been seeded, the application is accessible at localhost:8080/chatroom/

