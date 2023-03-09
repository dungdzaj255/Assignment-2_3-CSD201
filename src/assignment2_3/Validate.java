
package assignment2_3;

import java.util.Scanner;

/**
 *
 * @author dungd
 */
public class Validate {

    static private Scanner sc = new Scanner(System.in);

    static public double inputDouble(String mess, double min, double max) {
        System.out.print(mess);
        while (true) {
            String input = sc.nextLine();
            try {
                double number = Double.parseDouble(input);
                //check range of number
                if (number < min || number > max) {
                    System.out.print("Please input between " + min + ", " + max + ": ");
                    continue;
                }
                return number;
            } catch (NumberFormatException e) {
                System.out.print("Please input an double number: ");
            }
        }
    }
    
    static public String inputString(String mess) {
        System.out.print(mess);
        while (true) {
            String input = sc.nextLine();
            if (input.isEmpty()) {
                System.out.print("Cannot be empty. Try again: ");
                continue;
            }
            return input;
        }
    }
    
    static public int inputIntLimit(String mess, int min, int max) {
        System.out.print(mess);
        while (true) {
            String input = sc.nextLine();
            try {
                int number = Integer.parseInt(input);
                //check range of number
                if (number < min || number > max) {
                    System.out.print("Please input between " + min + ", " + max + ": ");
                    continue;
                }
                return number;
            } catch (NumberFormatException e) {
                System.out.print("Please input an integer number: ");
            }
        }
    }
}
