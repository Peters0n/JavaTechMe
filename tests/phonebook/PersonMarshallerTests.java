package phonebook;

import org.junit.Test;
import phonebook.entity.Person;
import phonebook.marshaller.PersonMarshaller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PersonMarshallerTests {
    @Test
    public void testIsNotEmpty() throws IOException {
        var bytes = new ByteArrayOutputStream();
        var marshaller = new PersonMarshaller();
        assertEquals(0, bytes.size());

        var firstname = "Vasia";

        marshaller.setStream(bytes);
        marshaller.process(new Person("1", new String[]{"1", firstname, "Pupkin", "20", "Address", "375111111"}));
        assertTrue(bytes.size() > 0);
        assertTrue(bytes.toString().contains(firstname));
    }
}
