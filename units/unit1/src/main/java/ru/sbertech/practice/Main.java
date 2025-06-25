package ru.sbertech.practice;

public class Main {
    static void sayHello() {
        System.out.println("Hello World!");
    }

    static void divide(int a, int b) {
        if (b == 0) {
            System.out.println("Деление на ноль");
        } else {
            int r = a / b;
            int c = a % b;
            System.out.println(a + " / " + b + " = " + r + " и " + c + " в остатке");
        }
    }

    static void isPalindrom(String string) {
        if (string.length() == 1) {
            System.out.println("Строка является палиндромом: " + string);
        }

        for (int i = 0; i < string.length() / 2; i++) {
            if (string.charAt(i) != string.charAt(string.length() - 1 - i)) {
                System.out.println("Строка не является палиндромом: " + string);
            }
        }

        System.out.println("Строка является палиндромом: " + string);
    }

    static void summator(int a) {
        // String string = "" + a; // well-well-well
//        String string = Integer.toString(a);
//
//        int sum = 0;
//        for (int i = 0; i < string.length(); i++) {
//
//        }

        // Трехзначное число
        System.out.println(a % 10 + (a / 10) % 10 + a / 100);

    }

    static void moonfulMass(int mass) {
        System.out.println(mass * 0.17);
    }

    public static void main(String[] args) {
        // Task 1
        sayHello();

        // Task 2
        divide(10, 3);

        // Task 3
        isPalindrom("abba");

        // Task 4
        summator(134);

        // Task 5
        moonfulMass(60);


    }



}