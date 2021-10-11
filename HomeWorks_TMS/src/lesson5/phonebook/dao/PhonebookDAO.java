package lesson5.phonebook.dao;

import lesson5.phonebook.entity.Person;
import lesson5.phonebook.storage.Converter;
import lesson5.phonebook.storage.Storage;

import java.io.*;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.function.Predicate.not;

public class PhonebookDAO {
    private final List<Storage<Person>> storages;

    public PhonebookDAO(List<Storage<Person>> storages) {
        this.storages = storages;
    }

    public List<Person> findBy(Predicate<Person> predicate) {
        List<Person> personList = new LinkedList<>();
        try {
            personList = Converter.toJavaObject();
        } catch (IOException e) {
            e.printStackTrace();
        }


        List<Person> result = new ArrayList<>();


        //var personList = this.findAll();
        personList.forEach(person -> {
            if (predicate.test(person)) {
                result.add(person);
            }
        });
        return result;
    }

// надо иисправить под JSON
    private void saveAll(Person[] people) {
        this.deleteFile();
        //List<Person> persons = new LinkedList<>();
        List<Person> persons = Arrays.stream(people).collect(Collectors.toList());
        this.save(persons);
       /* for (int i = 0, peopleLength = people.length; i < peopleLength; i++) {
            Person person = people[i];
            if (person != null) {
                this.save(person);
            }
        }*/
    }

    private void deleteFile() {
        new File("./phonebook.txt").delete();//не доделан
    }

    public Person findByLastname(String lastname) {// не работает как должен
        //var persons = this.findAll();
        List<Person> personJava = new LinkedList<>();
        if (new File("pnonebook.json").exists()) {
            try {
                personJava = Converter.toJavaObject();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        var personP = personJava.stream()
                .filter(person -> person.getLastname().contains(lastname))
                .findFirst();
        return personP.orElse(null);
    }
        /*var personP = persons.stream()
                .filter(person -> person.getLastname().equals(lastname))
                .findFirst();
        return personP.orElse(null);
       }*/

    public Person find(Integer id) {
        List<Person> personJava = new LinkedList<>();
        if (new File("pnonebook.json").exists()) {
            try {
                personJava = Converter.toJavaObject();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        var personP = personJava.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst();
        return personP.orElse(null);
       /* var storage = this.storages.get(0);
        var people = storage.findAll();
        for (Person person : people) {
            if (person.getId().equals(id)) {
                return person;
            }
        }
        return null;*/
    }

    public void delete(int id) {
        List <Person> personJava = new LinkedList<>();
        try {
            if (new File("pnonebook.json").exists()) {
                personJava = Converter.toJavaObject();
            }
            var personP = personJava.stream()
                    .filter(not(person -> person.getId().equals(id)))
                    .collect(Collectors.toList());
            /*personJava.stream()*/

            Converter.toJSON(personP);
        } catch (IOException e) {
            e.printStackTrace();
        }

       /* Person[] people = this.storages.get(0).findAll().toArray(new Person[0]);
        for (int i = 0; i < people.length; i++) {
            if (people[i].getId().equals(id)) {
                people[i] = null;
            }
        }
        this.saveAll(people);*/
    }

    public void save(List<Person> persons) {
        try {
            if (new File("pnonebook.json").exists()) {
                var personJava = Converter.toJavaObject();
                persons.addAll(personJava);
            }
            Converter.toJSON(persons);
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*for (Storage<Person> storage : this.storages) {
            storage.save(person);
        }*/
    }

    public void saveIndex() {

        var personList = this.findAll();
        var map = new HashMap<Integer, String>();
        for (Person person : personList) {
            map.put(person.getId(), person.getLastname());
        }
        ObjectOutputStream ous = null;
        try {
            ous = new ObjectOutputStream(new FileOutputStream("./Index.txt", true));
            ous.writeObject(map);
            ous.flush();
            ous.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }

    }

    public List<Person> findAll() {
        return this.storages.get(0).findAll();

    }

    public String findByIndex(int id) {
        HashMap<Integer, String> personMap;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("./Index.txt"));){
            personMap = (HashMap<Integer, String>) ois.readObject();
        } catch (IOException | ClassNotFoundException exception) {
            exception.printStackTrace();
            return null;
        }
        return personMap.get(id);
    }
    public void chekNullPersonsList(List<Person> persons){
        if (persons.size() != 0) {
            persons.forEach(System.out::println);
        } else {
            System.err.println("Person not found");
        }
    }
}
