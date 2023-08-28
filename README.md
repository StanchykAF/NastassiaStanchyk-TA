**Project for the second part of Java for Test Automation course**


My current project is educational one. This project is to do with task management. Test automation is implemented not so well. We have a huge amount of automated tests for ui. But  no automated task for running them, no server for it. Test automation team can run these tests only locally. And also we have API testing frameworks for all components of app.

-----------------------

In terminal go to the directory with calculator-1.0.jar file and use the next command to put the artifact in local 
repository

`mvn install:install-file -Dfile=calculator-1.0.jar -DgroupId=com.epam.tat.module4 -DartifactId=calculator -Dversion=1.0 -Dpackaging=jar
`

-----------------------

## Setting up Grid

In terminal go to the directory with downloaded selenium-server-4.10.0.jar file and use the next command to set up 
Grid with hub role

`java -jar selenium-server-4.10.0.jar hub 
`

Then you can register nodes. Open new tab in terminal, go to the directory with downloaded selenium-server-4.10.0.
jar file and use the following command:

`java -jar selenium-server-4.10.0.jar node --config {path to repo from root}
/NastassiaStanchyk-TA/src/test/resources/gridconfigs/node1.toml`

To run more than 1 node use the command above in new terminal tab with appropriate configuration file.