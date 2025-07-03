# 2. Реализация библиотеки сериализации Java-объектов в JSON

> Разработать библиотеку, которая преобразует Java-объекты в JSON-строку на основе
> аннотаций. Библиотека должна быть оформлена как отдельный Maven-модуль и
> продемонстрирована в тестовом проекте.

1. **Библиотека (`Maven` - модуль `json-serializer`)**
    - Должна предоставлять класс JsonSerializer с методом:
   ```java
   String serialize(Object object) throws JsonSerializationException;
   ```

    - Сериализация должна учитывать только поля, помеченные
      аннотацией `@JsonField`.
    - Поддерживаемые типы полей:
        - Примитивы и их обёртки ( int , Integer , String , boolean и т. д.)
        - Коллекции (List, Set, Map)
        - Вложенные объекты (также с аннотацией @JsonField)
    - Если поле не сериализуемо (не аннотировано или null), оно не попадает в JSON.
    - Ошибки (несериализуемые типы, рекурсивные ссылки) должны
      выбрасывать JsonSerializationException.


2. **Аннотация `@JsonField`**
   ```java
      @Retention(RetentionPolicy.RUNTIME)
      @Target(ElementType.FIELD)
      public @interface JsonField {
         // Опционально: кастомное имя поля в JSON (по умолчанию — имя поля класса)
         String name() default "";
      }
   ```
3. **Тестовый проект (Maven-модуль json-serializer-demo ).**
   - Подключает json-serializer как зависимость.

   - Содержит примеры классов:
      ```java
      public class Person {
       @JsonField
       private String name;
   
       @JsonField(name = "age_years")
       private int age;
   
       @JsonField
       private List<String> hobbies;
   
       // Не сериализуется (нет аннотации)
       private String password;
      }
      ```
   - Демонстрирует работу:

     ```java
     Person person = new Person("Alice", 30, List.of("Reading", "Hiking"));
     JsonSerializer serializer = new JsonSerializer();
     String json = serializer.serialize(person);
     System.out.println(json);
     // Вывод: {"name":"Alice", "age_years":30, "hobbies":["Reading", "Hiking"]}
     ```
     
## Результат
```java
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
```

```json
{"name": "Alice", "age_years": 30, "hobbies": ["Reading", "Hiking"], "address": {"street": "Main St", "houseNumber": 123}, "skills": {"Python": 5, "Java": 5}}
```
