package phonebook.storage;

import phonebook.entity.Application;
import phonebook.entity.Entity;
import phonebook.marshaller.Marshaller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class FileStorage<E> implements Storage<E> {
    private String filePath;
    private Marshaller marshaller;
    private Class<E> entityClass;

    public FileStorage(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public Class<E> getEntityClass() {
        return this.entityClass;
    }

    @Override
    public void setEntityClass(Class<E> clazz) {
        this.entityClass = clazz;
    }

    @Override
    public void setMarshaller(Marshaller marshaller) {
        this.marshaller = marshaller;
    }

    @Override
    public String getFilePath() {
        return this.filePath;
    }

    @Override
    public void save(Object person) {
        try (var fin = new FileOutputStream(this.filePath, true)) {
            this.marshaller.setStream(fin);
            this.marshaller.process(person);
            fin.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
