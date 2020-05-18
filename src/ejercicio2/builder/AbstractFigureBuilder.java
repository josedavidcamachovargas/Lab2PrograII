/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2.builder;

import ejercicio2.factory.Figure;
import java.awt.Point;

/**
 * Esta interface se encarga de crear los metodos que se van a implementar
 * en las diferentes clases builder de objetos en este caso figuras.
 * @author Andrés Antonio Gonzalez Orozco B83477
 * @author José David Camacho Vargas B91484
 */

public interface AbstractFigureBuilder {
    void buildFigure();
    void buildPoint(Point p);
    Figure getFigure();
}
