package ejercicio1.objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import ejercicio1.observerpattern.Client;
import ejercicio1.decoratorpattern.Additional;
import ejercicio1.observerpattern.Observer;
import ejercicio1.observerpattern.ObserverManager;
import ejercicio1.strategypattern.ShippingTypeStrategy;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Esta clase se encarga de crear una compra con metodos como un toString 
 * mnejorado, un  productListString(), totalWeight(), addProduct(), removeProduct(),
 * updateStatus(), y por ultimo los metodos calculatePrice() y compareTo() que se 
 * implementan de interfaces creadas anteriormente.
 * 
 * @author Andrés Antonio Gonzalez Orozco B83477
 * @author José David Camacho Vargas B91484
 */
public class Purchase implements Comparable<Purchase>, Additional, ObserverManager{
    
    // Attributes
    
    private int consecutive;
    private GregorianCalendar date;
    private Status status;
    private TreeMap<String, Product> productsList;
    private Client client;
    private ShippingTypeStrategy shippingType = null;
    private ArrayList<Observer> receptorList;
    
    // Constructors

    public Purchase() {
        productsList = new TreeMap();
        receptorList =  new ArrayList<>();
    }
    
    
    // set's and get's

    public int getConsecutive() {
        return consecutive;
    }

    public void setConsecutive(int consecutive) {
        this.consecutive = consecutive;
    }

    public GregorianCalendar getDate() {
        return date;
    }

    public void setDate(GregorianCalendar date) {
        this.date = date;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public ShippingTypeStrategy getShippingType() {
        return shippingType;
    }

    public void setShippingType(ShippingTypeStrategy shippingType) {
        this.shippingType = shippingType;
    }
    
    
    // toString

    @Override
    public String toString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yy - mm:ss:S");
        String dateString = simpleDateFormat.format(date.getTime());
        DecimalFormat formatDouble = new DecimalFormat("#.##");
        return "Consecutivo: " + consecutive
             + "\nFecha: " + dateString
             + "\n\nEstado: " + status
             + "\n\nLista de Productos: \n\n" + productListString(productsList)
             + "\nPeso total: " + formatDouble.format(totalWeight()) + "\n\n\n";
    }
    
    private String productListString(TreeMap<String, Product> productList) {
        ArrayList<Product> list = new ArrayList(productsList.values());
        Iterator<Product> productsListIterator = list.iterator();
        
        String text = "";
        
        while(productsListIterator.hasNext()) {
            text += productsListIterator.next().toString();
        }
        return text;
    }
    
    
    // Methods
    
    public double totalWeight() {
        Iterator<Map.Entry<String, Product>> productsListIterator = productsList.entrySet().iterator();
        double totalWeight = 0;
        
        while(productsListIterator.hasNext()) {
            totalWeight += productsListIterator.next().getValue().generalWeight();
        }
        
        return totalWeight;
    }
    
    public void addProduct(Product tempProduct) {
        Iterator<Map.Entry<String, Product>> productsListIterator = productsList.entrySet().iterator();
        Product product;
        int added = 0;
        while(productsListIterator.hasNext()) {
            product = productsListIterator.next().getValue();
            if (product.getCode().equals(tempProduct.getCode())) {
                product.setQuantity(product.getQuantity() + tempProduct.getQuantity());
                added = 1;
            }
        }
        if (added == 0) {
            productsList.put(tempProduct.getCode(), tempProduct);
        }
    }
    
    public Product removeProduct(String code) {
        return productsList.remove(code);
    }
    
    public boolean updateStatus() {
        status.setDate((GregorianCalendar)GregorianCalendar.getInstance());
        return status.updateStatus();
    }

    @Override
    public double calculatePrice() {
        return shippingType.calculatePrice(this);
    }
    
    @Override
    public int compareTo(Purchase other) {
        return this.getStatus().getDate().compareTo(other.getStatus().getDate());
    }

    @Override
    public void registerObserver(Observer observer) {
        receptorList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        int i = receptorList.indexOf(observer);
        if (i >= 0) {
            receptorList.remove(i);
        }
    }

    @Override
    public void notifyObservers(Object updating) {
        for (int i = 0; i < receptorList.size(); i++) {
            Observer observer = (Observer) receptorList.get(i);
            
            if (observer instanceof Client) {
                observer.update((Status)((ArrayList<Object>)updating).get(1));
            } else {
                observer.update(updating);
            }
        }
    }


    
}
