/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2.factory;

/**
 * @author Andrés Antonio Gonzalez Orozco B83477
 * @author José David Camacho Vargas B91484
 */
public class RectangleFactory implements FigureFactory {

    @Override
    public Figure createFigure() {
        return new Rectangle();
    }
    
}
