/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2_progra;

import java.text.DecimalFormat;

/**
 *
 * @author Andrés Antonio Gonzalez Orozco B83477
 * @author José David Camacho Vargas B91484
 */
public class Product {
    
    // Attributes
    
    private String code;
    private int quantity;
    private double weight;
    
    
    // Constructor

    public Product(String code, int quantity, double weight) {
        this.code = code;
        this.quantity = quantity;
        this.weight = weight;
    }
    
    
    // set's and get's

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    
    // toString
    
    @Override
    public String toString() {
        DecimalFormat formatDouble = new DecimalFormat("#.##");
        return "Product: " + "Código = " + code + ". Cantidad = " + quantity
             + ". Peso = " + formatDouble.format(weight) + ".\n";
    }
    
    
    // Methods
    
    public double generalWeight() {
        return quantity * weight;
    }
    
}
