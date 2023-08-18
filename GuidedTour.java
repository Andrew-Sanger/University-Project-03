/* COSC2135 - Programming 1 - Assignment 3
 * Study Period 3 - 2013
 * 
 * Student - Andrew John Sanger 
 * 
 * Student Number - 3440468
 * 
 * Assignment 3 - Stage 3 - GuidedTour subclass
 * 
 * This subclass has been created from scratch. It is a subclass of the
 * Tour class. Appropriate instance variables, constructors, accessors
 * mutators and overriden methods have been created. If the addbooking
 * method has a int passed to it that is greater than the maximum tour
 * group size, it will throw the TourException exception back to the calling
 * class.
 *  
 */

public class GuidedTour extends Tour
{
   // Part A - Define instance variables
   private String tourDate;
   private int tourGroupSize;
   private String tourLeader;

   // Part B - Define a constructor
   public GuidedTour(String tourID, String description, double tourFee,
                     String tourDate, int tourGroupSize, String tourLeader)
   {
      super(tourID, description, tourFee);
      this.tourDate = tourDate;
      this.tourGroupSize = tourGroupSize;
      this.tourLeader = tourLeader;
   }

   // Part C - Define Accessors
   public String getTourDate()
   {
      return this.tourDate;
   }

   public int getTourGroupSize()
   {
      return this.tourGroupSize;
   }

   public String getTourLeader()
   {
      return this.tourLeader;
   }

   // Part D - Define updateGroupSize method
   public void updateGroupSize(int size)
   {
      if (size < 0)
      {
         System.out.println("\n---Error - New group size is less than" +
                            " zero. Please try again.");
         return;
      }

      this.tourGroupSize = size;
   }

   // Part E - Override addBookings method
   @Override
   public double addBookings(int numberOfTourists) throws TourException
   {
      if (numberOfTourists <= 0 || (getTotalBookings() + numberOfTourists
          > this.tourGroupSize))
      {
         throw new TourException(numberOfTourists);
      }
      else
      {
         double totalFees = super.addBookings(numberOfTourists);

         return totalFees;
      }
   }

   // Part F - Override displayTourDetails method
   @Override
   public void displayTourDetails()
   {
      super.displayTourDetails();
      System.out.printf("%s %s\n", "Tour Date:", tourDate);
      System.out.printf("%s %s\n", "Tour Group Size:", tourGroupSize);
      System.out.printf("%s %s\n", "Tour Leader:", tourLeader);
   }
}
