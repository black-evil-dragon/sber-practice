package ru.sbertech.practice.paint.objects;

import ru.sbertech.practice.paint.core.Color;
import ru.sbertech.practice.paint.core.Drawable;
import ru.sbertech.practice.paint.core.Figure;
import ru.sbertech.practice.paint.core.Point;

public class Circle extends Figure implements Drawable {

    private double radius;

    public Circle(Point figurePosition, double radius) {
        super(figurePosition, Color.BLACK);

        this.radius = radius;
    }


    @Override
    public double area() {
        return Math.PI * radius * radius;
    }


    @Override
    public double perimeter() {
        return Math.PI * radius * 2;
    }


    @Override
    public void draw() {

    }


    @Override
    public void draw(Color color) {

    }
}
