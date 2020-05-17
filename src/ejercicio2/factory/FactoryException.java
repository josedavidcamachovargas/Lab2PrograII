/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2.factory;

/**
 * Esta clase se encarga de crear una excepcion personalizada que sera 
 * utilizada en otras clases para mostrar un mensaje.
 * @author Andrés Antonio Gonzalez Orozco B83477
 * @author José David Camacho Vargas B91484  
 */
public class FactoryException extends Exception {

    public FactoryException(String message) {
        super(message);
    }  
}
