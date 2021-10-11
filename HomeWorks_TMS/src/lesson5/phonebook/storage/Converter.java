package lesson5.phonebook.storage;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lesson5.phonebook.entity.Person;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Converter {
    private final static String file = "pnonebook.json";

    public static void toJSON(List<Person> person) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(file), person);
        System.out.println("pnonebook.json created");
    }

    public static List<Person> toJavaObject() throws IOException{
        ObjectMapper mapper = new ObjectMapper();
        var p = mapper.readValue(new File(file), new TypeReference<List<Person>>() {
        });
        return p;
        //return Stream.of(p).collect(Collectors.toList());
        //return (List<Person>) mapper.readValue(new File(file), Person.class);
    }
}
