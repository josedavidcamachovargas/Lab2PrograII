/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

/**
 * 
 *
 * @author Andrés Antonio Gonzalez Orozco B83477
 * @author José David Camacho Vargas B91484
 */
public class DeliveredPurchasesList {
    
    // Attributes
    
    private TreeSet<Purchase> purchasesList;
    
    
    // Constructors

    public DeliveredPurchasesList() {
        purchasesList = new TreeSet();
    }
    
    
    // Methods
    
    public void addPurchase(Purchase purchase) {
        purchasesList.add(purchase);
    }
    
    public String purchasesByStatusDate() {
        ArrayList<Purchase> list = new ArrayList(purchasesList);
        Collections.sort(list);
        return list.toString();
    }
}//Hola
