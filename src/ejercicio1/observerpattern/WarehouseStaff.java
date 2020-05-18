/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1.observerpattern;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Andrés Antonio Gonzalez Orozco B83477
 * @author José David Camacho Vargas B91484
 */
public class WarehouseStaff implements Observer {
    
    private ArrayList<ArrayList<Object>> consecutiveStatusList;

    public WarehouseStaff() {
        consecutiveStatusList = new ArrayList<>();
    }
    
    private String showConsecutiveStatusList() {
        Iterator<ArrayList<Object>> consecutiveStatusListIterator = consecutiveStatusList.iterator();
        
        String text = "";
        
        while(consecutiveStatusListIterator.hasNext()) {
            text += consecutiveStatusListIterator.next().toString() + "\n";
        }
        return text;
    }
    
    @Override
    public void update(Object updating) {
        consecutiveStatusList.add((ArrayList<Object>)updating);
    }
    
}
