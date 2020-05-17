/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1.objects;

import java.util.Comparator;

/**
 * Esta clase se encarga implementando el comparator de hacer una comparacion 
 * entre los estados de dos compras 
 * @author Andrés Antonio Gonzalez Orozco B83477
 * @author José David Camacho Vargas B91484
 */
public class StatusComparator implements Comparator<Purchase>{

    @Override
    public int compare(Purchase purchase1, Purchase purchase2) {
        return purchase1.getStatus().getStatus().compareTo(purchase2.getStatus().getStatus());
    }
    
}
