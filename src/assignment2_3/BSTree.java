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
    //constructor
    BSTree() {
        root = null;
    }
    public void visit(Node p) {
        System.out.println(p);
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
    public void insert(int x) {
        Node p = root;
        Node par = null;
        while (p != null) {
            par = p;
            if (x < p.info) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        if (root == null) {
            root = new Node(x);
        } else if (x < par.info) {
            par.left = new Node(x);
        } else {
            par.right = new Node(x);
        }
    }

    // search
    public Node search(int x) {
        Node p = root;
        while (p != null) {
            if (x < p.info) {
                p = p.left;
            } else if (x > p.info) {
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
    //Node max() - find and return the node with maximum value in the tree.
    //If the tree is empty, return null
    public Node max() {
        if (root == null) {
            return null;
        }
        Node p = root;
        while (p.right != null) {
            p = p.right;
        }
        return p;
    }
    //int height() - return the height of the tree
    public int height() {
        return height(root);
    }
    //int sum() - return the sum of all values in the tree
    public int sum() {
        return sum(root);
    }
    public int sum(Node p) {
        if (p == null) {
            return 0;
        }
        return p.info + sum(p.left) + sum(p.right);
    }
    //int avg() - return the average of all values in the tree
    public int avg() {
        return sum() / count();
    }
    //The cost of a path in a tree is sum of the keys of the nodes participating  in that path. Write a  function that returns the cost of the most expensive  path from the root to a leaf node.
    public int maxCost() {
        return maxCost(root);
    }
    public int maxCost(Node p) {
        if (p == null) {
            return 0;
        }
        return p.info + Math.max(maxCost(p.left), maxCost(p.right));
    }
    //minCost() - return the cost of the cheapest path from the root to a leaf node.
    public int minCost() {
        return minCost(root);
    }
    public int minCost(Node p) {
        if (p == null) {
            return 0;
        }
        return p.info + Math.min(minCost(p.left), minCost(p.right));
    }

    // delete by merging
    public void deleteByMerging(int x) {
        Node f, p, q;
        f = null;
        p = root;
        while (p != null) {
            if (p.info == x) {
                break;
            }
            f = p;
            if (x < p.info) {
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
            Node r = p;
            q = p.right;
            p = p.right;
            while (p.left != null) {
                p = p.left;
            }
            p.left = r.left;
        }
        if (f == null) {
            root = q;
        } else if (f.left == p) {
            f.left = q;
        } else {
            f.right = q;
        }
    }

    public void deleteByMerging1(int x) {
        Node p = search(x);
        if (p == null) {
            System.out.println("Key " + x + " does not exists, deletion failed");
            return;
        }
        // find f is father of p
        Node f = null, q = root;
        while (q != p) {
            f = q;
            if (q.info > p.info)
                q = q.left;
            else
                q = q.right;
        }
        // 1.p has no child
        if (p.left == null && p.right == null) {
            if (f == null)
                root = null;
            else if (f.left == p)
                f.left = null;
            else
                f.right = null;
        }
        // 2.p has left child only
        else if (p.left != null && p.right == null) {
            if (f == null)
                root = p.left;
            else if (f.left == p)
                f.left = p.left;
            else
                f.right = p.left;
        }
        // 3.p has right child only
        else if (p.left == null && p.right != null) {
            if (f == null)
                root = p.right;
            else if (f.left == p)
                f.left = p.right;
            else
                f.right = p.right;
        }
        // 4.p has both child
        else if (p.left != null && p.right != null) {
            // tim q la node lon nhat ben con trai cua p -> q la con phai nhat
            // cua con trai cua p
            q = p.left;
            Node t = null;
            while (q.right != null) {
                t = q;
                q = q.right;
            }
            Node rp = p.right;
            q.right = rp;
            if (f == null)
                root = p.left;
            else if (f.left == p)
                f.left = p.left;
            else
                f.right = p.left;
        }
    }
    //delete by Copying have reference Node p
    void deleteByCopy(Node p){
        if(p==null){
            return;
        }
        if(p.left==null&&p.right==null){
            p=null;
            return;
        }
        if(p.left==null){
            p=p.right;
            return;
        }
        if(p.right==null){
            p=p.left;
            return;
        }
        Node f=p;
        Node q=p.left;
        while(q.right!=null){
            f=q;
            q=q.right;
        }
        p.info=q.info;
        if(f!=p){
            f.right=q.left;
        }else{
            f.left=q.left;
        }
    }

    // delete by copying
    public void deleteByCopying(int x) {
        Node f, p, q;
        f = null;
        p = root;
        while (p != null) {
            if (p.info == x) {
                break;
            }
            f = p;
            if (x < p.info) {
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
            Node r = p;
            q = p.right;
            p = p.right;
            while (p.left != null) {
                p = p.left;
            }
            p.left = r.left;
        }
        if (f == null) {
            root = q;
        } else if (f.left == p) {
            f.left = q;
        } else {
            f.right = q;
        }
    }
    
    public void deleteByCopy(int x) {
        Node p = search(x);
        if (p == null) {
            System.out.println("Key " + x + " does not exists, deletion failed");
            return;
        }
        // find f is father of p
        Node f = null, q = root;
        while (q != p) {
            f = q;
            if (q.info > p.info)
                q = q.left;
            else
                q = q.right;
        }
        // 1.p has no child
        if (p.left == null && p.right == null) {
            if (f == null)
                root = null;
            else if (f.left == p)
                f.left = null;
            else
                f.right = null;
        }
        // 2.p has left child only
        else if (p.left != null && p.right == null) {
            if (f == null)
                root = p.left;
            else if (f.left == p)
                f.left = p.left;
            else
                f.right = p.left;
        }
        // 3.p has right child only
        else if (p.left == null && p.right != null) {
            if (f == null)
                root = p.right;
            else if (f.left == p)
                f.left = p.right;
            else
                f.right = p.right;
        }
        // 4.p has both child
        else if (p.left != null && p.right != null) {
            // tim q la node lon nhat ben con trai cua p -> q la con phai nhat
            // cua con trai cua p
            q = p.left;
            f = null;
            while (q.right != null) {
                f = q;
                q = q.right;
            }
            p.info = q.info;
            // delete q
            if (f == null)
                p.left = q.left;
            else
                f.right = q.left;
        }
    }

    // preorder
    public void preOrder(Node p) {
        if (p != null) {
            visit(p);
            preOrder(p.left);
            preOrder(p.right);
        }
    }

    // inorder
    public void inOrder(Node p) {
        if (p != null) {
            inOrder(p.left);
            visit(p);
            inOrder(p.right);
        }
    }

    // postorder
    public void postOrder(Node p) {
        if (p != null) {
            postOrder(p.left);
            postOrder(p.right);
            visit(p);
        }
    }
    //void breadth() - traverse a tree from root
    void breadth() {
        breadth(root);
    }
    // beadth
    public void breadth(Node v) {
        if (v == null) {
            return;
        }
        Queue q = new LinkedList();
        q.add(v);
        while (!q.isEmpty()) {
            Node p = (Node) q.remove();
            visit(p);
            if (p.left != null) {
                q.add(p.left);
            }
            if (p.right != null) {
                q.add(p.right);
            }
        }
    }
    //balancing a BST
    public void balance(ArrayList a, int l, int r) {
        if (l > r) {
            return;
        }
        int m = (l + r) / 2;
        insert((int) a.get(m));
        balance(a, l, m - 1);
        balance(a, m + 1, r);
    }
    //Copy all tree nodes to an array
    public void copyToArray(Node p, ArrayList a) {
        if (p == null) {
            return;
        }
        copyToArray(p.left, a);
        a.add(p.info);
        copyToArray(p.right, a);
    }
    
    //balance summary
    public void balance() {
        ArrayList a = new ArrayList();
        copyToArray(root, a);
        clear(root);
        balance(a, 0, a.size() - 1);
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
        Node f = null;
        Node q = root;
        while (q != p) {
            f = q;
            if (q.info > p.info) {
                q = q.left;
            } else {
                q = q.right;
            }
        }
        return f;
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
        if(p!= null){
            rotateRight(p.right);
            rotateLeft(p);
        }
    }
    //double rotate right
    public void doubleRotateRight(Node p) {
        if(p!= null){
            rotateLeft(p.left);
            rotateRight(p);
        }
    }
    //clear
    public void clear(Node p){
        if(p != null){
            clear(p.left);
            clear(p.right);
            p = null;
        }
    }
    //height
    public int height(Node p){
        if(p == null){
            return 0;
        }
        int hL = height(p.left);
        int hR = height(p.right);
        if(hL > hR){
            return hL + 1;
        }else{
            return hR + 1;
        }
    }
    //check AVL tree
    public boolean checkAVL(Node p){
        if(p == null){
            return true;
        }
        int hL = height(p.left);
        int hR = height(p.right);
        if(Math.abs(hL - hR) <= 1 && checkAVL(p.left) && checkAVL(p.right)){
            return true;
        }
        return false;
    }
    //balance AVL
    public void balanceAVL(Node p){
        if(p != null){
            int hL = height(p.left);
            int hR = height(p.right);
            if(hL - hR == 2){
                int hLL = height(p.left.left);
                int hLR = height(p.left.right);
                if(hLL >= hLR){
                    rotateRight(p);
                }else{
                    doubleRotateRight(p);
                }
            }
            if(hL - hR == -2){
                int hRL = height(p.right.left);
                int hRR = height(p.right.right);
                if(hRL >= hRR){
                    doubleRotateLeft(p);
                }else{
                    rotateLeft(p);
                }
            }
        }
    }
    //insert AVL
    public void insertAVL(Node p){
        if(p != null){
            insert(p.info);
            balanceAVL(p);
        }
    }
    // Write a  function to determine whether a given binary tree is a heap.
    public boolean checkHeap(Node p){
        if(p == null){
            return true;
        }
        if(p.left != null && p.info < p.left.info){
            return false;
        }
        if(p.right != null && p.info < p.right.info){
            return false;
        }
        return checkHeap(p.left) && checkHeap(p.right);
    }

    //load file
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
    //insert taxpayer to tree by AVL
    void insertAVL(TaxPayer x) {
        root = insertAVL(root, x);
    }
    
    
    //traverse in order
    void inOrder(Node p) {
        if (p == null) {
            return;
        }
        inOrder(p.left);
        visit(p);
        inOrder(p.right);
    }
    //traverse pre order
    void preOrder(Node p) {
        if (p == null) {
            return;
        }
        visit(p);
        preOrder(p.left);
        preOrder(p.right);
    }
    //traverse post order
    void postOrder(Node p) {
        if (p == null) {
            return;
        }
        postOrder(p.left);
        postOrder(p.right);
        visit(p);
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
    void SaveInOrder(PrintWriter pw, Node p) {
        if (pw == null || p == null) {
            return;
        }
        inOrder(p.left);
        pw.printf("%10s | %10s | %.2f | %.2f | %.2f\r\n", p.info.code, p.info.name, p.info.income, p.info.deduct, p.info.tax);
        inOrder(p.right);
    }

    //save file
    void saveFile(String fname, Node p) throws IOException { // Using FileReader class
        FileWriter fw = new FileWriter(fname);
        PrintWriter pw = new PrintWriter(fw);
        SaveInOrder(pw, p);
        pw.close();
        fw.close();
    }

    Node searchByCode(String code) {
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
    void balance() {

    }

    void countTaxPayers() {
        int count = 0;
        Node tmp = root;
        while (tmp != null) {
            count++;
            tmp = tmp.right;
        }
        System.out.println("Number of TaxPayers: " + count);

    }

}
