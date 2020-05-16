/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2.factory;

/**
 * This class is incharge to creates a rectangle with their respective measures
 * and variables that are going to say their coordinates of the upper left point,
 * the high distance and the width distance.
 * @author Andrés Antonio Gonzalez Orozco B83477
 * @author José David Camacho Vargas B91484 
 */
public class Rectangle {
    private int upperLeftPoint;//coordenadas del punto superior izquierdo
    private int highDistance;//distancia de alto
    private int widthDistance;//distancia de ancho

    public Rectangle() {
    }

    public int getUpperLeftPoint() throws FactoryException {
        if (upperLeftPoint < 0) {
            throw new FactoryException("El punto superior izquierdo no puede ser negativo");
        }
        return upperLeftPoint;
    }

    public void setUpperLeftPoint(int upperLeftPoint) {
        this.upperLeftPoint = upperLeftPoint;
    }

    public int getHighDistance() throws FactoryException {
        if (highDistance < 0) {
            throw new FactoryException("La distancia de alto no puede ser negativo");
        }
        return highDistance;
    }

    public void setHighDistance(int highDistance) {
        this.highDistance = highDistance;
    }

    public int getWidthDistance() throws FactoryException {
        if (widthDistance < 0) {
            throw new FactoryException("El ancho no puede ser negativo");
        }
        return widthDistance;
    }

    public void setWidthDistance(int widthDistance) {
        this.widthDistance = widthDistance;
    }

    @Override
    public String toString() {
        return "Rectangle: " + "upperLeftPoint: " + upperLeftPoint + ", highDistance: " + highDistance + ", widthDistance: " + widthDistance;
    }
    
    
}
