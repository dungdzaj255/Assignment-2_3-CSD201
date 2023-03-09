/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
  // test git
package assignment2_3;
import static assignment2_3.Validate.*;
import java.io.IOException;
/**
 *
 * @author dungd
 */
public class Main {

    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        BSTree tree = new BSTree();
        while (true) {
            String code, name;
            double income, deduct, taxReductionRate, tax;
            int choice = Menu.menu();
            switch (choice) {
                case 1:
                    //load data from file
                    tree.loadFile("taxPayer.txt");
                    break;
                case 2:
                    //intput & insert data
                    
                    break;
                case 3:
                    //in-order traverse
                    
                    break;
                case 4:
                    //pre-order traverse
                    
                    break;
                case 5:
                    //breath-first traverse
                    
                    break;
                case 6:
                    //in-order traverse to file
                    
                    break;
                case 7:
                    //search by code
                    
                    break;
                case 8:
                    //delete by code by copying
                    
                    break;
                case 9:
                    //simply balanceing (bs tree)
                    
                    break;
                case 10:
                    //count number of taxpayers
                    
                    break;
                case 0:
                    return;
            }
        }

    }
}
