package ru.sbertech.practice;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;



/// # JsonSerializer
///
/// ## Описание
/// Решает задачу сериализации объектов в JSON-строку
///
/// ## Методы
/// - `serialize(Object object)` - сериализует `Object` в JSON-строку
/// ...
public class JsonSerializer {

    /// ## Сериализация объекта в JSON-строку
    /// ### Что делает:
    /// - В зависимости от типа объекта:
    /// - `String` - сериализует как `String`
    /// - `Integer`, `Long`, `Double`, `Float`, `Boolean`, `Character`, `Byte`, `Short` - сериализует как `Number`
    /// - `Collection` - сериализует как массив
    /// - `Map` - сериализует как объект
    ///
    /// @param object исходный объект
    /// @return `String` - JSON-строка
    public String serialize(Object object) throws JsonSerializationException{
        try {
            return serializeByObjectApplicability(object);
        } catch (Exception e) {
            throw new JsonSerializationException(e.getMessage());
        }
    }



    /// ## Обработка объектов по их типу
    ///
    /// @param object исходный объект
    /// @return `String` - JSON-строка
    private String serializeByObjectApplicability(Object object) throws IllegalAccessException {
        if (object == null) {return "null";}

        if (object instanceof String
                || object instanceof Integer
                || object instanceof Long
                || object instanceof Double
                || object instanceof Float
                || object instanceof Boolean
                || object instanceof Character
                || object instanceof Byte
                || object instanceof Short
        ) {
            return serializePrimitive(object);

        } else if (Collection.class.isAssignableFrom(object.getClass())) {
            return serializeCollection((Collection<?>) object);

        } else if (Map.class.isAssignableFrom(object.getClass())) {
            return serializeMap((Map<?, ?>) object);

        } else {
            return serializeClass(object);
        }
    }



    /// ## Преобразование класса в String JSON-формата
    ///
    /// @param object исходный объект
    /// @return `String` - JSON-строка
    private String serializeClass(Object object) throws IllegalAccessException {
        Class<?> clazz = object.getClass();
        StringBuilder serializedObject = new StringBuilder("{");
        Field[] fields = clazz.getDeclaredFields();
        boolean firstField = true;


        for (Field field : fields) {
            if (field.isAnnotationPresent(JsonField.class)) {
                field.setAccessible(true);
                Object ob = field.get(object);

                if (ob != null) {
                    if (!firstField) {
                        serializedObject.append(", ");
                    }
                    JsonField an = field.getAnnotation(JsonField.class);
                    String fieldName;
                    if (an.name().isEmpty()) {
                        fieldName = field.getName();
                    } else {
                        fieldName = an.name();
                    }
                    serializedObject.append("\"").append(fieldName).append("\": ").append(serializeByObjectApplicability(ob));

                    firstField = false;
                }
            }
        }
        serializedObject.append("}");
        return serializedObject.toString();
    }



    /// ## Преобразование примитивов в String JSON-формата
    ///
    /// @param object исходный объект
    /// @return `String` - строка
    private String serializePrimitive(Object object) {
        if (object instanceof String || object instanceof Character) {
            return "\"" + object + "\"";
        }
        return object.toString();
    }



    /// ## Преобразование коллекции в String JSON-формата
    ///
    /// @param collection исходная коллекция
    /// @return `String` - JSON-строка (в формате массива)
    private String serializeCollection(Collection<?> collection) throws IllegalAccessException {
        StringBuilder serialized = new StringBuilder("[");

        boolean firstElement = true;

        for (Object element : collection) {
            if (!firstElement) {
                serialized.append(", ");
            }


            serialized.append(serializeByObjectApplicability(element));
            firstElement = false;
        }
        serialized.append("]");
        return serialized.toString();
    }


    /// ## Преобразование Map в String JSON-формата
    ///
    /// @param map исходный Map
    /// @return `String` - JSON-строка (в формате объекта)
    private String serializeMap(Map<?, ?> map) throws IllegalAccessException {
        StringBuilder serialized = new StringBuilder("{");
        boolean firstEntry = true;


        for (Map.Entry<?, ?> entry : map.entrySet()) {
            if (!firstEntry) {
                serialized.append(", ");
            }
            String key = entry.getKey().toString();
            serialized.append("\"").append(key).append("\": ");
            serialized.append(serializeByObjectApplicability(entry.getValue()));
            firstEntry = false;
        }

        serialized.append("}");

        return serialized.toString();
    }
}
