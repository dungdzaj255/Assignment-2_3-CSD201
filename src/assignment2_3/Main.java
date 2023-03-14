/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
  // test git
package assignment2_3;
import java.io.IOException;
/**
 *
 * @author dungd
 */
public class Main {

    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        BSTree tree = new BSTree();
        /*
        TaxPayer tp1 = new TaxPayer("TX123456", "Nguyen Van A", 1000000, 100000, 0.1);
        TaxPayer tp2 = new TaxPayer("TX123457", "Nguyen Van B", 2000000, 200000, 0.2);
        TaxPayer tp3 = new TaxPayer("TX123458", "Nguyen Van C", 3000000, 300000, 0.3);
        TaxPayer tp4 = new TaxPayer("TX123459", "Nguyen Van D", 4000000, 400000, 0.4);
        TaxPayer tp5 = new TaxPayer("TX123460", "Nguyen Van E", 5000000, 500000, 0.5);
        TaxPayer tp6 = new TaxPayer("TX123461", "Nguyen Van F", 6000000, 600000, 0.6);
        TaxPayer tp7 = new TaxPayer("TX123462", "Nguyen Van G", 7000000, 700000, 0.7);
        TaxPayer tp8 = new TaxPayer("TX123463", "Nguyen Van H", 8000000, 800000, 0.8);
        //add node
        tree.insert(tp1);
        tree.insert(tp2);
        tree.insert(tp3);
        tree.insert(tp4);
        tree.insert(tp5);
        tree.insert(tp6);
        tree.insert(tp7);
        tree.insert(tp8);
        */
        while (true) {
            int choice = Menu.menu();
            switch (choice) {
                case 1:
                    //load data from file 
                    tree.loadFile("taxPayer.txt");
                    break;
                case 2:
                    //intput & insert data by avl
                    tree.insertAVL();
                    break;
                case 3:
                    //in-order traverse
                    tree.inOrder(tree.root);
                    break;
                case 4:
                    //pre-order traverse
                    tree.preOrder(tree.root);
                    break;
                case 5:
                    //breath-first traverse
                    tree.breadthFirst(tree.root);
                    break;
                case 6:
                    //in-order traverse to file save to file okay, not check the order
                    tree.inOrderToFile("taxpayer.txt", tree.root);
                    break;
                case 7:
                    //search by code not responding
                    tree.searchByCode();
                    break;
                case 8:
                    //delete by code by copying
                    tree.deleteByCode();
                    break;
                case 9:
                    //simply balanceing (bs tree) cannot check because we insert by avl
                    tree.balance();
                    break;
                case 10:
                    //count number of taxpayers
                    tree.countTaxPayers();
                    break;
                case 0:
                    return;
            }
        }

    }
}
