/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2.builder;

import ejercicio2.factory.Figure;
import java.awt.Point;

/**
 * @author Andrés Antonio Gonzalez Orozco B83477
 * @author José David Camacho Vargas B91484
 */
public class FigureDirector {
    public Figure createCircle(AbstractFigureBuilder afb, Point point, double ratio){
        if(afb == null){
            afb = new CircleBuilder();
        }
        return null;
    }
    
    public Figure createRectangle(AbstractFigureBuilder afb, Point point, double width, double height){
        if(afb == null){
            afb = new RectangleBuilder();
        }
        
        return null;
    }
}
