/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment2_3;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author dungd
 */
public class BSTree {

    Node root;

    //constructor
    BSTree() {
        root = null;
    }

    public void visit(Node p) {
        System.out.println(p.info);
    }

    // is empty
    public boolean isEmpty() {
        return root == null;
    }

    //void clear() clear all node in tree
    public void clear() {
        //root = null and remove all node and reference
        root = null;
    }

    // insert
    public void insert(TaxPayer x) {
        Node p = root;
        Node f = null;
        while (p != null) {
            f = p;
            if (x.getCode().compareTo(p.info.getCode()) < 0) {
                p = p.left;
            } else if (x.getCode().compareTo(p.info.getCode()) > 0) {
                p = p.right;
            } else {
                System.out.println("The key " + x.getCode() + " already exists, no insertion");
                return;
            }
        }
        Node q = new Node(x);
        if (f == null) {
            root = q;
        } else if (f.info == null || x.getCode().compareTo(f.info.getCode()) < 0) {
            f.left = q;
        } else {
            f.right = q;
        }
    }

    //insert AVL tree by TaxPayer
    public void insertAVL() {
        TaxPayer taxPayer = getInforObject();
        Node p = root;
        Node f = null;
        while (p != null) {
            if (taxPayer.getCode().compareTo(p.info.getCode()) == 0) {
                return;
            }
            f = p;
            if (taxPayer.getCode().compareTo(p.info.getCode()) < 0) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        Node q = new Node(taxPayer);
        if (f == null) {
            root = q;
        } else {
            if (taxPayer.getCode().compareTo(f.info.getCode()) < 0) {
                f.left = q;
            } else {
                f.right = q;
            }
        }
        balanceAVL(q);
    }

    //insert AVL
    public void insertAVL(Node p) {
        if (p != null) {
            insert(p.info);
            balanceAVL(p);
        }
    }

    // search
    public Node search(String code) {
        Node p = root;
        while (p != null) {
            if (code.compareTo(p.info.getCode()) < 0) {
                p = p.left;
            } else if (code.compareTo(p.info.getCode()) > 0) {
                p = p.right;
            } else {
                return p;
            }
        }
        return null;
    }

    //int count() count number of node in tree
    public int count() {
        return count(root);
    }

    //count number of node in tree
    public int count(Node p) {
        if (p == null) {
            return 0;
        }
        return 1 + count(p.left) + count(p.right);
    }

    //Node min() - find and return the node with minimum value in the tree. 
    //If the tree is empty, return null
    public Node min() {
        if (root == null) {
            return null;
        }
        Node p = root;
        while (p.left != null) {
            p = p.left;
        }
        return p;
    }

    //int height() - return the height of the tree
    public int height() {
        return height(root);
    }

    // preorder
    public void preOrder(Node p) {
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }
        if (p != null) {
            visit(p);
            preOrder(p.left);
            preOrder(p.right);
        }
    }

    // inorder
    public void inOrder(Node p) {

        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }
        if (p != null) {
            inOrder(p.left);
            visit(p);
            inOrder(p.right);
        }
    }

    // postorder
    public void postOrder(Node p) {
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }
        if (p != null) {
            postOrder(p.left);
            postOrder(p.right);
            visit(p);
        }
    }

    //rotate left
    public void rotateLeft(Node p) {
        Node q = p.right;
        p.right = q.left;
        q.left = p;
        if (p == root) {
            root = q;
        } else {
            Node f = findFather(p);
            if (f.left == p) {
                f.left = q;
            } else {
                f.right = q;
            }
        }
    }

    private Node findFather(Node p) {
        Node f = root;
        while (f != null) {
            if (f.left == p || f.right == p) {
                return f;
            }
            if (p.info.getCode().compareTo(f.info.getCode()) < 0) {
                f = f.left;
            } else {
                f = f.right;
            }
        }
        return null;
    }

    //rotate right
    public void rotateRight(Node p) {
        Node q = p.left;
        p.left = q.right;
        q.right = p;
        if (p == root) {
            root = q;
        } else {
            Node f = findFather(p);
            if (f.left == p) {
                f.left = q;
            } else {
                f.right = q;
            }
        }
    }

    //double rotate left
    public void doubleRotateLeft(Node p) {
        if (p != null) {
            rotateRight(p.right);
            rotateLeft(p);
        }
    }

    //double rotate right
    public void doubleRotateRight(Node p) {
        if (p != null) {
            rotateLeft(p.left);
            rotateRight(p);
        }
    }

    //clear
    public void clear(Node p) {
        if (p != null) {
            clear(p.left);
            clear(p.right);
            p = null;
        }
    }

    //height
    public int height(Node p) {
        if (p == null) {
            return 0;
        }
        int hL = height(p.left);
        int hR = height(p.right);
        if (hL > hR) {
            return hL + 1;
        } else {
            return hR + 1;
        }
    }

    //check AVL tree
    public boolean checkAVL(Node p) {
        if (p == null) {
            return true;
        }
        int hL = height(p.left);
        int hR = height(p.right);
        if (Math.abs(hL - hR) <= 1 && checkAVL(p.left) && checkAVL(p.right)) {
            return true;
        }
        return false;
    }

    //balance AVL
    public void balanceAVL(Node p) {
        if (p != null) {
            int hL = height(p.left);
            int hR = height(p.right);
            if (hL - hR == 2) {
                int hLL = height(p.left.left);
                int hLR = height(p.left.right);
                if (hLL >= hLR) {
                    rotateRight(p);
                } else {
                    doubleRotateRight(p);
                }
            }
            if (hL - hR == -2) {
                int hRL = height(p.right.left);
                int hRR = height(p.right.right);
                if (hRL >= hRR) {
                    doubleRotateLeft(p);
                } else {
                    rotateLeft(p);
                }
            }
        }
    }

    //delete AVL
    public void deleteAVL(String code) {
        Node p = search(code);
        if (p != null) {
            delete(code);
            balanceAVL(p);
        }
    }

    private void delete(String code) {
        Node f, p;
        p = root;
        f = null;
        while (p != null) {
            if (code.compareTo(p.info.getCode()) == 0) {
                break;
            }
            f = p;
            if (code.compareTo(p.info.getCode()) < 0) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        if (p == null) {
            return;
        }
        if (p.left == null && p.right == null) {
            if (f == null) {
                root = null;
            } else {
                if (p == f.left) {
                    f.left = null;
                } else {
                    f.right = null;
                }
            }
        } else {
            if (p.left == null || p.right == null) {
                Node c;
                if (p.left == null) {
                    c = p.right;
                } else {
                    c = p.left;
                }
                if (f == null) {
                    root = c;
                } else {
                    if (p == f.left) {
                        f.left = c;
                    } else {
                        f.right = c;
                    }
                }
            } else {
                Node c, fc;
                fc = p;
                c = p.right;
                while (c.left != null) {
                    fc = c;
                    c = c.left;
                }
                p.info = c.info;
                if (fc.left == c) {
                    fc.left = c.right;
                } else {
                    fc.right = c.right;
                }
            }
        }

    }

    //load file
    /* 
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
     */
    void loadFile(String fname) throws IOException {
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
            if (a.length < 5) {
                System.out.println("Invalid line format: " + s);
                continue;
            }
            xCode = a[0].trim();
            xName = a[1].trim();
            xIncome = Double.parseDouble(a[2].trim());
            xDeduct = Double.parseDouble(a[3].trim());
            xTax = Double.parseDouble(a[4].trim());
            insert(new TaxPayer(xCode, xName, xIncome, xDeduct, xTax));
        }
        fr.close();
        br.close();
    }

    /*
    private void insertAVL(TaxPayer taxPayer) {
        Node p = root;
        Node f = null;
        while (p != null) {
            if (taxPayer.getCode().compareTo(p.info.getCode()) == 0) {
                return;
            }
            f = p;
            if (taxPayer.getCode().compareTo(p.info.getCode()) < 0) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        Node q = new Node(taxPayer);
        if (f == null) {
            root = q;
        } else {
            if (taxPayer.getCode().compareTo(f.info.getCode()) < 0) {
                f.left = q;
            } else {
                f.right = q;
            }
        }
        balanceAVL(q);
    }
     */
    //inorder traverse to file
    void inOrderToFile(String fname, Node p) throws IOException {
        FileWriter fw = new FileWriter(fname);
        PrintWriter pw = new PrintWriter(fw);
        inOrderToFileHelper(pw, p);
        pw.close();
        fw.close();
    }

    void inOrderToFileHelper(PrintWriter pw, Node p) {
        if (p == null) {
            return;
        }
        inOrderToFileHelper(pw, p.left);
        visitToFile(p, pw);
        inOrderToFileHelper(pw, p.right);
    }

    private void visitToFile(Node p, PrintWriter pw) {
        if (p == null) {
            return;
        }
        pw.println(p.info.getCode() + "|" + p.info.getName() + "|" + p.info.getIncome() + "|" + p.info.getDeduct() + "|" + p.info.getTax());
    }

    //traverse breadth first
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

    //count node
    int countNode(Node p) {
        if (p == null) {
            return 0;
        }
        return 1 + countNode(p.left) + countNode(p.right);
    }

    private TaxPayer getInforObject() {
        //input taxPayer
        String code = Validate.inputString("Enter code: ", "Wrong format, code must contain 2 uppercase first and next is 6 number", "^[A-Z]{2}[0-9]{6}$");
        String name = Validate.inputString("Enter name: ");
        double income = Validate.inputDouble("Enter income: ", 0, Double.MAX_VALUE);
        double deduct = Validate.inputDouble("Enter deduct: ", 0, Double.MAX_VALUE);
        double tax = taxCalculator(income, deduct);
        TaxPayer tp = new TaxPayer(code, name, income, deduct, tax);
        return tp;
    }

    public double taxCalculator(double income, double deduct) {
        double taxableIncome = income - deduct;
        if(taxableIncome <0) {
            return 0;
        }
        if (taxableIncome <= 5000) {
            return taxableIncome * 5 / 100;
        } else if (taxableIncome > 5000 && taxableIncome <= 10000) {
            return taxableIncome * 10 / 100;
        } else {
            return taxableIncome * 15 / 100;
        }
    }

    Node searchByCode() {
        String code = Validate.inputString("Enter code: ", "Code is not empty", "^[A-Z]{2}[0-9]{6}$");
        Node tmp = root;
        while (tmp != null) {
            if (tmp.info.code.equalsIgnoreCase(code)) {
                return tmp;
            } else if (code.compareToIgnoreCase(tmp.info.code) < 0) {
                tmp = tmp.left;
            } else {
                tmp = tmp.right;
            }
        }
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
        Node f, p, q;
        p = root;
        f = null;
        while (p != null) {
            if (p.info == x) {
                break;
            }
            f = p;
            if (x.tax < p.info.tax) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        if (p == null) {
            return;
        }
        if (p.left == null) {
            q = p.right;
        } else if (p.right == null) {
            q = p.left;
        } else {
            q = p.right;
            while (q.left != null) {
                q = q.left;
            }
            q.left = p.left;
        }
        if (f == null) {
            root = q;
        } else if (p == f.left) {
            f.left = q;
        } else {
            f.right = q;
        }

    }

    //balance tree
    public void balance() {
        ArrayList<TaxPayer> a = new ArrayList();
        inOrderToArray(a, root);
        clear();
        balanceTree(a, 0, a.size() - 1);
    }

    //balance tree
    public void balanceTree(ArrayList<TaxPayer> a, int i, int j) {
        if (i > j) {
            return;
        }
        int m = (i + j) / 2;
        insert(a.get(m));
        balanceTree(a, i, m - 1);
        balanceTree(a, m + 1, j);
    }

    //Copy all tree nodes to an array
    public void inOrderToArray(ArrayList<TaxPayer> a, Node p) {
        if (p == null) {
            return;
        }
        inOrderToArray(a, p.left);
        a.add(p.info);
        inOrderToArray(a, p.right);
    }

    // Counting the number of TaxPayers in the list.
    void countTaxPayers() {
        int count = 0;
        Node tmp = root;

        while (tmp != null) {
            count++;
            tmp = tmp.right;
        }
        System.out.println("Number of TaxPayers: " + count);

    }

    //avl tree delete by code
    public void deleteByCode() {
        String code = Validate.inputString("Enter code: ", "Code is not empty", "^[A-Z]{2}[0-9]{6}$");
        Node tmp = root;
        Node f = null;
        // Searching for a node in a binary search tree.
        while (tmp != null) {
            if (tmp.info.code.equalsIgnoreCase(code)) {
                break;
            }
            f = tmp;
            if (code.compareToIgnoreCase(tmp.info.code) < 0) {
                tmp = tmp.left;
            } else {
                tmp = tmp.right;
            }
        }
        // Checking if the variable tmp is null. If it is null, it returns.
        if (tmp == null) {
            System.out.println("Not found");
            return;
        }
        // Deleting a node from a binary tree.
        if (tmp.left == null) {
            if (f == null) {
                root = tmp.right;
            } else {
                if (tmp == f.left) {
                    f.left = tmp.right;
                } else {
                    f.right = tmp.right;
                }
            }
        } // Deleting a node with no children.
        else if (tmp.right == null) {
            if (f == null) {
                root = tmp.left;
            } else {
                if (tmp == f.left) {
                    f.left = tmp.left;
                } else {
                    f.right = tmp.left;
                }
            }
        } // Deleting a node from a binary search tree.
        else {
            Node q = tmp.right;
            f = null;
            while (q.left != null) {
                f = q;
                q = q.left;
            }
            tmp.info = q.info;
            if (f == null) {
                tmp.right = q.right;
            } else {
                f.left = q.right;
            }
        }
        System.out.println("Deleted successfully");
    }

}
