/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2.builder;

import ejercicio2.factory.Circle;
import ejercicio2.factory.FactoryException;
import ejercicio2.factory.Figure;
import java.awt.Point;

/**
 * Esta clase implementa de AbstractFigureBuilder la cual implementa todos
 * sus metodos para asi crearlos de manera que se puedan utilizar creando una 
 * nueva figura. Los metodos se modificaron llamando al respectivo set de los
 * metodos base. 
 * @author Andrés Antonio Gonzalez Orozco B83477
 * @author José David Camacho Vargas B91484
 */
public class CircleBuilder implements AbstractFigureBuilder{
    private Circle circle;
    
    @Override
    public void buildFigure(){
        circle = new Circle();
    }

    @Override
    public void buildPoint(Point p) {
        try {
            circle.setPoint(p);
        } catch (FactoryException ex) {
            System.out.println(ex.getMessage());
        }
    }


    public void buildRatio(double ratio) {
        try {
            circle.setRatioDistance(ratio);
        } catch (FactoryException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public Figure getFigure() {
        return circle;
    }

}