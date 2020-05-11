/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DecoratorPattern;

/**
 *
 * @author Andrés Antonio Gonzalez Orozco B83477
 * @author José David Camacho Vargas B91484
 */
public class FragileWrap extends AdditionalType {
    private final double PORCENTAGE_PRICE = 0.01;

    public FragileWrap(Additional additional) {
        super(additional);
    }

    @Override
    public double calculatePrice() {
        return getAdditional().calculatePrice() + getAdditional().calculatePrice() * PORCENTAGE_PRICE;
    }
    
    
}
