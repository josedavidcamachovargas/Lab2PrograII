/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1.singletonpattern;

import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.TreeMap;
import ejercicio1.objects.Purchase;
import ejercicio1.objects.Status;
import ejercicio1.objects.StatusComparator;
import ejercicio1.objects.StatusEnum;
import ejercicio1.objects.Test;

/**
 * Esta clase se encarga de crear una lista tambien  de tipo tree la cual contiene 
 * compras, un consecutivo una instancia. al igual que la DeliveredPurchaseList, 
 * esta contiene metodos como el de agregar, el de actualizar el estado y dos 
 * ordenamientos, por estado y por el codigo.
 * 
 * @author Andrés Antonio Gonzalez Orozco B83477
 * @author José David Camacho Vargas B91484
 */
public class ProcessingPurchasesList {
    
    // Attributes
    
    private TreeMap<Integer, Purchase> purchasesList;
    private static int consecutive;
    private static ProcessingPurchasesList instance;
    
    // Constructors

    public ProcessingPurchasesList() {
        consecutive = 0;
        purchasesList = new TreeMap();
    }
    
    
    // Methods
    
    public static ProcessingPurchasesList getInstance() {
        if (instance == null) {
            instance = new ProcessingPurchasesList();
        }
        return instance;
    }
        
    public void addPurchase(Purchase purchase) {
        purchase.setConsecutive(consecutive + 1);
        consecutive++;
        purchase.setDate((GregorianCalendar)GregorianCalendar.getInstance());
        purchase.setStatus(new Status(purchase.getDate()));
        ArrayList<Object> consecutiveStatus = new ArrayList<>(2);
        consecutiveStatus.add(purchase.getConsecutive());
        consecutiveStatus.add(purchase.getStatus());
        purchase.notifyObservers(consecutiveStatus);
        purchasesList.put(consecutive, purchase);
    }
    
    public Purchase getPurchase(int consecutive) {
        return purchasesList.get(consecutive);
    }
    
    public void updateStatus(int consecutive) {
        Purchase purchase = purchasesList.get(consecutive);
        purchase.updateStatus();
        ArrayList<Object> consecutiveStatus = new ArrayList<>(2);
        consecutiveStatus.add(purchase.getConsecutive());
        consecutiveStatus.add(purchase.getStatus());
        purchase.notifyObservers(consecutiveStatus);
        
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
