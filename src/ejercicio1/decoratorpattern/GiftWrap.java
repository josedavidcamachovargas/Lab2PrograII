/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1.decoratorpattern;

/**
 *
 * @author Andrés Antonio Gonzalez Orozco B83477
 * @author José David Camacho Vargas B91484
 */
public class GiftWrap extends AdditionalType {
    private final int PRICE = 5;

    public GiftWrap(Additional additional) {
        super(additional);
    }

    @Override
    public double calculatePrice() {
        return getAdditional().calculatePrice() + PRICE;
    }
    
    
}
