package lesson5.phonebook.storage;

import com.fasterxml.jackson.databind.ObjectMapper;
import lesson5.phonebook.entity.Entity;
import lesson5.phonebook.entity.Person;
import lesson5.phonebook.marshaller.Marshaller;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface Storage<E> {

   /* Class<E> getEntityClass();

    void setEntityClass(Class<E> clazz);*/

    void setMarshaller(Marshaller marshaller);

    String getFilePath();

    void save(Object person);

    default List<E> findAll() {
        /*var entities = new LinkedList<>();
        ObjectMapper mapper = new ObjectMapper();

        if (new File("pnonebook.json").exists()) {
            try {
                entities = mapper.readValue(new File("pnonebook.json"), E.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
        public static void toJSON(List<Person> persons) throws IOException {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(new File(file), persons);
            System.out.println("pnonebook.json created");
        }

        public static List<Person> toJavaObject() throws IOException{
            ObjectMapper mapper = new ObjectMapper();
            return (List<Person>) mapper.readValue(new File(file), Person.class);
        }*/


        var entities = new LinkedList<E>();
        try (var ois = new ObjectInputStream(new FileInputStream("./phonebook.txt"))) {
           E p;
              while ((p = (E) ois.readObject()) != null)
              {entities.add(p);
            }
        } catch (EOFException ignored) {
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

//        try (var scanner = new Scanner(new FileInputStream(this.getFilePath())).useDelimiter("\\Z")) {
//            var content = scanner.next();
//            var lines = content.split("\n");
//            for (int i = 0; i < lines.length; i++) {
//                var row = lines[i];
//                var columns = row.split("/");
//                try {
//                    var o = getEntityClass().newInstance();
//                    ((Entity)o).setData(columns);
//                    entities.add(o);
//                } catch (InstantiationException | IllegalAccessException e) {
//                    e.printStackTrace();
//                }
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }

       return entities;
    }
}
