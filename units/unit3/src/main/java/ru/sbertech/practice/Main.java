package ru.sbertech.practice;


import ru.sbertech.practice.paint.core.Color;
import ru.sbertech.practice.paint.core.Point;
import ru.sbertech.practice.paint.objects.Circle;
import ru.sbertech.practice.paint.objects.Rectangle;
import ru.sbertech.practice.paint.objects.Square;
import ru.sbertech.practice.paint.objects.Triangle;
import ru.sbertech.practice.paint.utils.FigureUtil;

public class Main {
    public static void main(String[] args) {

        Circle circle = new Circle(
            5,
            new Point(0, 0)

        );

        Triangle triangle = new Triangle(
            new Point(0, 0),
            new Point(4, 0),
            new Point(0, 3)
        );

        Rectangle rectangle = new Rectangle(
            5,
            10,
            new Point(0, 0)
        );

        Square square = new Square(
            4,
            new Point(0, 0)
        );

        System.out.println("Площадь круга: " + FigureUtil.area(circle));
        System.out.println("Длина окружности: " + FigureUtil.perimeter(circle));

        System.out.println("Площадь прямоугольника: " + FigureUtil.area(rectangle));
        System.out.println("Периметр прямоугольника: " + FigureUtil.perimeter(rectangle));

        System.out.println("Площадь квадрата: " + FigureUtil.area(square));
        System.out.println("Периметр квадрата: " + FigureUtil.perimeter(square));

        System.out.println("Площадь треугольника: " + FigureUtil.area(triangle));
        System.out.println("Периметр треугольника: " + FigureUtil.perimeter(triangle));



        FigureUtil.draw(circle);
        FigureUtil.draw(rectangle, Color.RED);
        FigureUtil.draw(square, Color.BLUE);
        FigureUtil.draw(triangle, Color.GREEN);

    }
}
