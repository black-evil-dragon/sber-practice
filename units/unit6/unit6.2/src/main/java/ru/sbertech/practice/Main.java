package ru.sbertech.practice;

import java.util.List;
import java.util.Map;

class Person {
    @JsonField
    private String name;

    @JsonField(name = "age_years")
    private int age;

    @JsonField
    private List<String> hobbies;

    @JsonField
    private Address address;

    @JsonField
    private Map<String, Integer> skills;

    private String password;

    public Person(String name, int age, List<String> hobbies, Address address, Map<String, Integer> skills) {
        this.name = name;
        this.age = age;
        this.hobbies = hobbies;
        this.address = address;
        this.skills = skills;
    }
}

class Address {
    @JsonField
    private String street;

    @JsonField
    private int houseNumber;

    public Address(String street, int houseNumber) {
        this.street = street;
        this.houseNumber = houseNumber;
    }
}

public class Main {
    public static void main(String[] args) {
        Address address = new Address("Main St", 123);
        Person person = new Person(
                "Alice",
                30,
                List.of("Reading", "Hiking"),
                address,
                Map.of("Java", 5, "Python", 5)
        );


        JsonSerializer serializer = new JsonSerializer();
        try {
            String json = serializer.serialize(person);

            System.out.println(json);
        } catch (JsonSerializationException e) {
            e.printStackTrace();
        }
    }
}