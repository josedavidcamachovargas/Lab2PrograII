/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2.builder;

import java.awt.Point;

/**
 * @author Andrés Antonio Gonzalez Orozco B83477
 * @author José David Camacho Vargas B91484
 */

public interface AbstractFigureBuilder {
    void buildFigure();
    void buildPoint(Point p);
    void buildCentralPoint(double centralPoint);
    void buildRatio(double ratio);
    void buildWidth(double width);
    void buildHeight(double height);
}
