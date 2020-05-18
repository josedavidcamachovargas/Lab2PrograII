/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2.test;

import ejercicio2.composite.MixedFigure;
import ejercicio2.composite.MuralComponent;
import ejercicio2.factory.CircleFactory;
import ejercicio2.factory.FactoryException;
import ejercicio2.factory.Figure;
import ejercicio2.factory.FigureFactory;
import ejercicio2.factory.RectangleFactory;
import java.awt.Point;

/**
 * Prueba del ejercicios 2
* @author Andrés Antonio Gonzalez Orozco B83477
 * @author José David Camacho Vargas B91484
 */
public class Test {
    public static void main (String [] args){
        // Prueba Circulo
        
        FigureFactory factory = new CircleFactory();
        Figure circle = factory.createFigure();
        circle.diference();
        System.out.println(circle.toString());
        
        // Prueba Rectangulo
        FigureFactory factory1 = new RectangleFactory();
        Figure rectangle = factory1.createFigure();
        rectangle.diference();
        System.out.println(" " + rectangle.diference());
        System.out.println(rectangle.toString());
//        MuralComponent mc = new MuralComponent(figures);
    } 
}
