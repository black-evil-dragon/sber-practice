package ru.sbertech.practice.paint.objects;

import ru.sbertech.practice.paint.core.Color;
import ru.sbertech.practice.paint.core.Drawable;
import ru.sbertech.practice.paint.core.Figure;
import ru.sbertech.practice.paint.core.Point;

public class Rectangle extends Figure implements Drawable {

    private int width;
    private int height;

    public Rectangle(int width, int height, Point centerFigure, Color figureColor) {
        super(centerFigure, figureColor);

        setParams(width, height);
    }

    public Rectangle(int width, int height, Point centerFigure) {
        this(width, height, centerFigure, Color.BLACK);
    }



    private void setParams(int width, int height) {
        if (width > 0 && height > 0) {
            this.width = width;
            this.height = height;

            this.area = area();
            this.perimeter = perimeter();
        }
    }


    @Override
    public double area() {
        return width * height;
    }

    @Override
    public double perimeter() {
        return 2 * (width + height);
    }

    @Override
    public void draw() {
        draw(color);
    }

    @Override
    public void draw(Color color) {
        return;
    }


    public int getWidth() {
        return width;
    }
}