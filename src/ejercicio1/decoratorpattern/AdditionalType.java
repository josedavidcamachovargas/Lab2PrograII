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
public abstract class AdditionalType implements Additional {
    private final Additional additional;

    public AdditionalType(Additional additional) {
        this.additional = additional;
    }

    public Additional getAdditional() {
        return additional;
    }
    
    
}
