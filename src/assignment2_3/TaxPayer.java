/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment2_3;

/**
 *
 * @author dungd
 */
public class TaxPayer implements Comparable<TaxPayer> {

    String code;
    String name;
    double income;
    double deduct;
    double tax;

    public TaxPayer() {
    }

    public TaxPayer(String code, String name, double income, double deduct, double tax) {
        this.code = code;
        this.name = name;
        this.income = income;
        this.deduct = deduct;
        this.tax = tax;
    }

    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public double getDeduct() {
        return deduct;
    }

    public void setDeduct(double deduct) {
        this.deduct = deduct;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double taxCalculator() {
        double taxableIncome = income - deduct;
        if (taxableIncome <= 5000) {
            return taxableIncome * 5 / 100;
        } else if (taxableIncome > 5000 && taxableIncome <= 10000) {
            return taxableIncome * 10 / 100;
        } else {
            return taxableIncome * 15 / 100;
        }
    }

    @Override
    public String toString() {
        return String.format("%-12s%-10s%-12.2f%-14.2f%.2f",code, name, income, deduct, tax);
    }

    @Override
    public int compareTo(TaxPayer o) {
        return code.compareToIgnoreCase(o.getCode());
    }
}
