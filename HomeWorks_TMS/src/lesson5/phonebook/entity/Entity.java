package lesson5.phonebook.entity;

import java.io.Serializable;

public interface Entity extends Serializable {
    void setData(String[] data);
}
