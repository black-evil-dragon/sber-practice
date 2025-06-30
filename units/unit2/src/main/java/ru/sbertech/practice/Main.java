package ru.sbertech.practice;


import java.util.Arrays;

// Task 1 - Phone
class Phone {
    private String number;
    private String model;
    private String weight;

    public Phone(String number, String model, String weight) {
        this.number = number;
        this.model = model;
        this.weight = weight;
    }
    public Phone(String number, String model) {
        this.number = number;
        this.model = model;
    }
    public Phone() {}


    public void receiveCall(String callerName) {
        System.out.println("Звонит " + callerName);
    }


    public void receiveCall(String callerName, String callerNumber) {
        System.out.println("Звонит " + callerName + ", номер: " + callerNumber);
    }


    public String getNumber() {
        return number;
    }


    public void sendMessage(String... phoneNumbers) {
        System.out.println("Отправка сообщения на номера: " + Arrays.toString(phoneNumbers));
    }

    @Override
    public String toString() {
        return "Phone(" + number + ", " + model + ", " + weight + ')';
    }
}


// Task 2 - Circle
class Circle {
    private double radius;
    private double perimeter;
    private double area;

    private String color;


    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
        this.perimeter = perimeter();
        this.area = area();

    }

    public double area() {
        return Math.PI * radius * radius;
    }

    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "Circle(" + radius + ", " + color + ", area:" + this.area + ", length:" + this.perimeter + ')';
    }
}


// Task 3 - Matrix
class Matrix {
    /*
    Создайте класс Matrix. Класс должен иметь следующие переменные:
    1 двумерный массив вещественных чисел;
    2 количество строк и столбцов в матрице.

    Класс должен иметь следующие методы:
    1 Setter значения элемента в массив - setValue(int i, int j, int value)
    2 сложение с другой матрицей;
    3 умножение на число;
    4 вывод на печать;
    5 умножение матриц.

    Создать класс с методом main, в котором продемонстрировать работу класса.
     */

    private double[][] matrix;
    private int row_size;
    private int col_size;

    public Matrix(int row_size, int col_size) throws Exception {
        if (row_size > 0 && col_size > 0) {
            this.row_size = row_size;
            this.col_size = col_size;
            this.matrix = new double[row_size][col_size];
        } else {
            throw new Exception("Неверный размер матрицы");
        }
    }

    public void setValue(int row_index, int column_index, double value) {
        this.matrix[row_index][column_index] = value;
    }



}



public class Main {
    public static void main(String[] args) {
        Phone phone = new Phone("+79114493901", "samsung", "150");

        System.out.println("Телефон: " + phone);

        phone.receiveCall("Иван Иванов");
        phone.receiveCall("МОШЕННИК", "+74901551515");

        System.out.println("Номер телефона: " + phone.getNumber());

        phone.sendMessage("+79114493901");


        Circle circle1 = new Circle(5.0, "Красный");
        Circle circle2 = new Circle(3.5, "Синий");

        System.out.println(circle1);
        System.out.println(circle2);
    }
}