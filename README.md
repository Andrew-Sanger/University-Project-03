# University-Project-03
## University project 3 - Programming 1 - Tour Booking System

The third and final project in the Programming 1 course. A more complicated project than the last two, using more complicated ideas, such as error, exceptions and file handling.

## Background information (from the course notes)

This assignment is an exercise in simple object-oriented programming and, accordingly, you should adhere to basic-object oriented programming guidelines when designing and writing your classes, such as:

1- Setting the visibility of all instance variables to private.
2- Setting the visibility of all methods in your classes to public
3- Encapsulating both the data for a class and the methods that work with and/or manipulate that data within the same class.

The scenario we are modelling is that of a tour booking system operated by an outdoor adventure tour company, which offers both self-guided tours through various outdoor attractions, as well as guided tours in  which a group of tourists are led on a tour by one or more guides provided by the tour company. In this assignment we are focusing on a tour booking system for an adventure company which offers two types of tour pass to tourists as follows:

- A basic tour for a self-guided tour attraction which grants admission to the attraction in question.
- A guided tour in which the tourist/s join a guided tour group travelling to a specified attraction, starting on a specified day.
  
A design for an object-oriented program which demonstrates the functionality has been put together and the implementation of the corresponding tour booking system has been started previously by another  programmer.

You have been brought in to complete the implementation of this tour booking system by following the design that you have been provided with, using the previously completed (implemented) components of the system as the basis for your final version of the program.

## Stage 1 - Tour class design / implementation

A basic tour requires the following tour information to be maintained in the system: tour ID, tour description (attraction or location), and the tour (admission) fee. In addition the tour company has also expressed a desire to be able to record the number of bookings made for the tour in question, for reporting and planning purposes.

A design for a basic Tour class has already been put together and the programmer who was previously working on the project has already implemented the corresponding class, so you do not have to implement this class yourself.

A description of the design / implementation of this basic Tour class is provided below.

1- **Instance Variables**
   - Instance variables have been defined for the tour ID (a String), tour description (a String), tour fee (a double) and the total bookings for the tour (an int).

2- **Constructor**
   - A constructor has been defined for the Tour class which accepts the tour ID, tour description and the tour fee as parameters and stores the information in the corresponding instance variables. NOTE: The number of bookings will start at zero (0) by default for a new Tour.

3- **Accessors (getters)**
   - An accessor has been implemented for each of the instance variables in this class.

4- **Mutators (setters)**
   - None required at this stage.

5- **Operations**
   - A method public double addBookings(int numberOfTourists) has been implemented, which adds the number of tourists specified to the total number of bookings for the given tour, after which it uses the calculateBookingFee()method defined below to calculate the fee for the tourists in question and returns the result to the caller. If the number of tourists that was specified was less than or equal to zero (0) then this method returns a result of Double.NaN, indicating that the booking request was rejected.
   - A method public double cancelBookings(int numberOfTourists) has been implemented, which subtracts the number of tourists specified from the total number of bookings for the current Tour and returns the booking fees to be refunded (which are determined using the calculateBookingFee() helper method) to the caller. If the number of tourists that was specified was less than or equal to zero (0) OR greater than the total bookings for the tour then the method returns a result of Double.NaN, indicating that the cancellation request was rejected.

6- **Helper methods**
   - A method public double calculateBookingFee(int numberOfTourists) has been implemented, which calculates and returns the total fee charged for the specified booking (ie. tour fee * number of tourists) and returns the result to the caller.
   - A method public void displayTourDetails(), has been implemented, which prints a summary of the details (instance variables) for the current Tour to the screen, as well as displaying the total fees that have been paid for this Tour.

## Stage 2 - Initial TourBookingSystem implementation (50 marks)

Now that we have the attribute and functionality required for a basic tour modelled and encapsulated in the Tour class described above, you will need to begin the implementation of the TourBookingSystem application class, which will use an array of Tour references* to store and manage tours that are added to the system by the user.

*You may also use a JCF collection instance (eg. ArrayList or HashMap) to store and manage the tours that the user is adding to the system if you so wish - it is, however, not a requirement to do so for this task and using a simple array of Tour references as described above is still perfectly acceptable.*

The programmer who was previously working on this project has implemented a menu feature for the TourBookingSystem class, for which options are presented to A) add a new tour to the system, B) display a summary of all tours currently in the system , C) add bookings for a tour in the system and D) cancel bookings for a tour in the system (we will address the other two options later on in Stage 3).

Your task is to work on the implementation of this initial TourBookingSystem class by implementing the functionality for the first four features shown in the menu only (the other two features will be addressed in Stage 3 of this specification). A description of these functionality that needs to be implemented for each of these features is provided below.

1- **Add New Tour** (15 marks)

This feature should prompt the user for the general tour details (id, description and tour fee), after which a new Tour object should be created and stored in the next available location in the array of Tour references tours.

Note that the variable tourCount should be updated to reflect the adding of the new Tour object to the tours array / collection and it may also help determine where the next available [empty] spot is in 
the array (this doesn't apply if you are using a JCF collection instance to store the tour objects).

2- **Display Tour Summary** (5 marks)

This option should list the details for all tours in the system by using a loop to step through the objects currently stored in the tours array / collection and invoking the displayTourDetails() method for 
each of those objects in turn.

Note that if you are using an array to store your tour objects then the tours array may not be full at the point where this feature is used, so you should code the loop described above in such a way that it only visits the elements in the tours array that are currently storing a tour object.

3- **Add Tour Booking** (15 marks)

This option should prompt the user to enter a tour id to search for, after which it should search for the corresponding tour object from amongst tour objects currently stored in the tours array / collection.

If a tour object containing the specified tour id was found then the user should be prompted to enter the number of tourists that bookings are being made for, after which the system should attempt to add bookings for that number of tourists to the tour by invoking the addBookings() method for the tour object that was located previously, and then display the result that it returns (which is the total booking fee to be charged) to the screen.

If the tour id cannot be located in the tours array / collection OR the booking cannot be made for the specified number of tourists (ie. the addBookings() method returns a result of Double.NaN) then an 
appropriate error message should be displayed to the screen for each issue.

4- **Cancel Tour Booking** (15 marks)

This option should prompt the user to enter a tour id to search for, after which it should search for the corresponding tour object from amongst the tour objects currently stored in the tours array / collection.

If a tour object containing the specified tour id was found then the user should be prompted to enter the number of tourists the bookings are being cancelled for, after which the system should attempt to 
cancel bookings for that number of tourists on the tour by invoking the cancelBookings() method for the tour object that was located previously and display the result that it returns (which is the total 
booking fees to be refunded) to the screen.

If the tour id cannot be located in the tours array / collection or bookings cannot be cancelled for the specified number of tourists (ie. the cancelBookings() method returns a result of Double.NaN) then an appropriate error message should be displayed to the screen for each issue.

## Stage 3 - GuidedTour subclass design/implementation (40 marks)

The next stage of this task is to design and implement a class which represents guided tours that are run by the outdoor adventure tour company. Guided tours run on a specified date and have a maximum group size limit that relates to the number of tourists that a tour leader can safely manage, but it is possible to increase or decrease the maximum group size of a tour (by adding or removing tour guides) as required.

You should address these new requirements by designing and implementing a GuidedTour class (that extends the Tour class that has already been implemented), which includes the required additional 
attributes and functionality as described below:

1- Define new instance variables for the tour date (a String), tour group size (an int) and the tour leader (a String). (6 marks)

***NOTE: You should not redefine any of the instance variables defined initially in the Tour superclass in this GuidedTour subclass.***

2- Define a constructor that accepts the tour ID, description, tour fee, tour date, tour group size and tour leader for the new GuidedTour as parameters, and stores the information in the corresponding instance variables. (6 marks)

***NOTE: You should use the super() facility to pass on the relevant parameters (ID, description and tour fee) to the superclass constructor. As was the case with the Tour class constructor you do not need to accept or pass a parameter for the number of bookings.***

3- Define an accessor for each of the new instance variables in this GuidedTour subclass. (6 marks)

4- Define a method public void updateGroupSize(int size), which accepts the new group size as a parameter and stores the value that was passed in to the corresponding tour group size instance variable. (2 marks)

5- Override the method public double addBookings(int numberOfTourists), which calculates and returns the total booking fee based on the basic tour fee and the number of tourists specified.

As there is a limit on the size of a guided tour group this method should first check to make sure that the group size limit for the guided tour in question will not be exceeded if the specified number of 
tourists is added to the current GuidedTour – you can use the accessor for the total number of bookings that is inherited from the Tour superclass to retrieve the current size of the tour group.

If the booking that is being made results in the tour group size limit being exceeded, then the booking should not be added and a result of Double.NaN should be returned.

If the tour group size will not be exceeded then you should complete the adding of bookings for the GuidedTour by invoking the superclass addBookings() method in an appropriate fashion and passing along the result that this method call returns to the caller (by returning it again). (12 marks)

***NOTE: You will need to use the super “reference” to invoke the addBooking() method from the Tour superclass in order to make the GuidedTour booking ,after which you can return the result that is returned (which will be the total booking fee).***

6- Override the method public void displayTourDetails() to display a summary of all of the details (instance variables) for the current GuidedTour. (8 marks)

***NOTE: The overriding version of the displayTourDetails() method in this GuidedTour class will need to use the “super” reference to invoke the corresponding method from the Toursuperclass, in order to display the basic Tour details first. The details of the GuidedTour object should be printed in a neat labelled format, but tabulation of the output being printed is not required.***

## Stage 3 - Additional TourBookingSystem features (30 marks)

The next stage of this task is to update the TourBookingSystem class implementation described in stage 2 above so that it incorporated the other two features in the menu as shown below, which relate to adding and working with GuidedTour objects:

![11](https://github.com/Andrew-Sanger/University-Project-03/assets/74388624/39489d2b-11a9-4033-98fa-194aae264ad5)

A description of these functionality that needs to be implemented for each of these features is provided below.

1- **Add New Guided Tour** (15 marks)

This feature should prompt the user for the general details (id, description, tour fee, tour date, tour size and tour guide name), after which a new GuidedTour object should be created and stored in the next available location in the same array of of Tour references tours that was described in stage 1 of the assignment.

(You should NOT be creating a new array / collection just to store GuidedTour objects, as it is a requirement that all Tour and GuidedTour objects which are added to the system should be stored together in the same array / collection)

Note that the variable tourCount should be updated to reflect the adding of the new GuidedTour object to the tours array / collection and it may also help determine where the next available [empty] spot is in the array (this doesn't apply if you are using a JCF collection instance to store the tour objects).

2- **Update Guided Tour Group Size** (15 marks)

This option should prompt the user to enter a tour id to search for, after which it should search for the corresponding tour object from amongst the tour objects currently stored in the tours array / collection. 

If the matching tour object is a GuidedTour then the user should be prompted to enter the new tour group size, after which the system should update the group size for the GuidedTour by invoking the updateGroupSize() method for the GuidedTour object that was located previously (using a typecast in an appropriate fashion) and display a message indicating that the group size was changed successfully for the GuidedTour.

If the tour id cannot be located in the tours array / collection or the matching object was not a GuidedTour then an appropriate error message should be displayed to the screen for each issue (for the latter issue the error message should specifically mention that the specified tour was not GuidedTour).

## Stage 4 – Incorporating Exception handling into existing TourBookingSystem functionality (5 + 5 + 5 + 5 = 20 marks)

Initially you should define your own exception type TourException which represents an issue that occurs when attempting to add bookings for a tour. 

This TourException type should allow a suitable error message to be specified when a new TourException object is created. (5 marks)

You should then proceed to update the addBookings() method in the Tour class, so that a TourException containing a suitable error message (indicating that the specified number of tourists was invalid) is generated and thrown when the specified number of tourists is less than or equal to zero (0). (5 marks)

After you have done this you should also update the corresponding addBookings() method in the GuidedTour subclass, so that a TourException containing a suitable error message (indicating that the group size will be exceeded) is generated and thrown when the specified number of tourists will take the total number of bookings for the GuidedTour past its maximum group size. (5 marks)

The TourException that have been thrown should then be allowed to propagate back up to the TourBookingSystem class (ie. the exception should not be caught locally within the addBookings() method(s)), where it will need to be caught and handled in an appropriate manner by displaying the error message contained within the TourException object that has propagated up from the relevant method call.

***Note: You should try to limit the scope of your try block (in your try-catch structure) to the method call which could cause an exception to be thrown and any code that depends on that method call executing successfully (ie. without throwing an exception).*** (5 marks)

## Use of appropriate coding style (10 marks)

You should adhere to the following coding style guidelines when implementing your program for this assignment.

1- Different levels of program scope (methods, control structures, etc) should be indented consistently using levels of 3 or 4 spaces (do not use tabs).

2- A new level of indentation should be added for each new class/method/control structure that is “opened”. 

3- Indentation should return to the previous level of at the end of a class/method/control structure (before the closing brace if one is being used).

4- Block braces should be aligned and positioned consistently in relation to the method/control structure they are opening/closing.

5- Lines of code should not generally exceed 80 characters in length (including indentation) - lines which will exceed this limit are split into two or more segments where required.

6- Expressions should be well spaced out – this includes assignment statements, arithmetic expressions and parameter lists supplied to method calls.

7- Source code should be spaced out into logically related code segments.

8- Identifiers used in the program for class/method/variable/constant names should adhere to the naming conventions discussed in the course notes.

9- Identifiers themselves should be meaningful without being overly explicit (long) – you should avoid using abbreviations in identifiers as much as possible (an exception to this rule is a “generic” loop counter used in a for-loop).J. Each file in your program should have a comment at the top listing your name, student number and a brief (1-2 line) description of the contents of the file (generally the purpose of the class you have implemented).

10- You should include brief (1-2 line) comments describing what each logically related segment of code in your program is doing.

11- Comments should be placed on the line above the statement(s) or code segment they refer to.

## Bonus Marks Functionality - File Handling (12 + 18 = 30 marks)

Your program should incorporate file handling functionality so that it writes the details for each tour object currently in the system out to file when the program terminates (ie. when the user selects the “Exit” option in the menu).

The data that was previously written out to file should then be read back in automatically when the program is started up again and this tour information within should be used to recreate an appropriate set of tour objects, which should be stored in the array or collection of Tour references described in Stage 2. 

If the property sale data file is not found in the local folder then the program should display a message indicating that no tour data was loaded in from file and continue on to the program menu.

The data should be written out to and read in from (the same) text file (containing the details for both Tour and GuidedTour objects in the TourBookingSystem). The format that you write data out in is entirely at your own discretion as long as it is done to a text file (strategies for handling the writing and reading of data for different types of objects will be discussed during the Week 11 Live Chat Session).

One aspect of this task is to record any changes that have been made during the previous run of the TourBookingSystem application, so your file handling functionality must be able to handle the writing out and reading in of all details for both types of tour in such a way that the state of the TourBookingSystem at the point where the program was last exited is reconstructed in full when the program is started up again.

***IMPORTANT NOTE: You are not permitted to use serialisation or binary files when implementing your file handling mechanism - you must use a PrintWriter for writing data out and a BufferedReader or Scanner when reading the data back in.***
