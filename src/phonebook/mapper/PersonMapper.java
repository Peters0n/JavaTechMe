package phonebook.mapper;

import phonebook.entity.Person;

import java.util.List;

public class PersonMapper {
    private static final Integer FIRSTNAME_INDEX = 1;
    private static final Integer LASTNAME_INDEX = 2;
    private static final Integer AGE_INDEX = 3;
    private static final Integer PHONE_NUMBER_INDEX = 4;
    private static final Integer ADDRESS_INDEX = 5;

    public Person toEntity(List<String> args) {
        var person = new Person();
        person.setFirstname(args.get(FIRSTNAME_INDEX));
        person.setLastname(args.get(LASTNAME_INDEX));
        person.setAge(Integer.parseInt(args.get(AGE_INDEX)));
        person.setPhoneNumber(args.get(PHONE_NUMBER_INDEX));
        person.setAddress(args.get(ADDRESS_INDEX));
        return person;
    }
}
