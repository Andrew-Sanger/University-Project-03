/* COSC2135 - Programming 1 - Assignment 3
 * Study Period 3 - 2013
 * 
 * Student - Andrew John Sanger 
 * 
 * Student Number - 3440468
 * 
 * Assignment 3 - Stage 2 - TourBookingSystem implementation (A, B, C, D)
 * 				  Stage 3 - TourBookingSystem implementation (E, F, X)
 * 				  Stage 4 - Exception Handling - (Menu option C)
 * 
 * As before with the Tour class, some of this code was provided
 * for the assignment. I have added functionality to the menu allowing it
 * to A - Add new tours, B - Display tour summarys, C - Add tour bookings,
 * D - Cancel tour bookings, E - Add new guided tours, F - Update guided
 * tour group sizes and X - Exit the program.
 * 
 */

import java.util.Scanner;

public class TourBookingSystem
{
   // Declare the array of Tour references in which the Tour and
   // GuidedTour objects that the user adds will be stored in and
   // the corresponding tour count.
   //
   // If you are going to use a JCF collection instance instead then
   // replace these array-oriented declarations with one for your
   // JCF collection instance instead.

   private static final Tour[] tours = new Tour[100];
   private static int tourCount = 0;

   // Declaring a shared scanner just in case you choose to
   // implement some helper methods in your application class
   // that need access to one.

   private static final Scanner sc = new Scanner(System.in);

   public static void main(String[] args)
   {
      // variables required to process user's menu selection
      String input;
      char selection = '\0';
      // Holds the int value of tours array address user is search for.
      int tourFound;

      // keep repeating the menu until the user chooses to exit
      do
      {
         // display menu options
         System.out.println("Tour System Menu");
         System.out.println("----------------");
         System.out.println("A - Add New Tour");
         System.out.println("B - Display Tour Summary");
         System.out.println("C - Add Tour Booking(s)");
         System.out.println("D - Cancel Tour Booking(s)");
         System.out.println("E - Add New Guided Tour");
         System.out.println("F - Update Guided Tour Group Size");
         System.out.println("X - Exit Program");
         System.out.println();

         // prompt the user to enter their selection
         System.out.print("Enter your selection: ");
         input = sc.nextLine();

         System.out.println();

         // check to see if the user failed to enter exactly one character
         // for their menu selection

         if (input.length() != 1)
         {
            System.out.println("---Error - selection must be a single " +
                               "character!");

         }
         else
         {
            // extract the user's menu selection as a char value and
            // convert it to upper case so that the menu becomes
            // case-insensitive

            selection = Character.toUpperCase(input.charAt(0));

            // process the user's selection
            switch (selection)
            {
               case 'A': // Add new tour option.
                  System.out.println("------------------------------------");
                  System.out.println("Add New Tour");
                  System.out.println("------------------------------------");

                  // Gets user input for new Tour object
                  System.out.print("Enter new tour ID: ");
                  String newID = sc.nextLine();
                  System.out.print("Enter new tour description: ");
                  String newDescription = sc.nextLine();
                  System.out.print("Enter new tour fee: ");
                  double newFee = sc.nextDouble();

                  // Checks for scanner error.
                  if (sc.hasNextLine())
                  {
                     sc.nextLine();
                  }

                  // Creates new tour object and increases tourCount by 1
                  tours[tourCount] = new Tour(newID, newDescription, newFee);
                  tourCount++;

                  System.out.println("\nNew tour successfully created!");

                  break;

               case 'B': // Display tour summary option.
                  // If no tours have been created an error message shows
                  if (tourCount == 0)
                  {
                     System.out.println("---Error - There are no tours " +
                                        "currently in the system!");
                     break;
                  }

                  System.out.println("------------------------------------");
                  System.out.println("Display Tour Summary");
                  System.out.println("------------------------------------");

                  // Displays all tour objects stored in array tours[]
                  for (int i = 0; i < tourCount; i++)
                  {
                     tours[i].displayTourDetails();
                     System.out.println("----------------------------" +
                                        "--------");
                  }

                  break;

               case 'C': // Add tour booking option.
                  // If no tours have been created an error message shows
                  if (tourCount == 0)
                  {
                     System.out.println("---Error - There are no tours " +
                                        "currently in the system!");
                     break;
                  }

                  System.out.println("------------------------------------");
                  System.out.println("Add Tour Booking(s)");
                  System.out.println("------------------------------------");

                  /*
                   * Calls the helper class getMatchingTour() to see if any tour
                   * objects match user input and returns the matching tours
                   * array address.
                   */
                  tourFound = getMatchingTour();

                  // If no matching tour IDs were found, breaks
                  if (tourFound < 0)
                  {
                     break;
                  }

                  // Asks user to input number of tourists to book
                  System.out.print("\nEnter number of tourists booking" +
                                   " is being made for: ");
                  int numberOfTourists = sc.nextInt();

                  // Fixes scanner error.
                  if (sc.hasNextLine())
                  {
                     sc.nextLine();
                  }

                  double bookingFee;

                  /*
                   * Tries the first part of the code and if the number of
                   * tourists entered is less than or equal to 0, will throw an
                   * exception and show an appropriate error message.
                   */
                  try
                  {
                     bookingFee = tours[tourFound].
                              addBookings(numberOfTourists);
                  }
                  catch (TourException exception)
                  {
                     System.out.println(exception);
                     break;
                  }

                  // Displays total booking fee if booking succesful
                  System.out.println();
                  System.out.printf("%s%.2f", "Total booking fee to be" +
                                              " charged is $", bookingFee);
                  System.out.println();

                  break;

               case 'D': // Cancel tour booking option.
                  // If no tours have been created an error message shows
                  if (tourCount == 0)
                  {
                     System.out.println("---Error - There are no tours " +
                                        "currently in the system!");
                     break;
                  }

                  System.out.println("------------------------------------");
                  System.out.println("Cancel Tour Booking(s)");
                  System.out.println("------------------------------------");

                  /*
                   * Calls the helper class getMatchingTour() to see if any tour
                   * object match user input and returns the tours array address
                   * of matching tour.
                   */
                  tourFound = getMatchingTour();

                  // If no matching tour IDs were found, breaks
                  if (tourFound < 0)
                  {
                     break;
                  }

                  // Asks user input for number of bookings being cancelled
                  System.out.print("\nEnter number of tourists whose" +
                                   " bookings are being cancelled: ");
                  int numberOfCancellations = sc.nextInt();

                  // Fixes scanner error.
                  if (sc.hasNextLine())
                  {
                     sc.nextLine();
                  }

                  /*
                   * Attempts to cancel booking and if an error occurs Tour or
                   * GuidedTour classes return a Double.NaN value which results
                   * in an error message being displayed.
                   */
                  double cancellationFee = tours[tourFound].
                           cancelBookings(numberOfCancellations);

                  if (Double.isNaN(cancellationFee))
                  {
                     System.out
                              .println("\n---Error - Number of "
                                       +
                                       "cancellations is incorrect. Please try "
                                       +
                                       "again.");
                     break;
                  }

                  // Displays total booking fee refunded
                  System.out.println();
                  System.out
                           .printf("%s%.2f", "Total booking fee to be" +
                                             " refunded is $", cancellationFee);
                  System.out.println();

                  break;

               case 'E': // Add new guided tour option.
                  System.out.println("------------------------------------");
                  System.out.println("Add New Guided Tour");
                  System.out.println("------------------------------------");

                  // Asks for user input on new guided tour being created
                  System.out.print("Enter new guided tour ID: ");
                  String newGuidedID = sc.nextLine();
                  System.out.print("Enter new guided tour description: ");
                  String newGuidedDescription = sc.nextLine();
                  System.out.print("Enter new guided tour fee: ");
                  double newGuidedFee = sc.nextDouble();

                  // Checks for scanner error.
                  if (sc.hasNextLine())
                  {
                     sc.nextLine();
                  }

                  System.out.print("Enter new guided tour date: ");
                  String newGuidedDate = sc.nextLine();
                  System.out.print("Enter new guided tour size: ");
                  int newGuidedSize = sc.nextInt();

                  // Checks for scanner error.
                  if (sc.hasNextLine())
                  {
                     sc.nextLine();
                  }

                  System.out.print("Enter guided tour guide's name: ");
                  String newGuideName = sc.nextLine();

                  // Creates a new GuidedTour object
                  tours[tourCount] =
                           new GuidedTour(newGuidedID,
                                          newGuidedDescription, newGuidedFee,
                                          newGuidedDate,
                                          newGuidedSize, newGuideName);
                  tourCount++;

                  System.out.println("\nNew guided tour successfully " +
                                     "created!");

                  break;

               case 'F': // Update tour group size option.
                  // If no tours have been created an error message shows
                  if (tourCount == 0)
                  {
                     System.out.println("---Error - There are no tours " +
                                        "currently in the system!");
                     break;
                  }

                  System.out.println("------------------------------------");
                  System.out.println("Update Tour Group Size");
                  System.out.println("------------------------------------");

                  /*
                   * Calls the helper class getMatchingTour() to see if any tour
                   * object match user input and returns the tours array address
                   * of matching tour.
                   */
                  tourFound = getMatchingTour();

                  // If no tours are found, program breaks
                  if (tourFound < 0)
                  {
                     break;
                  }
                  /*
                   * If the tour that was found is not a GuidedTour, program
                   * shows an appropriate error message.
                   */
                  else if (!(tours[tourFound] instanceof GuidedTour))
                  {
                     System.out.println("---Error - Selected tour is not " +
                                        "a Guided Tour.");
                     break;
                  }

                  // Asks user to enter new group size
                  System.out.print("\nEnter selected guided tour's new " +
                                   "group size: ");
                  int newGroupSize = sc.nextInt();

                  // Checks for scanner error.
                  if (sc.hasNextLine())
                  {
                     sc.nextLine();
                  }

                  // Updates GuidedTour object with new group size
                  ((GuidedTour) tours[tourFound]).updateGroupSize(newGroupSize);

                  break;

               case 'X':

                  System.out.println("Tour system shutting down – goodbye!");
                  break;

               default:

                  // default case - handles invalid selections
                  System.out.println("Error - invalid selection!");

            }
         }

         System.out.println();

      } while (selection != 'X');
   }

   /*
    * This helper class prompts the user to enter the ID of the tour they are
    * wanting to update. This ID is then changed to upper case, and compared to
    * all IDs in the array of tour objects. These IDs are also made upper case
    * to ensure that case doesn't cause mismatches. If no matching ID is found,
    * an error message is displayed and a -1 returned. If a matching ID is
    * found, then the array location of the matchin tour is returned.
    */
   public static int getMatchingTour()
   {
      System.out.print("Enter ID of tour to be updated: ");
      String userInput = sc.nextLine();
      String newBookingID = userInput.toUpperCase();

      int tourFound = -1;

      for (int i = 0; i < tourCount; i++)
      {
         String currentTourID = tours[i].getTourID().
                  toUpperCase();

         if (currentTourID.equals(newBookingID))
         {
            tourFound = i;
         }
      }

      if (tourFound < 0)
      {
         System.out.println("\n---Error - No matching tour " +
                            "found for tour ID " + userInput);
      }

      return tourFound;
   }
}
