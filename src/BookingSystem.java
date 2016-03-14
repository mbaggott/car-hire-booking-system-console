//Import library for use of Scanner class.
import java.util.*;

// Booking System Class, contains complete program
public class BookingSystem {
    public static void main(String[] args) {

        // Declare constant variables.
        final double SMALL = 80;
        final double MEDIUM = 110;
        final double LARGE = 140;

        // Declare initial input variables.
        Scanner input = new Scanner(System.in);
        String name, address, phone, license, creditCard, expiry, carType,
                registration, size;
        int length, actualLength;

        // Accept user inputs for booking details.
        System.out.printf("%30s", "*** Car Hire Booking System ***\n\n");
        System.out.printf("Enter Customer Name: ");
        name = input.nextLine();
        System.out.printf("Enter Customer Address: ");
        address = input.nextLine();
        System.out.printf("Enter Customer Phone Number: ");
        phone = input.nextLine();
        System.out.printf("Enter Customer Licence Number: ");
        license = input.nextLine();
        System.out.printf("\nEnter Customer Credit Card Number: ");
        creditCard = input.nextLine();
        System.out.printf("Enter Credit Card Expiry Date: ");
        expiry = input.nextLine();
        System.out.printf("\nEnter Hire Length (in days): ");
        length = input.nextInt();
        // Consume the trailing new line
        input.nextLine();
        System.out.printf("Enter Make & Model of Hired Vehicle: ");
        carType = input.nextLine();
        System.out.printf("Enter Registration of Hired Vehicle: ");
        registration = input.nextLine();
        System.out.printf("\nEnter Car Size - (S)mall, (M)edium or (L)arge: ");
        size = input.nextLine();
        System.out.printf("Enter Days Hired For: ");
        actualLength = input.nextInt();
        // Consume the trailing new line
        input.nextLine();

        // Declare variable for and assign value of hire rate from constant.
        double rate;
        if (size.equalsIgnoreCase("s")) {
            rate = SMALL;
        } 
        else if (size.equalsIgnoreCase("m")) {
            rate = MEDIUM;
        }
        else {
            rate = LARGE;
        }

        // Declare and calculate charge, surcharge and adjusted charge.
        double charge = length * rate;
        double surcharge = 0;
        if (actualLength > length) {
            surcharge = (actualLength - length) * (rate * 2);
        }
        double adjCharge = charge + surcharge;

        // Declare damage/infringement menu variables.
        String damage = "", fine = "", damageDesc, fineDesc;
        double damageCost, fineCost, totalDamage = 0, totalFine = 0;
        boolean loopMenu = true;

        // Output damage/infringement menu. Loop will execute at this point.
        while (loopMenu) {
            System.out.printf("\nDamage Repair / Traffic Infingement Data "
                    + "Entry Menu");
            System.out.println("\n--------------------------------------------"
                    + "-------");
            System.out.printf("\n");
            System.out.printf("\nA - Record Damage Repair Details");
            System.out.printf("\nB - Record Traffic Infringement Details");
            System.out.printf("\nX - Exit");
            System.out.printf("\n");
            System.out.printf("Enter Your Selection:");

            // Declare and accept input for menu selection.
            String menuSelection = input.nextLine();

            // Execute code for appropriate selection, for upper/lower case.
            // If x is selected, exit menu loop.
            // Output error message if no appropriate selection made.
            switch (menuSelection.toUpperCase()) {
            case "A":
                System.out.printf("Enter Description of Damage Repair: ");
                damageDesc = "-" + input.nextLine();
                System.out.printf("Enter Repair Cost: ");
                damageCost = input.nextDouble();
                // Consume the trailing new line
                input.nextLine();
                damage += damageDesc + " ($" + damageCost + ")\n";
                totalDamage += damageCost;
                break;
            case "B":
                System.out.printf("Enter Details of Traffic Infringement: ");
                fineDesc = "-" + input.nextLine();
                System.out.printf("Enter Traffic Fine Amount: ");
                fineCost = input.nextDouble();
                // Consume the trailing new line
                input.nextLine();
                fine += fineDesc + " ($" + fineCost + ")\n";
                totalFine += fineCost;
                break;
            case "X":
                loopMenu = false;
                break;
            default:
                System.out.print("\nError, please enter a valid menu "
                        + "selection!\n");
                break;
            }
        }

        // Declare and calculate final charge.
        double finalCharge = adjCharge + totalFine + totalDamage;

        // Output all details to screen
        System.out.printf("\n%-25s\n", "Customer Details:");
        System.out.printf("\n%-25s %40s", "Name:", name);
        System.out.printf("\n%-25s %40s", "Address:", address);
        System.out.printf("\n%-25s %40s", "Phone Number:", phone);
        System.out.printf("\n%-25s %40s", "Licence No:", license);
        System.out.printf("\n%-25s %40s", "Credit Card No:", creditCard);
        System.out.printf("\n%-25s %40s", "Expiry Date:", expiry);
        System.out.printf("\n\n%-25s\n", "Car Hire Details:");
        System.out.printf("\n%-25s %40s", "Make / Model:", carType);
        System.out.printf("\n%-25s %40s", "Registration No:", registration);
        System.out.printf("\n%-25s %40d", "Hire Length (days):", length);
        System.out.printf("\n%-25s %40.2f", "Daily Hire Rate:", rate);
        System.out.printf("\n%-25s %40.2f\n\n", "Basic Hire Charge:", charge);
        System.out.printf("%-25s %40d", "Days Hired:", actualLength);
        System.out.printf("\n%-25s %40.2f", "Late Return Surcharge:",
                surcharge);
        System.out.printf("\n%-25s %40.2f", "Adjusted Hire Charge:", 
                adjCharge);
        System.out.printf("\n\n%-25s", "Damage Repair Details:");
        System.out.printf("\n%-25s", damage);
        System.out.printf("\n\n%-25s %40.2f", "Damage Repair Total:",
                totalDamage);
        System.out.printf("\n\n%-25s", "Traffic Infringement Fine Details:");
        System.out.printf("\n%-25s", fine);
        System.out.printf("\n\n%-25s %40.2f", "Traffic Fine Total:",
                totalFine);
        System.out.printf("\n\n%-25s %40.2f", "Final Hire Charge:",
                finalCharge);

        // Free Scanner reference created at start of program.
        input.close();

    }
}
