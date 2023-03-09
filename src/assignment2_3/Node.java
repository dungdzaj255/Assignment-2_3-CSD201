/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment2_3;

/**
 *
 * @author dungd
 */
public class Node {

    TaxPayer info;
    Node left;
    Node right;

    Node() {
    }

    Node(TaxPayer x) {
        info = x;
        left = right = null;
    }
}
