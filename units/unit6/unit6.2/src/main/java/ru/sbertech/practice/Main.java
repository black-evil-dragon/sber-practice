package ru.sbertech.practice;

import java.util.List;

class Person {
    @JsonField
    private String name;

    @JsonField(name = "age_years")
    private int age;

    @JsonField
    private List<String> hobbies;

    // Не сериализуется (нет аннотации)
    private String password;

    public Person(String name, int age, List<String> hobbies) {
        this.name = name;
        this.age = age;
        this.hobbies = hobbies;
    }

}

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Alice", 30, List.of("Reading", "Hiking"));
        JsonSerializer serializer = new JsonSerializer();
        String json = serializer.serialize(person);
        System.out.println(json);

    }
}