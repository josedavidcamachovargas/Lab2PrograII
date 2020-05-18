/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2.builder;

import ejercicio2.factory.Figure;
import java.awt.Point;

/**
 * Esta clase funciona como un directorio en la cual se crean los metodos 
 * de creacion de un circulo y rectangulo en este caso de los cuales se 
 * tiene como parametros primeramente una 
 * @author Andrés Antonio Gonzalez Orozco B83477
 * @author José David Camacho Vargas B91484
 */
public class FigureDirector implements AbstractFigureBuilder {
    

    public static Figure createCircle(AbstractFigureBuilder afb, Point point, double ratio) {
        if (afb == null) {
            afb = new CircleBuilder();
        }
        afb.buildFigure();
        afb.buildPoint(point);
        ((CircleBuilder)afb).buildRatio(ratio);
        return afb.getFigure();
    }

    public static Figure createRectangle(AbstractFigureBuilder afb, Point point, double width, double height) {
        if (afb == null) {
            afb = new RectangleBuilder();
        }
        afb.buildFigure();
        afb.buildPoint(point);
        ((RectangleBuilder)afb).buildWidth(width);
        ((RectangleBuilder)afb).buildHeight(height);
        return afb.getFigure();
    }

    @Override
    public void buildFigure() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void buildPoint(Point p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Figure getFigure() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
