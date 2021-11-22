package phonebook;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import phonebook.dao.PhonebookDAO;
import phonebook.entity.Person;
import phonebook.storage.FileStorage;

import java.util.Random;

import static java.util.Collections.singletonList;

public class PhonebookDAOTests {
    private PhonebookDAO dao;

    @Before
    public void setUp() {
        var storage = new FileStorage<Person>("./phonebook.txt");
        //this.dao = new PhonebookDAO(singletonList(storage));
    }

    @Test
    public void testFindByLastname() {
        var person = this.dao.findByLastname("Pupkin");
        assertNotNull(person);
        assertEquals("Vasia", person.getFirstname());
    }

    @Test
    public void testLastnameNotFound() {
        var person = this.dao.findByLastname(String.valueOf(new Random().nextInt()));
        assertNull(person);
    }
}
