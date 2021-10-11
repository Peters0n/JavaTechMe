package lesson5.phonebook.controller;


import lesson5.phonebook.dao.PhonebookDAO;
import lesson5.phonebook.entity.Person;
import lesson5.phonebook.mapper.PersonMapper;
import lesson5.phonebook.marshaller.PersonMarshaller;
import lesson5.phonebook.storage.Converter;
import lesson5.phonebook.storage.FileStorage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class PhonebookController implements IController {
    @Override
    public void process(List<String> arguments) {
        var storage = new FileStorage<Person>("./phonebook.txt");
        storage.setMarshaller(new PersonMarshaller());
        //storage.setEntityClass(Person.class);

        var dao = new PhonebookDAO(Collections.singletonList(storage));
        switch (arguments.get(0).replace("phonebook/", "")) {

            case "getIndex" -> {
                var currentTime = System.currentTimeMillis();
                System.out.println(dao.findByIndex(Integer.parseInt(arguments.get(1))));
                System.out.println(System.currentTimeMillis() - currentTime);

            }

            case "index" -> {
                dao.saveIndex();
            }
            //forJSON
            case "generate" -> {
                var mapper = new PersonMapper();
                List<Person> persons = new LinkedList<>();
                for (int i = 0; i < 2; i++) {
                    var person = mapper.toEntity2(arguments);
                    persons.add(person);
                    //dao.save(mapper.toEntity2(arguments));
                }
                dao.save(persons);

            }
            //forJSON
            case "save" -> {
                List<Person> persons = new LinkedList<>();
                var person = new PersonMapper().toEntity(arguments);
                persons.add(person);
                dao.save(persons);
            }
            //forJSON
            case "call" -> {//поиск по фамилии
                var person = dao.findByLastname(arguments.get(1));
                System.out.println(person);
                //person.getPhoneNumber();
            }
            //forJSON
            case "delete" -> {//по id
                dao.delete(Integer.parseInt(arguments.get(1)));
            }
            //forJSON
            case "find" -> {//по id
                var person = dao.find(Integer.parseInt(arguments.get(1)));
                if (person != null) {
                    System.out.println(person);
                } else {
                    System.err.println("Person not found");
                }
            }
            //forJSON
            case "list" -> {//вывод всех из phonebook.txt
                List<Person> list = new LinkedList<>();
                try {
                    list = Converter.toJavaObject();
                    list.forEach(System.out::println);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                /*List<Person> list = dao.findAll();
                for (Person person : list) {
                    System.out.println(person);
                }*/

            }
            //forJSON
            case "find_by_phone" -> {

                var person =dao.findBy(pers -> pers.getPhoneNumber().startsWith(arguments.get(1)));
                dao.chekNullPersonsList(person);
            }
            //forJSON
            case "find_by_age" -> {
                var person = dao.findBy(pers -> pers.getAge() >= (Integer.parseInt(arguments.get(1))));
                dao.chekNullPersonsList(person);
            }
        }
    }
}
