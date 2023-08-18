/* COSC2135 - Programming 1 - Assignment 3
 * Study Period 3 - 2013
 * 
 * Student - Andrew John Sanger 
 * 
 * Student Number - 3440468
 * 
 * Assignment 3 - Stage 4 - Incorporating exception handling
 * 
 * This exception was created for the addBooking methods in the
 * Tour and GuidedTour classes. If the number of tourists causing an error
 * are less than 0, than an exception is thrown and a message saying tourists
 * cannot be less than or equal to 0 is shown. If the number of tourists
 * are greater than the GuidedTour maximum group size, then an exception 
 * is thrown and an error message saying that tourists cannot be greater than
 * maximum tour group size is shown.
 *  
 */

public class TourException extends Exception
{
   private int numberOfTourists;

   // Constructor for TourException exception
   public TourException(int numberOfTourists)
   {
      super("Invalid number of tourists: (" + numberOfTourists +
            getErrorMessage(numberOfTourists));
      this.numberOfTourists = numberOfTourists;
   }

   // Accessor for number of tourists stored in exception
   public int getTourists()
   {
      return this.numberOfTourists;
   }

   /*
    * This is a helper class which creates a custom error message depending on
    * whether number of tourists is less than 0 or greater maximum group size.
    * This error message is then added onto the end of the exception message,
    * showing clearly why the exception was caused.
    */
   public static String getErrorMessage(int tourists)
   {
      String errorMessage;

      if (tourists <= 0)
      {
         errorMessage = ") - Cannot be less than or equal to 0.";
      }
      else
      {
         errorMessage = ") - Cannot be more than maximum tour group size.";
      }

      return errorMessage;
   }
}
