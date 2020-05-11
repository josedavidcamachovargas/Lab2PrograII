/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1.strategypattern;

import java.util.ArrayList;
import java.util.Iterator;
import ejercicio1.objects.Purchase;

/**
 *
 * @author Andrés Antonio Gonzalez Orozco B83477
 * @author José David Camacho Vargas B91484
 */
public class PlaneShipping implements ShippingTypeStrategy{

    @Override
    public double calculatePrice(Purchase purchase) {
        return purchase.totalWeight() * 30;
    }
    
}
