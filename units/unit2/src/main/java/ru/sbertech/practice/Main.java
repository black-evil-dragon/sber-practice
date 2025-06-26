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