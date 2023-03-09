/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment2_3;

import java.io.*;

/**
 *
 * @author dungd
 */
public class BSTree {

    Node root;

    BSTree() {
        root = null;
    }

    void clear() {
        root = null;
    }

    boolean isEmpty() {
        return (root == null);
    }

    void visit(Node p) {
        System.out.print(p.info + " \n");
    }

    void loadFile(String fname) throws IOException { // Using FileReader class
        FileReader fr = new FileReader(fname);
        BufferedReader br = new BufferedReader(fr);
        String s;
        String[] a;
        String xCode;
        String xName;
        double xIncome, xDeduct, xTax;
        while (true) {
            s = br.readLine();
            if (s == null || s.trim().length() < 5) {
                break;
            }
            a = s.split("[|]");
            xCode = a[0].trim();
            xName = a[1].trim();
            xIncome = Double.parseDouble(a[2].trim());
            xDeduct = Double.parseDouble(a[3].trim());
            xTax = Double.parseDouble(a[4].trim());
            insertAVL(new TaxPayer(xCode, xName, xIncome, xDeduct, xTax));
        }
        fr.close();
        br.close();
    }

    void insertAVL(TaxPayer x) {

    }

    void inOrder(Node p) {
        if (p == null) {
            return;
        }
        inOrder(p.left);
        visit(p);
        inOrder(p.right);
    }

    void preOrder(Node p) {
        if (p == null) {
            return;
        }
        visit(p);
        preOrder(p.left);
        preOrder(p.right);
    }

    void breadthFirst(Node p) {
        if (p == null) {
            return;
        }
        MyQueue q = new MyQueue();
        q.enqueue(p);
        Node r;
        while (!q.isEmpty()) {
            r = q.dequeue();
            visit(r);
            if (r.left != null) {
                q.enqueue(r.left);
            }
            if (r.right != null) {
                q.enqueue(r.right);
            }
        }
    }

    
    void SaveInOrder(PrintWriter pw, Node p) {
        if (pw == null || p == null) {
            return;
        }
        inOrder(p.left);
        pw.printf("%10s | %10s | %.2f | %.2f | %.2f\r\n", p.info.code, p.info.name, p.info.income, p.info.deduct, p.info.tax);
        inOrder(p.right);
    }
    
    void saveFile(String fname, Node p) throws IOException { // Using FileReader class
        FileWriter fw = new FileWriter(fname);
        PrintWriter pw = new PrintWriter(fw);
        SaveInOrder(pw, p);
        pw.close();
        fw.close();
    }

    Node searchByCode(String code) {

        return null;
    }

    Node search(TaxPayer x) {
        Node tmp = root;
        while (tmp != null) {
            if (tmp.info == x) {
                return tmp;
            } else if (x.tax < tmp.info.tax) {
                tmp = tmp.left;
            } else {
                tmp = tmp.right;
            }
        }
        return null;
    }

    void delByCopy(TaxPayer x) {

    }

    void balance() {

    }

    void countTaxPayers() {

    }

}
