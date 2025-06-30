package ru.sbertech.practice;

import java.util.Scanner;

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
        System.out.println(a % 10 + (a / 10) % 10 + a / 100);

    }


    static void moonfulMass(int mass) {
        System.out.println(mass * 0.17);
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                sayHello();
                break;

            case 2:
                System.out.println("Введите два числа:");
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                divide(a, b);
                break;

            case 3:
                System.out.println("Введите строку для проверки:");
                scanner.nextLine();
                String str = scanner.nextLine();
                isPalindrom(str);
                break;

            case 4:
                System.out.println("Введите трехзначное число:");
                int num = scanner.nextInt();
                summator(num);
                break;

            case 5:
                System.out.println("Введите массу на Земле:");
                int mass = scanner.nextInt();
                moonfulMass(mass);
                break;

            default:
                System.out.println("Неверный выбор. Попробуйте снова.");
        }

        scanner.close();



    }
}