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



public class Main {
    public static void main(String[] args) {
        Phone phone = new Phone("+79114493901", "samsung", "150");

        System.out.println("Телефон: " + phone);
        
        phone.receiveCall("Иван Иванов");
        phone.receiveCall("МОШЕННИК", "+74901551515");

        System.out.println("Номер телефона: " + phone.getNumber());

        phone.sendMessage("+79114493901");
    }
}