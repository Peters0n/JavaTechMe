package phonebook.marshaller;

import phonebook.entity.Person;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class PersonMarshaller implements Marshaller {
    private OutputStream fin;

    public void setStream(OutputStream fin) {
        this.fin = fin;
    }

    @Override
    public void process(Object entity) throws IOException {
        var person = (Person) entity;

        fin.write(person.getId().toString().getBytes(StandardCharsets.UTF_8));
        fin.write("/".getBytes(StandardCharsets.UTF_8));
        fin.write(person.getFirstname().getBytes(StandardCharsets.UTF_8));
        fin.write("/".getBytes(StandardCharsets.UTF_8));
        fin.write(person.getLastname().getBytes(StandardCharsets.UTF_8));
        fin.write("/".getBytes(StandardCharsets.UTF_8));
        fin.write(person.getAge().toString().getBytes(StandardCharsets.UTF_8));
        fin.write("/".getBytes(StandardCharsets.UTF_8));
        fin.write(person.getPhoneNumber().getBytes(StandardCharsets.UTF_8));
        fin.write("/".getBytes(StandardCharsets.UTF_8));
        fin.write(person.getAddress().getBytes(StandardCharsets.UTF_8));
        fin.write("\n".getBytes(StandardCharsets.UTF_8));
    }
}
