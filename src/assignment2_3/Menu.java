/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment2_3;

import java.util.Scanner;

/**
 *
 * @author dungd
 */
public class Menu {

    private static Scanner sc = new Scanner(System.in);

    public static int menu() {
        while (true) {
            try {
                System.out.println("1. Load data from file");
                System.out.println("2. Input & insert data");
                System.out.println("3. In-order traverse");
                System.out.println("4. Pre-order traverse");
                System.out.println("5. Breadth-first traverse");
                System.out.println("6. In-order traverse to file");
                System.out.println("7. Search by code");
                System.out.println("8. Delete by code by copying");
                System.out.println("9. Simply balancing (bs tree)");
                System.out.println("10. Count number of taxpayers");
                System.out.println("0. Exit");
                System.out.print("Your selection (0 -> 10): ");
                int choice = Integer.parseInt(sc.nextLine());
                if (choice < 0 || choice > 10) {
                    throw new NumberFormatException();
                }
                return choice;
            } catch (NumberFormatException e) {
                System.out.println("Enter number from 0 to 10!");
            }
        }
    }
}
