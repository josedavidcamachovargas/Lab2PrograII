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
 * ESta clase se encarga de crear un mural con un ArrayList de figuras, ésta implementa
 * de clonable con lo cual se crea el metodo copy que se encarga de hacer una 
 * copia de una figura a base de su indice.
 * @author Andrés Antonio Gonzalez Orozco B83477
 * @author José David Camacho Vargas B91484
 */
public class MuralComponent implements Copyable {

    private ArrayList<Figure> figures;
    private int index;

    public MuralComponent(ArrayList<Figure> figures) {
        this.figures = figures;
    }

    public void addFigure(Figure f) {
        figures.add(f);
    }

    public void deleteFigure(Figure f) {
        figures.remove(f);
    }

    public void showInformation() {
        Iterator<Figure> i = figures.iterator();
        while (i.hasNext() != false) {
            System.out.println(i.next().toString());
        }
    }

    @Override
    public Object copy(int index) {
        Figure figure = new Figure();
        figure = figures.get(index);
        return figure;
    }

    //Este metodo se encarga de verificar que el indice agregado tenga una figura
    //y lo envia a una varaible global
    private int index(int index) {
        Iterator<Figure> i = figures.iterator();
        while (i.hasNext() != false) {
            if (figures.indexOf(i) == index) {
                this.index = index;
            }
        }
        return -1;
    }
}
