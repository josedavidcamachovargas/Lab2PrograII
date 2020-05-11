/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

/**
 *
 * @author Andrés Antonio Gonzalez Orozco B83477
 * @author José David Camacho Vargas B91484
 */
public enum StatusEnum {
    
    DELIVERED("Entregado"),
    IN_TRANSIT("En tránsito"),
    DISPATCH_WAITING("En espera para ser despachado"),
    PROCESSING("En tránsito"),
    PROCESS_WAITING("Entregado");
    
    private final String description;
    
    private StatusEnum (String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
    
    
}
