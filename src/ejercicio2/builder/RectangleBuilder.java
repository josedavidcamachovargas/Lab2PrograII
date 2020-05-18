/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2.builder;

import ejercicio2.factory.Circle;
import ejercicio2.factory.Figure;
import ejercicio2.factory.Rectangle;
import java.awt.Point;

/**
 * @author Andrés Antonio Gonzalez Orozco B83477
 * @author José David Camacho Vargas B91484
 */
public class RectangleBuilder implements AbstractFigureBuilder {
    private Figure figure;
    private Circle circle;
    private Rectangle rectangle;
    
    @Override
    public void buildFigure(){
        figure = new Figure();
        circle = new Circle();
        rectangle = new Rectangle();
    }

    @Override
    public void buildPoint(Point p) {
        figure.setPoint(p);
    }

    @Override
    public void buildRatio(double ratio) {
        circle.setRatioDistance((int) ratio);
    }

    @Override
    public void buildWidth(double width) {
        rectangle.setWidthDistance((int) width);
    }

    @Override
    public void buildHeight(double height) {
        rectangle.setHighDistance((int) height);
    }

    @Override
    public void buildCentralPoint(double centralPoint) {
        circle.setCentralPoint(centralPoint);
    }
}