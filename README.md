**Project for the second part of Java for Test Automation course**


My current project is educational one. This project is to do with task management. Test automation is implemented not so well. We have a huge amount of automated tests for ui. But  no automated task for running them, no server for it. Test automation team can run these tests only locally. And also we have API testing frameworks for all components of app.

-----------------------

In terminal go to the directory with calculator-1.0.jar file and use the next command to put the artifact in local 
repository

`mvn install:install-file -Dfile=calculator-1.0.jar -DgroupId=com.epam.tat.module4 -DartifactId=calculator -Dversion=1.0 -Dpackaging=jar
`