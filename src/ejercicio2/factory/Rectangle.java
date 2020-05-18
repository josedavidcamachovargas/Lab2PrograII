/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2.factory;

import java.awt.Point;

/**
 * Esta clase se encarga de crear un Rectangulo basio con sus respectivos metodos
 * set, get  y tambien dos metodos de diferencia entre el punto superior izquierdo
 * y la altura, y el otro metodo lo mismo pero esta vez con el ancho.
 * @author Andrés Antonio Gonzalez Orozco B83477
 * @author José David Camacho Vargas B91484 
 */
public class Rectangle extends Figure{
    
    private double height;//distancia de alto
    private double width;//distancia de ancho

    public Rectangle() {
      super();
    }


    public void setPoint(Point upperLeftPoint) throws FactoryException {
        if (upperLeftPoint.x < 0 || upperLeftPoint.y < 0) {
            throw new FactoryException("El punto superior izquierdo no puede ser negativo");
        }
        super.setPoint(upperLeftPoint);
    }

    public double getHeightDistance() {
        return height;
        
    }

    public void setHighDistance(double height) throws FactoryException {
        if (height < 0) {
            throw new FactoryException("La distancia de alto no puede ser negativo");
        }
        this.height = height;
    }

    public double getWidthDistance() {
        return width;
    }

    public void setWidthDistance(double  width) {
        this.width = width;
    }

    @Override
    public String toString() {
        return "Rectangulo -> " + " punto superior izquierdo: " + getPoint() + ", alto: " + height + ", ancho: " + width;
    }

    @Override
    public boolean diference() {
        double differenceHeight1 = height - getPoint().x;
        double differenceHeight2 = height - getPoint().y;
        double  differenceWidth1 = width - getPoint().x;
        double  differenceWidth2 = width - getPoint().y;
        if (differenceWidth1 > 0 && differenceHeight1 > 0 && differenceWidth2 > 0 && differenceHeight2 > 0) {
            return true;
        } else {
            return false;
        }
    }
}
