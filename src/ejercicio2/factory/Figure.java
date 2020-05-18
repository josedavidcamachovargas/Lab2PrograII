/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2.factory;

import ejercicio2.composite.MuralComponent;
import java.awt.Point;

/**
 * Clase abstracta Figura la cual tiene un metodo llamado diferencia
 * como tambien un punto como variable con sus metodos set y get.
 * @author Andrés Antonio Gonzalez Orozco B83477
 * @author José David Camacho Vargas B91484
 */
public abstract class Figure extends MuralComponent implements Cloneable {
    public Point point;

    public Figure() {
    }

    public Figure(Point point) {
        this.point = point;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) throws FactoryException{
        this.point = point;
    }

    @Override
    public String toString() {
        return "\nFigura ->" + " point: " + point;
    }
    
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    
    //This method works for the differences in the classes
    public abstract boolean diference();
    
}
