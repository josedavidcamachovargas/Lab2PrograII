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
public class RectangleBuilder implements AbstractFigureBuilder {
    private Figure figure;
        
    @Override
    public void BuildFigure(){
        figure = new Figure();
    }

    @Override
    public void buildPoint(Point p) {
        figure.setPoint(p);
    }

    @Override
    public void buildRatio(double ratio) {
        figure.setRatioDistance((int) ratio);
    }

    @Override
    public void buildWidth(double width) {
        figure.setWidth((int) width);
    }

    @Override
    public void buildHeight(double height) {
        figure.setHeight((int) height);
    }
}