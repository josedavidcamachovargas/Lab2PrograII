/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2.test;

import ejercicio2.builder.AbstractFigureBuilder;
import ejercicio2.builder.CircleBuilder;
import ejercicio2.builder.FigureDirector;
import ejercicio2.builder.RectangleBuilder;
import ejercicio2.composite.MixedFigure;
import ejercicio2.composite.MuralComponent;
import ejercicio2.factory.Circle;
import ejercicio2.factory.CircleFactory;
import ejercicio2.factory.FactoryException;
import ejercicio2.factory.Figure;
import ejercicio2.factory.FigureFactory;
import ejercicio2.factory.Rectangle;
import ejercicio2.factory.RectangleFactory;
import java.awt.Point;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Prueba del ejercicios 2
 *
 * @author Andrés Antonio Gonzalez Orozco B83477
 * @author José David Camacho Vargas B91484
 */
public class Test {

    public static void main(String[] args) {
        // Prueba Circulo

        FigureFactory factoryCircle = new CircleFactory();
        Figure circle = factoryCircle.createFigure();
        
        AbstractFigureBuilder abstractFigureBuilder = new CircleBuilder();
        
        Point point1 = new Point(2, 5);
        circle = FigureDirector.createCircle(abstractFigureBuilder, point1, 5);
        
        
        System.out.println(" " + circle.diference());//Retorna true si es mayor a 0 o false si es menor
        System.out.println(circle.toString());

        // Prueba Rectangulo
        FigureFactory factoryRectangle = new RectangleFactory();
        Figure rectangle = factoryRectangle.createFigure();

        abstractFigureBuilder = new RectangleBuilder();
        
        Point point2 = new Point(1, 2);
        rectangle = FigureDirector.createRectangle(abstractFigureBuilder, point2, 5, 10);

        System.out.println(" " + rectangle.diference());//Retorna true si es mayor a 0 o false si es menor
        System.out.println(rectangle.toString());

        
        
        // Prueba Prototype
        
        MuralComponent muralComponent = new MuralComponent();
        muralComponent.addFigure(circle);
        muralComponent.addFigure(rectangle);
        
        MixedFigure mixedFigure = new MixedFigure();
        mixedFigure.addFigure((MuralComponent)muralComponent.copy(0));
        mixedFigure.addFigure((MuralComponent)muralComponent.copy(1));
        
        muralComponent.addFigure(mixedFigure);
        
        System.out.println("-----------------------------------------");
        System.out.println("-----------------------------------------");
        System.out.println("-----------------------------------------");
        System.out.println("Prueba Prototype");
        System.out.println("-----------------------------------------");
        System.out.println("-----------------------------------------");
        System.out.println("-----------------------------------------");
        muralComponent.showInformation();
        
    }
}
