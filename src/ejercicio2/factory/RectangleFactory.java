/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2.factory;

import ejercicio2.builder.FigureDirector;

/**
 * Clase que define un método estándar para crear un objeto, en este caso un rectangulo,
 * aparte de un constructor, pero la decisión de qué tipo de objeto crear se va a dejar
 * a las subclases.
 * @author Andrés Antonio Gonzalez Orozco B83477
 * @author José David Camacho Vargas B91484
 */
public class RectangleFactory extends FigureDirector implements FigureFactory {

    @Override
    public Figure createFigure() {
        return new Rectangle();
    }
    
}
