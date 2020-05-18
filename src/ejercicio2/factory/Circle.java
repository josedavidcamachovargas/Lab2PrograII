/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2.factory;

/**
 * 
 * Esta clase se encarga de crear un Circulo basio con sus respectivos metodos
 * set, get  y tambien agregando una diferencia entre el punto central y la
 * distacia del radio heredados de la clase abstracta figura.
 * @author Andrés Antonio Gonzalez Orozco B83477
 * @author José David Camacho Vargas B91484
 */
public class Circle extends Figure{
    private int centralPoint;
    private int ratioDistance;

    public Circle() {
  
    }
    
    public Circle(int centralPoint, int ratioDistance) {
        this.centralPoint = centralPoint;
        this.ratioDistance = ratioDistance;
    }

    public int getCentralPoint() throws FactoryException{
        if (centralPoint < 0) {
            throw new FactoryException("El punto central no puede ser negativo");
        }
        return centralPoint;
    }

    public void setCentralPoint(int centralPoint) {
        this.centralPoint = centralPoint;
    }

    public int getRatioDistance() throws FactoryException{
        if (ratioDistance < 0) {
            throw new FactoryException("La distancia de radio no puede ser negativa");
        }
        return ratioDistance;
    }

    public void setRatioDistance(int ratioDistance) {
        this.ratioDistance = ratioDistance;
    }

    @Override
    public String toString() {
        return "Circulo ->" + " Punto central: " + centralPoint + ", distancia de radio: " + ratioDistance;
    }

    @Override
    public boolean diference() {
        int difference = ratioDistance - centralPoint;
        if (difference > 0) {
            return true;
        } else {
            return false;
        }
    }
}
