package ru.sbertech.practice;


import java.util.ArrayList;
import java.util.List;

class Foo {

}


public class Main {
    public static void main(String[] args) {

        //* ___________ 24.06.2025 Java ___________ * //
        // byte (1)
        // short (2)
        // int (4)
        // long (8)
        // float (4)
        // double (8)
        // char (2)
        // boolean (1)

        int id;
        int id2 = 100;


        Foo foo = new Foo();

        // if statement
        if (true) {

        } else {}


        // for statement
        for (int i = 0; i < 10; i++) {
        }

        int[] a = {1, 2, 3};



        // while statement
        // while(true) {}


        // do-while statement
        // do {} while (true);


        // switch case statement
        switch (id2) {
            case 1:
                System.out.println("1");
                break;

            default:
                break;
        }


        // import java.util.ArrayList;
        List<String> list = new ArrayList<>();
        for (String s : list) {
            if (s != null) {
                System.out.println(s);
            }
        }



    }
}