/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2.composite;

import ejercicio2.factory.Figure;
import java.util.ArrayList;

/**
 * @author Andrés Antonio Gonzalez Orozco B83477
 * @author José David Camacho Vargas B91484
 */
public class MixedFigure extends MuralComponent implements Cloneable {
    public ArrayList<Figure> figureList;

    public MixedFigure() {
        figureList = new ArrayList<>();
    }

    public MixedFigure(ArrayList<Figure> figureList) {
        this.figureList = figureList;
    }

    public ArrayList<Figure> getFigureList() {
        return figureList;
    }

    public void setFigureList(ArrayList<Figure> figureList) {
        this.figureList = figureList;
    }
    
    @Override
    public void addFigure(MuralComponent f) {
        figureList.add((Figure)f);
    }

    @Override
    public String toString() {
        String txt = "";
        for (Figure figure: figureList) {
            txt += figure.toString() + "\n";
        }
        return "List de figuras:\n " + txt;
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException {
        ArrayList<Figure> figureListClone = new ArrayList<>();
        for (Figure figure : figureList) {
            figureListClone.add((Figure)figure.clone());
        }
        return figureListClone;
    }
    
}
