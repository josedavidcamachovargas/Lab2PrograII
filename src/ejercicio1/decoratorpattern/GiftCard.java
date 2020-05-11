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
public class GiftCard extends AdditionalType {
    private String giftCardCode;
    private double discount;

    public GiftCard(Additional additional) {
        super(additional);
    }

    public GiftCard(String giftCardCode, double discount, Additional additional) {
        super(additional);
        this.giftCardCode = giftCardCode;
        this.discount = discount;
    }

    @Override
    public double calculatePrice() {
        return getAdditional().calculatePrice() - getAdditional().calculatePrice() * (discount / 100);
    }
    
    
}
