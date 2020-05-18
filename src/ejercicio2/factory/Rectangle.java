/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2.factory;

/**
 * Esta clase se encarga de crear un Rectangulo basio con sus respectivos metodos
 * set, get  y tambien dos metodos de diferencia entre el punto superior izquierdo
 * y la altura, y el otro metodo lo mismo pero esta vez con el ancho.
 * @author Andrés Antonio Gonzalez Orozco B83477
 * @author José David Camacho Vargas B91484 
 */
public class Rectangle extends Figure{
    private double  upperLeftPoint;//coordenadas del punto superior izquierdo
    private double height;//distancia de alto
    private double width;//distancia de ancho

    public Rectangle() {
      super();
    }

    public double  getUpperLeftPoint() throws FactoryException {
        if (upperLeftPoint < 0) {
            throw new FactoryException("El punto superior izquierdo no puede ser negativo");
        }
        return upperLeftPoint;
    }

    public void setUpperLeftPoint(double upperLeftPoint) {
        this.upperLeftPoint = upperLeftPoint;
    }

    public double getHeight() throws FactoryException {
        if (height < 0) {
            throw new FactoryException("La distancia de alto no puede ser negativo");
        }
        return height;
    }

    public void setHighDistance(int height) {
        this.height = height;
    }

    public double getWidthDistance() throws FactoryException {
        if (width < 0) {
            throw new FactoryException("El ancho no puede ser negativo");
        }
        return width;
    }

    public void setWidthDistance(double  width) {
        this.width = width;
    }

    @Override
    public String toString() {
        return "Rectangulo -> " + " punto superior izquierdo: " + upperLeftPoint + ", alto: " + height + ", ancho: " + width;
    }

    @Override
    public boolean diference() {
        double differenceHeight = height - upperLeftPoint;
        double  differenceWidth = width - upperLeftPoint;
        if (differenceWidth > 0 || differenceHeight > 0) {
            return true;
        } else {
            return false;
        }
    }
}
