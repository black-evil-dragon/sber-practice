package ru.sbertech.practice.paint.objects;

import ru.sbertech.practice.paint.core.Color;
import ru.sbertech.practice.paint.core.Drawable;
import ru.sbertech.practice.paint.core.Point;
import ru.sbertech.practice.paint.objects.Rectangle;

public class Square extends Rectangle implements Drawable {
    public Square(int width, Point centerFigure, Color figureColor) {
        super(width, width, centerFigure, figureColor);
    }

    public Square(int width, Point centerFigure) {
        this(width, centerFigure, Color.BLACK);
    }

    @Override
    public void draw(Color color) {
        System.out.println(
                "Нарисован квадрат со стороной " + getWidth()
                + " и центром в точке " + getCenterPositon()
                + " с цветом " + color
        );
    }
}