/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2.factory;

import ejercicio1.singletonpattern.DeliveredPurchasesList;

/**
 * @author Andrés Antonio Gonzalez Orozco B83477
 * @author José David Camacho Vargas B91484
 */
public class Circle {
    private int centralPoint;
    private int ratioDistance;

    public Circle(int centralPoint, int ratioDistance) {
        this.centralPoint = centralPoint;
        this.ratioDistance = ratioDistance;
    }

    public int getCentralPoint() {
        if (centralPoint < 0) {
            
        }
        return centralPoint;
    }

    public void setCentralPoint(int centralPoint) {
        this.centralPoint = centralPoint;
    }

    public int getRatioDistance() {
        return ratioDistance;
    }

    public void setRatioDistance(int ratioDistance) {
        this.ratioDistance = ratioDistance;
    }

    @Override
    public String toString() {
        return "Circulo ->" + " Punto central: " + centralPoint + ", distancia de radio: " + ratioDistance;
    }
    
    
}
