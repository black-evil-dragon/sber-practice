package ru.sbertech.practice.paint.utils;

import ru.sbertech.practice.paint.core.Color;
import ru.sbertech.practice.paint.core.Drawable;
import ru.sbertech.practice.paint.core.Figure;
import ru.sbertech.practice.paint.core.Point;

public class FigureUtil {
    private FigureUtil() {}

    public static double area(Figure figure) {
        return figure.area();
    }

    public static double perimeter(Figure figure) {
        return figure.perimeter();
    }

    public static void draw(Figure figure) {
        if (figure instanceof Drawable) {
            ((Drawable) figure).draw();
        } else {
            System.out.println("Фигура не поддерживает рисование");
        }
    }

    public static void draw(Figure figure, Color color) {
        if (figure instanceof Drawable) {
            ((Drawable) figure).draw(color);
        } else {
            System.out.println("Фигура не поддерживает рисование");
        }
    }


    public static double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p2.getPositionX() - p1.getPositionX(), 2) + Math.pow(p2.getPositionY() - p1.getPositionY(), 2));
    }
}