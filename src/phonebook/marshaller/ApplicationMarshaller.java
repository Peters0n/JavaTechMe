package phonebook.marshaller;

import phonebook.entity.Application;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class ApplicationMarshaller implements Marshaller {
    private OutputStream fin;

    @Override
    public void setStream(OutputStream fin) {
        this.fin = fin;
    }

    @Override
    public void process(Object entity) throws IOException {
        var application = (Application) entity;

        fin.write(application.getFirstname().getBytes(StandardCharsets.UTF_8));
        fin.write("/".getBytes(StandardCharsets.UTF_8));
        fin.write(application.getLastname().getBytes(StandardCharsets.UTF_8));
        fin.write("/".getBytes(StandardCharsets.UTF_8));
        fin.write(application.getAge().toString().getBytes(StandardCharsets.UTF_8));
        fin.write("/".getBytes(StandardCharsets.UTF_8));
        fin.write(application.getAddress().getBytes(StandardCharsets.UTF_8));
        fin.write("/".getBytes(StandardCharsets.UTF_8));
        fin.write(application.getStatus().toString().getBytes(StandardCharsets.UTF_8));
        fin.write("\n".getBytes(StandardCharsets.UTF_8));
    }
}
