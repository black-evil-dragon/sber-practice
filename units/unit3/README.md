# Модуль Paint

## Задание
Создадим консольный вариант Paint
1) Создать класс `Point` с полями `x` и `y`.
2) Создать абстрактный класс `Figure` c полем `Point` и методами `area()` и `perimeter()`.
3) Создать классы наследники от `Figure` – Круг, Прямоугольник, Квадрат (частный случай прямоугольника),
   Треугольник.
4) Создать enum `Color` с перечислением не менее 5 цветов.
5) Создать интерфейс `Drawable`, в котором два метода `draw` и `draw(Color color)` и применить его ко всем
   фигурам.
6) Создать класс `FigureUtil`. Класс должен быть с приватным конструктором и статическими методами
   * `area(Figure figure)`– считает площадь заданной фигуры
   * `perimeter(Figure figure)` – считает периметр заданной фигуры
   * `draw(Figure figure)` – Выводит на экран фигуру с черным цветом и координатами точек.
   * `draw(Figure figure, Color color)` - Выводит на экран фигуру с заданным цветом и координатами
   точек.
7) Создать класс `PaintExample` с методом main для демонстрации работы рисования фигур.
> Рисовать не надо, просто вывести строку на экран – Нарисована такая-то фигура с координатами такими-то


## Результат

```java
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
```

```bash
Площадь круга: 78.53981633974483
Длина окружности: 31.41592653589793
Площадь прямоугольника: 50.0
Периметр прямоугольника: 30.0
Площадь квадрата: 16.0
Периметр квадрата: 16.0
Площадь треугольника: 6.0
Периметр треугольника: 12.0
Нарисован квадрат со стороной 4 и центром в точке (0.0, 0.0) с цветом BLUE
Нарисован треугольник с вершинами в точках(0.0, 0.0), (4.0, 0.0), (0.0, 3.0) и цветом GREEN
Process finished with exit code 0
```