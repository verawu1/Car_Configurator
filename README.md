Car_Configurator
================

A java application for car buyers to configure car models and car manufactures to upload/update car models.

================================================================================================
How to run the program:
To run this client_server program, at first you should have two terminals.

cd Project1_Unit4/bin

One terminal:
java client_server/Server ----- to run the server

The other terminal:
java client_server/EditOptionClient
or
java client_server/CarModelOptionsIO
or
java client_server/SelectCarOption

Then follow the instructions displayed in the client terminal.


-------------------------------------------------------------------------

This program has three kinds of users:
EndUser: List all the models, choose one model to configure, configure his own car.

MedAdmin: update every thing of a model(option and optionSet), add option in a certain optionSet, delete option and optionSet

SuperUser: This guy can do everything

Test class in main package does all the test, including testing all the functionality of EndUser and MedAdmin.

Please note that I handle most exceptions by CustomerException. When there is a wrong input, like wrong fileName, wrong modelName, wrong optionSetName and wrong optionName, the system will ask the user to enter a new name, till the enter name is correct. This is the strategy of self recovery in my program.

There are four main methods in the client_server package:

1. Server.java: main method in this file runs the server with three threads corresponding to the three tasks: Build a car model; EditOption; Configure a car;

2. EditOptionClient.java: main method in this file is for the client to edit option

3. CarModelOptionsIO.java: main method in this file is for the client to upload a model
please note I don't use Properties object, so the file should be the same format as model2.txt

4. SelectCarOption.java: main method in this file is for the client to configure a car

