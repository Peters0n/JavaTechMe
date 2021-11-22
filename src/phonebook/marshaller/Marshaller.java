package phonebook.marshaller;

import java.io.IOException;
import java.io.OutputStream;

public interface Marshaller {
    void setStream(OutputStream fin);

    void process(Object entity) throws IOException;
}
