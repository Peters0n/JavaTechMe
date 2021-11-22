package phonebook.dao;

import phonebook.entity.Person;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PhonebookDAO {
    private final Connection connection;

    public PhonebookDAO(Connection connection) {
        this.connection = connection;
    }

    public Person findByLastname(String lastname) {
        try {
            var stmt = connection.prepareStatement("SELECT * FROM Phonebook WHERE lastname LIKE CONCAT('%', ?, '%')");
            stmt.setString(1, lastname);

            var rs = stmt.executeQuery();
            while (rs.next()) {
                var person = new Person(rs.getInt("id"));
                person.setLastname(rs.getString("lastname"));
                person.setFirstname(rs.getString("firstname"));
                person.setAge(rs.getInt("age"));
                person.setAddress(rs.getString("address"));
                person.setPhoneNumber(rs.getString("phone_number"));
                return person;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    public List<Person> findAll() {
        try {
            var stmt = connection.prepareStatement("SELECT * FROM Phonebook");

            var people = new ArrayList<Person>();
            var rs = stmt.executeQuery();
            while (rs.next()) {
                var person = new Person(rs.getInt("id"));
                person.setLastname(rs.getString("lastname"));
                person.setFirstname(rs.getString("firstname"));
                person.setAge(rs.getInt("age"));
                person.setAddress(rs.getString("address"));
                person.setPhoneNumber(rs.getString("phonenumber"));
                people.add(person);
            }
            return people;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return Collections.emptyList();
    }

    public Person find(Integer id) {
        try {
            var stmt = connection.prepareStatement("SELECT * FROM Phonebook WHERE id = ?");
            stmt.setInt(1, id);

            var rs = stmt.executeQuery();
            while (rs.next()) {
                var person = new Person(rs.getInt("id"));
                person.setFirstname(rs.getString("firstname"));
                person.setLastname(rs.getString("lastname"));
                person.setAge(rs.getInt("age"));
                person.setPhoneNumber(rs.getString("phone_number"));
                person.setAddress(rs.getString("address"));
                return person;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    public void delete(int id) {
        try {
            var stmt = connection.prepareStatement("DELETE FROM Phonebook WHERE Id = ?");
            stmt.setInt(1, id);
            stmt.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void save(Person person) {
        try {
            if (person.getId() != null) {
                var stmt = this.connection.prepareStatement(
                        "UPDATE Phonebook SET  firstname = ?, lastname = ?, age = ?, address = ?, phonenumber = ? WHERE id = ?"
                );


                stmt.setString(1, person.getFirstname());
                stmt.setString(2, person.getLastname());
                stmt.setInt(3, person.getAge());
                stmt.setString(4, person.getPhoneNumber());
                stmt.setString(5, person.getAddress());
                stmt.setInt(6, person.getId());

                stmt.execute();
            } else {
                var stmt = this.connection.prepareStatement(
                        "INSERT INTO Phonebook ( firstname, lastname, age, phonenumber, address) VALUES (?, ?, ?, ?, ?)"
                );

                stmt.setString(1, person.getFirstname());
                stmt.setString(2, person.getLastname());
                stmt.setInt(3, person.getAge());
                stmt.setString(4, person.getPhoneNumber());
                stmt.setString(5, person.getAddress());
                stmt.execute();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
