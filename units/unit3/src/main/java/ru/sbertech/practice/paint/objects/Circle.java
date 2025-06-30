package ru.sbertech.practice.paint.objects;

import ru.sbertech.practice.paint.core.Color;
import ru.sbertech.practice.paint.core.Drawable;
import ru.sbertech.practice.paint.core.Figure;
import ru.sbertech.practice.paint.core.Point;

public class Circle extends Figure implements Drawable {

    private int radius;


    public Circle(int radius, Point figurePosition, Color color) {
        super(figurePosition, color);

        this.radius = radius;
        this.area = area();
        this.perimeter = perimeter();
    }

    public Circle(int radius, Point figurePosition) {
        this(radius, figurePosition, Color.BLACK);
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
