package ru.sbertech.practice.paint.core;

public abstract class Figure {

    protected Color color;
    protected Point position;

    protected double area;
    protected double perimeter;

    public Figure(Point figurePosition, Color figureColor) {
        this.color = figureColor;
        this.position = figurePosition;
    }


    public abstract double area();
    public abstract double perimeter();




    public void setColor(Color figureColor) {
        this.color = figureColor;
    }

    public Color getColor() {
        return this.color;
    }

    public Point getCenterPositon() {
        return this.position;
    }
}
