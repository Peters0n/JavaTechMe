package lesson5.phonebook.marshaller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public interface Marshaller {
    void setStream(FileOutputStream fin);

    void process(Object entity) throws IOException;

    void appendProcess(Object entity) throws IOException;
}
