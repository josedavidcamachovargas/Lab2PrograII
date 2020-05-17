/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2.composite;

import java.util.ArrayList;

/**
 * @author Andrés Antonio Gonzalez Orozco B83477
 * @author José David Camacho Vargas B91484
 */
public class MixedFigure {
    public ArrayList<MuralComponent> figureList;

    public MixedFigure() {
    }

    public MixedFigure(ArrayList<MuralComponent> figureList) {
        this.figureList = figureList;
    }

    public ArrayList<MuralComponent> getFigureList() {
        return figureList;
    }

    public void setFigureList(ArrayList<MuralComponent> figureList) {
        this.figureList = figureList;
    }

    @Override
    public String toString() {
        return "List de figuras: " + figureList.toString();
    }
}
