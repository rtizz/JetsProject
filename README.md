# JetsProject

# Description
This project allows the user to add preconfigured aircraft input from a text file and place them into the program for implementation. Once imported, the user is given a list of various information and actions that can be applied the respective jets.

# Instructions & Expected Outcomes:
Once started, the file import will automatically take place. User will be prompted with a list of 1-9.
1. List fleet - shows all aircraft and their metadata 
2. Fly all jets - Calls the fly method for each aircraft and displays time of flight.
3. Displays fasted aircraft with all metadata
4. Displays aircraft with longest range and its metatdata
5. Calls only Cargo aircraft to be loaded.
6. Calls fighter jets to fight.
7. Prompts user with submenu to choose type of new aircraft to add<br>
>>>Following user will be prompted for additional data based on the type added.<br>
>>>User can select (1)List fleet following to see changes
8. Prompts user with submenu of aircraft model for user to choose and remove.<br>
>>>User can select (1)List fleet following to see changes
9. Quits the program.


# Code breakdown:
1. Jet.java - Abstract<br>
Sets blueprint for rest of program.<br>
>>>Variables<br>
>>>Getters & Setters<br>
>>>.equals & Hashcode<br>
>>>toString<br>
2. JetsApp.java<br>
Initializing the program and provides menu for user to call on other methods<br>
3. Airfield.java<br>
Reads in text file and provides the methods to execute menu in JetsApp<br>
4. FighterJet.java - extends Jet and implements CombatReady<br>
Adds additional parameters specific to jet and customizes the interface method from CombatReady<br>
5. CombatReady.java - Interface<br>
fight interface implemented in FigherJet<br>
6. CargoPlane.java - extends Jet and implements CombatReady<br>
Adds additional parameters specific to cargo planes and customizes the interface method from CargoCarrier<br>
7. CargoCarrier.java - Interface<br>
loadCargo interface implemented in CargoPlane<br>
8. PassengerPlane.java<br>
Adds additional parameters specific to passenger planes<br>
9. jets.txt - import CSV with initial jet data<br>
Initial text file to feed metadata to program. 


# Technologies used
1. Eclipse
2. Java
3. git


# Lessons Learned
1. Just because a class is implementing an interface, doesnt mean some of that implementation can be spread to other classes (i.e. using Airfield in conjunction with method).<br>
2. Try/Catch is a great way to push minute errors behind the scenes (JetsApp.removeJet).<br>
3. Slow down and READ what you just typed. 85% of the time eaten was small errors that was either calling the wrong location or using the wrong object. 

