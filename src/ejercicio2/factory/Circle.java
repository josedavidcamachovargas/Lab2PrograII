/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2.factory;

import java.awt.Point;

/**
 * 
 * Esta clase se encarga de crear un Circulo basio con sus respectivos metodos
 * set, get  y tambien agregando una diferencia entre el punto central y la
 * distacia del radio heredados de la clase abstracta figura.
 * @author Andrés Antonio Gonzalez Orozco B83477
 * @author José David Camacho Vargas B91484
 */
public class Circle extends Figure {

    private double  ratioDistance;

    public Circle() {
        super();
    }
    
    public Circle(Point centralPoint, int ratioDistance) throws FactoryException {
        super.setPoint(centralPoint);
        this.ratioDistance = ratioDistance;
    }


    @Override
    public void setPoint(Point centralPoint) throws FactoryException {
        if (centralPoint.x < 0 || centralPoint.y < 0) {
            throw new FactoryException("El punto central no puede ser negativo");
        }
        super.setPoint(centralPoint);
    }

    public double  getRatioDistance() {
        return ratioDistance;
    }

    public void setRatioDistance(double  ratioDistance) throws FactoryException {
        if (ratioDistance < 0) {
            throw new FactoryException("La distancia de radio no puede ser negativa");
        }
        this.ratioDistance = ratioDistance;
    }

    @Override
    public String toString() {
        return "Circulo ->" + " Punto central: " + getPoint() + ", distancia de radio: " + ratioDistance;
    }

    @Override
    public boolean diference() {
        double difference1 = ratioDistance - getPoint().x;
        double difference2 = ratioDistance - getPoint().y;
        if (difference1 > 0 && difference1 > 0 ) {
            return true;
        } else {
            return false;
        }
    }
}
