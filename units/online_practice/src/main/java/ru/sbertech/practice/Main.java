package ru.sbertech.practice;


class Test {
    private int id;

    public Test() {
        this.id = 10;
    }

    public void print() {
        System.out.println("Hello");
    }


    public int getId() {
        return id;
    }
}

public class Main {
    public static void main(String[] args) {
        Test test = new Test() {
            @Override
            public void print() {
                System.out.println("Hello world!");
            }
        };

        test.print();
    }
}