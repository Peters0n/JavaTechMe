package phonebook.controller;

import phonebook.dao.PhonebookDAO;
import phonebook.mapper.PersonMapper;

import java.sql.Connection;
import java.util.List;

public class PhonebookController implements IController {
    private Connection connection;

    @Override
    public void setDatabaseConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void process(List<String> arguments) {
        var dao = new PhonebookDAO(connection);
        switch (arguments.get(0).replace("phonebook/", "")) {
            case "generate" -> {
                var mapper = new PersonMapper();
                for (int i = 0; i < 15; i++) {
                    dao.save(mapper.toEntity(arguments));
                }
            }
            case "save" -> {
                var mapper = new PersonMapper();
                dao.save(mapper.toEntity(arguments));
            }
            case "call" -> {
                var person = dao.findByLastname(arguments.get(1));
                //person.getPhoneNumber();
            }
            case "delete" -> {
                dao.delete(Integer.parseInt(arguments.get(1)));
            }
            case "list" -> {
                dao.findAll().forEach(System.out::println);
            }
            case "find" -> {
                var person = dao.find(Integer.parseInt(arguments.get(1)));
                if (person != null) {
                    System.out.println(person);
                } else {
                    System.err.println("Person not found");
                }
            }
        }
    }
}
