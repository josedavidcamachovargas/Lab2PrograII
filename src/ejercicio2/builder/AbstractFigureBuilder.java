/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2.builder;

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
    void buildCentralPoint(double centralPoint);
    void buildRatio(double ratio);
    void buildUpperLeftPoint(double upperLeftPoint);
    void buildWidth(double width);
    void buildHeight(double height);
}
