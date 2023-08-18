/* COSC2135 - Programming 1 - Assignment 3
 * Study Period 3 - 2013
 * 
 * Student - Andrew John Sanger 
 * 
 * Student Number - 3440468
 * 
 * Assignment 3 - Stage 1 - Tour Class
 * 
 * The majority of this code was provided for the assignment, the only change
 * that has been made is the inclusion of exception handling for the 
 * addBookings method. This exception allows the program to catch when the
 * user enters a number that is less than or equal to 0 and throws a 
 * TourException exception back to the TourBookingSystem class.
 */

public class Tour
{
   // Step 1: Define instance variables required for a Tour
   private String tourID;
   private String tourDescription;
   private double tourFee;
   private int totalBookings;

   // Step 2: Define a constructor that sets up a new Tour
   public Tour(String tourID, String tourDescription, double tourFee)
   {
      this.tourID = tourID;
      this.tourDescription = tourDescription;
      this.tourFee = tourFee;
   }

   // Step 3 - Define accessors (getters) for each instance variable
   public String getTourID()
   {
      return tourID;
   }

   public String getTourDescription()
   {
      return tourDescription;
   }

   public double getTourFee()
   {
      return tourFee;
   }

   public int getTotalBookings()
   {
      return totalBookings;
   }

   // Step 4: Define operations that can be performed on a Tour

   // addBookings()
   //
   // Attempts to add the specified number of tourists to the
   // total booking count for this Tour and return the booking
   // fees charged.
   //
   // Returns a signal of Double.NaN when the number of tourists
   // specified is not a positive value.
   //
   // UPDATE - No longer return Double.NaN, instead program throws the
   // TourException exception which is then handled in the TourBookingSystem
   // class.
   //
   public double addBookings(int numberOfTourists) throws TourException
   {
      // check for an invalid number of tourists
      if (numberOfTourists <= 0)
      {
         throw new TourException(numberOfTourists);
      }
      else
      {
         // update the total number of bookings for this Tour
         totalBookings += numberOfTourists;

         // calculate the total booking fees to be charged
         double totalFees = this.calculateBookingFees(numberOfTourists);

         // return the total booking fees amount to the caller
         return totalFees;
      }
   }

   // cancelBookings()
   //
   // Attempts to subtract the specified number of tourists from the
   // total booking count for this Tour and return the booking
   // fees to be refunded accordingly.
   //
   // Returns a signal of Double.NaN when the number of tourists
   // specified is not a positive value OR is greater than the current
   // total number of bookings for this Tour.
   //
   public double cancelBookings(int numberOfTourists)
   {
      if (numberOfTourists <= 0 || numberOfTourists > totalBookings)
      {
         return Double.NaN;
      }
      else
      {
         // update the total number of bookings for this Tour
         totalBookings -= numberOfTourists;

         // calculate the total booking fees to be refunded
         double refundedFees = this.calculateBookingFees(numberOfTourists);

         // return the total booking fees amount to the caller
         return refundedFees;
      }
   }

   // Step 5: Define helper methods that we may need

   // calculatBookingFees()
   //
   // Helper method which calculates the total booking fees that
   // apply based on the specified number of tourists
   //
   private double calculateBookingFees(int numberOfTourists)
   {
      return numberOfTourists * tourFee;
   }

   // displayTourDetails()
   //
   // Helper method which displays the basic details for this Tour,
   // as well as the total fees received for this Tour.
   public void displayTourDetails()
   {
      System.out.printf("%s %s\n", "Tour ID:", tourID);
      System.out.printf("%s %s\n", "Description:", tourDescription);
      System.out.printf("%s $%.2f\n", "Tour Fee:", tourFee);
      System.out.printf("%s %s\n", "Total Bookings:", totalBookings);

      // call the calculateBookingFees() method to help figure out the
      // total fees
      System.out.printf("%s $%.2f\n", "Total Booking Fees Received:",
                        this.calculateBookingFees(totalBookings));
   }
}
