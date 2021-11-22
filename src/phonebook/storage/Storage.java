package phonebook.storage;

import phonebook.entity.Application;
import phonebook.entity.Entity;
import phonebook.marshaller.Marshaller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public interface Storage<E> {

    Class<E> getEntityClass();

    void setEntityClass(Class<E> clazz);

    void setMarshaller(Marshaller marshaller);

    String getFilePath();

    void save(Object save);

    default List<E> findAll() {
        var entities = new LinkedList<E>();

        try (var scanner = new Scanner(new FileInputStream(this.getFilePath())).useDelimiter("\\Z")) {
            var content = scanner.next();
            var lines = content.split("\n");
            for (int i = 0; i < lines.length; i++) {
                var row = lines[i];
                var columns = row.split("/");
                try {
                    var o = getEntityClass().newInstance();
                    ((Entity)o).setData(columns);
                    entities.add(o);
                } catch (InstantiationException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return entities;
    }
}
