/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2.composite;

import ejercicio2.factory.Figure;
import ejercicio2.prototype.Copyable;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Andrés Antonio Gonzalez Orozco B83477
 * @author José David Camacho Vargas B91484
 */
public class MuralComponent implements Copyable{

    public ArrayList<Figure> figures;

    public MuralComponent(ArrayList<Figure> figures) {
        this.figures = figures;
    }
    
    public void addFigure(Figure f){
        figures.add(f);
    }
    
    public void deleteFigure(Figure f){
        figures.remove(f);
    }
    
    public void showInformation(){
        Iterator<Figure> i = figures.iterator();
        while(i.hasNext() != false){
            System.out.println(i.next().toString()); 
        }
    }

    @Override
    public Object copy() {
        return new MuralComponent(figures);
    }
}
