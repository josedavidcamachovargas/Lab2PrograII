/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SingletonPattern;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.TreeMap;
import objects.Purchase;
import objects.Status;
import objects.StatusComparator;
import objects.StatusEnum;
import objects.Test;

/**
 *
 * @author Andrés Antonio Gonzalez Orozco B83477
 * @author José David Camacho Vargas B91484
 */
public class ProcessingPurchasesList {
    
    // Attributes
    
    private TreeMap<Integer, Purchase> purchasesList;
    private static int consecutive;
    
    
    // Constructors

    public ProcessingPurchasesList() {
        consecutive = 0;
        purchasesList = new TreeMap();
    }
    
    
    // Methods
    
    public void addPurchase(Purchase purchase) {
        purchase.setConsecutive(consecutive + 1);
        consecutive++;
        purchase.setDate((GregorianCalendar)GregorianCalendar.getInstance());
        purchase.setStatus(new Status(purchase.getDate()));
        purchasesList.put(consecutive, purchase);
    }
    
    public void updateStatus(int consecutive) {
        Purchase purchase = purchasesList.get(consecutive);
        purchase.updateStatus();
        purchasesList.replace(consecutive, purchase);
        if (purchasesList.get(consecutive).getStatus().getStatus() == StatusEnum.DELIVERED) {
            Test.deliveredPurchasesList.addPurchase(purchasesList.remove(consecutive));
        }
    }
    
    public String purchasesByStatus() {
        ArrayList<Purchase> list = new ArrayList(purchasesList.values());
        Collections.sort(list, new StatusComparator());
        return list.toString();
    }
    
    public String purchasesByCode() {
        String txt = "";
        ArrayList<Purchase> list = new ArrayList(purchasesList.values());
        Iterator<Purchase> iterator = list.iterator();
        while(iterator.hasNext()) {
            txt += iterator.next().toString() + "\n";
        }        
        return txt;
    }
}
