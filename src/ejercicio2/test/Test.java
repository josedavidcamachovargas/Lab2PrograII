/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2.test;

import ejercicio2.factory.Circle;
import ejercicio2.factory.CircleFactory;
import ejercicio2.factory.Figure;
import ejercicio2.factory.FigureFactory;
import ejercicio2.factory.Rectangle;
import ejercicio2.factory.RectangleFactory;

/**
 * Prueba del ejercicios 2
 *
 * @author Andrés Antonio Gonzalez Orozco B83477
 * @author José David Camacho Vargas B91484
 */
public class Test {

    public static void main(String[] args) {
        // Prueba Circulo

        FigureFactory factory = new CircleFactory();
        Figure circle = factory.createFigure();

        ((Circle) circle).setCentralPoint(2.5);
        ((Circle) circle).setRatioDistance(5);
        System.out.println(" " + circle.diference());//Retorna true si es mayor a 0 o false si es menor
        System.out.println(circle.toString());

        // Prueba Rectangulo
        FigureFactory factory1 = new RectangleFactory();
        Figure rectangle = factory1.createFigure();

        ((Rectangle) rectangle).setHighDistance(10);
        ((Rectangle) rectangle).setWidthDistance(5);
        ((Rectangle) rectangle).setUpperLeftPoint(12);
        System.out.println(" " + rectangle.diference());//Retorna true si es mayor a 0 o false si es menor
        System.out.println(rectangle.toString());

    }
}
