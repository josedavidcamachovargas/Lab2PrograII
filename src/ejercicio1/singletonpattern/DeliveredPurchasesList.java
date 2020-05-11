/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1.singletonpattern;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;
import ejercicio1.objects.Purchase;

/**
 * 
 *
 * @author Andrés Antonio Gonzalez Orozco B83477
 * @author José David Camacho Vargas B91484
 */
public class DeliveredPurchasesList {
    
    // Attributes
    private TreeSet<Purchase> purchasesList;
    private static DeliveredPurchasesList instance;
    
    // Constructors
    public DeliveredPurchasesList() {
        purchasesList = new TreeSet();
    }

    public static DeliveredPurchasesList getInstance() {
        if (instance == null) {
            instance = new DeliveredPurchasesList();
        }
        return instance;
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
}
