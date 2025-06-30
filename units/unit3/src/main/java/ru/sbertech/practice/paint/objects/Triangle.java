package ru.sbertech.practice.paint.objects;

import ru.sbertech.practice.paint.core.Color;
import ru.sbertech.practice.paint.core.Drawable;
import ru.sbertech.practice.paint.core.Figure;
import ru.sbertech.practice.paint.core.Point;
import ru.sbertech.practice.paint.utils.FigureUtil;

import static ru.sbertech.practice.paint.utils.FigureUtil.distance;

public class Triangle extends Figure implements Drawable {

    // Вершины треугольника
    private Point topA;
    private Point topB;
    private Point topC;


    /* Центроида
    x̄ = (x₁ + x₂ + ... + xₙ) / n
    ȳ = (y₁ + y₂ + ... + yₙ) / n
     */



    public Triangle(Point topA, Point topB, Point topC, Color figureColor) {
        super(getCenterFigure(topA, topB, topC), figureColor);

        this.topA = topA;
        this.topB = topB;
        this.topC = topC;
    }
    public Triangle(Point topA, Point topB, Point topC) {
        this(topA, topB, topC, Color.BLACK);
    }


//    public Triangle(double sideLength, Point center, Color color) {
//        super(center, color);
//        setTopPoints(sideLength, center);
//    }
//    public Triangle(double sideLength, Point center) {
//        this(sideLength, center, Color.BLACK);
//    }


//    private void setTopPoints(double sideLength, Point center) {
//    }


    private static Point getCenterFigure(Point topA, Point topB, Point topC) {
        int centerX = (int) ((topA.getPositionX() + topB.getPositionX() + topC.getPositionX()) / 3);
        int centerY = (int) ((topA.getPositionX() + topB.getPositionX() + topC.getPositionX()) / 3);

        return new Point(centerX, centerY);
    }

    @Override
    public void draw() {
        draw(Color.BLACK);
    }

    @Override
    public void draw(Color color) {
        System.out.printf(
                "Нарисован треугольник с вершинами в точках"
                + topA + ", " + topB + ", " + topC
                + " и цветом "
                + color
        );
    }

    @Override
    public double area() {
        double a = distance(topA, topB);
        double b = distance(topB, topC);
        double c = distance(topC, topA);
        double p = perimeter() / 2;

        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    @Override
    public double perimeter() {
        return distance(topA, topB) + distance(topB, topC) + distance(topC, topA);
    }
}
