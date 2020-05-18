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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * ESta clase se encarga de crear un mural con un ArrayList de figuras, ésta
 * implementa de clonable con lo cual se crea el metodo copy que se encarga de
 * hacer una copia de una figura a base de su indice.
 *
 * @author Andrés Antonio Gonzalez Orozco B83477
 * @author José David Camacho Vargas B91484
 */
public class MuralComponent implements Copyable {

    private ArrayList<MuralComponent> figures;
    private int index;

    public MuralComponent() {
        figures = new ArrayList<>();
    } 
    

    
    
    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }


    public void addFigure(MuralComponent f) {
        figures.add(f);
    }

    public void deleteFigure(MuralComponent f) {
        figures.remove(f);
    }

    public void showInformation() {
        Iterator<MuralComponent> i = figures.iterator();
        while (i.hasNext() != false) {
            System.out.println(i.next().toString());
        }
    }

    @Override
    public Object copy(int index) {
        MuralComponent figure = new MuralComponent();
        try {
            figure = (MuralComponent)figures.get(index).clone();
        } catch (CloneNotSupportedException ex) {
            System.out.println(ex.getMessage());;
        }
        return figure;
    }
    

}
