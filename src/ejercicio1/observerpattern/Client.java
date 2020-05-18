/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1.observerpattern;

import ejercicio1.objects.Status;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Esta clase se encarga de crear un cliente basico con sus respectivos metodos.
 * @author Andrés Antonio Gonzalez Orozco B83477
 * @author José David Camacho Vargas B91484
 */
public class Client implements Observer {
    private String id;
    private String email;
    private ArrayList<Status> purchaseStatusList;

    public Client() {
        purchaseStatusList = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    private String showConsecutiveStatusList() {
        Iterator<Status> purchaseStatusListIterator = purchaseStatusList.iterator();
        
        String text = "";
        
        while(purchaseStatusListIterator.hasNext()) {
            text += purchaseStatusListIterator.next().toString() + "\n";
        }
        return text;
    }

    @Override
    public String toString() {
        return "Cliente: " + "Cédula = " + id + ". Correo electrónico = " + email + ".";
    }

    @Override
    public void update(Object updating) {
        purchaseStatusList.add((Status)updating);
    }
    
}
