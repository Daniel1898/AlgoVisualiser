package com.daniel1898.petproject;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class SortingElement extends Rectangle {
    private int num;
    private boolean isSelected;

    public SortingElement(double x, double y, double width, int num) {
        super(x, y + (200 - num), width, num);
        this.num = num;
        this.setFill(Color.BLUE);
        this.setStroke(Color.RED);
        this.setLayoutY(y);
        this.isSelected = false;

    }

    static void swap(SortingElement elem1, SortingElement elem2){
        try {
            elem1.select();
            //Thread.sleep(100);
            elem2.select();
            Thread.sleep(200);
            double elem1X = elem1.getX();
            elem1.setX(elem2.getX());
            elem2.setX(elem1X);
            Thread.sleep(500);
            elem1.select();
            elem2.select();
        } catch (InterruptedException e) {
        e.printStackTrace();
    }
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void blink100(){
        this.setFill(Color.RED);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.setFill(Color.BLUE);
    }

    public void select(){
        if (isSelected){
            this.setFill(Color.BLUE);
            isSelected = false;
        } else
        {
            this.setFill(Color.RED);
            isSelected = true;
        }
    }

    public int compareWith(SortingElement element){
        return this.num - element.getNum();
    }

}
