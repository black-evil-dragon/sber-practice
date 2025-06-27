package ru.sbertech.practice.paint.core;

public abstract class Figure {

    protected Color figureColor;
    protected Point figurePosition;

    public Figure(Point figurePosition, Color figureColor) {
        this.figureColor = figureColor;
        this.figurePosition = figurePosition;
    }

    public abstract double area();
    public abstract double perimeter();


    public void setColor(Color figureColor) {
        this.figureColor = figureColor;
    }

    public Color getColor() {
        return this.figureColor;
    }
}
