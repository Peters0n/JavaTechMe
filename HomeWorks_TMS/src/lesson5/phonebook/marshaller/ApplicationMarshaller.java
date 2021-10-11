package lesson5.phonebook.marshaller;

import lesson5.phonebook.entity.Application;
import lesson5.phonebook.entity.Person;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class ApplicationMarshaller implements Marshaller {
    private OutputStream fout;

    @Override
    public void setStream(FileOutputStream fin) {
        this.fout = fin;
    }

    @Override
    public void process(Object entity) throws IOException {
        var application = (Application) entity;
        var oos = new ObjectOutputStream(fout);
        oos.writeObject(application);
        oos.flush();
//        fin.write(application.getId().toString().getBytes(StandardCharsets.UTF_8));
//        fin.write("/".getBytes(StandardCharsets.UTF_8));
//        fin.write(application.getFirstname().getBytes(StandardCharsets.UTF_8));
//        fin.write("/".getBytes(StandardCharsets.UTF_8));
//        fin.write(application.getLastname().getBytes(StandardCharsets.UTF_8));
//        fin.write("/".getBytes(StandardCharsets.UTF_8));
//        fin.write(application.getAge().toString().getBytes(StandardCharsets.UTF_8));
//        fin.write("/".getBytes(StandardCharsets.UTF_8));
//        fin.write(application.getAddress().getBytes(StandardCharsets.UTF_8));
//        fin.write("/".getBytes(StandardCharsets.UTF_8));
//        fin.write(application.getStatus().toString().getBytes(StandardCharsets.UTF_8));
//        fin.write("\n".getBytes(StandardCharsets.UTF_8));
    }

    @Override
    public void appendProcess(Object entity) throws IOException {
        var person = (Application) entity;
        var ois = new AppendObjectOutputStream(fout);
        ois.writeObject(person);
        ois.flush();
    }
}
