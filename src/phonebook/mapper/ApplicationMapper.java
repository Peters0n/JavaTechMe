package phonebook.mapper;

import phonebook.entity.Application;

import java.util.List;

public class ApplicationMapper {
    private static final Integer FIRSTNAME_INDEX = 1;
    private static final Integer LASTNAME_INDEX = 2;
    private static final Integer AGE_INDEX = 3;
    private static final Integer ADDRESS_INDEX = 4;

    public Application toEntity(List<String> args) {
        var application = new Application();
        application.setFirstname(args.get(FIRSTNAME_INDEX));
        application.setLastname(args.get(LASTNAME_INDEX));
        application.setAge(Integer.parseInt(args.get(AGE_INDEX)));
        application.setAddress(args.get(ADDRESS_INDEX));
        application.setStatus(Application.STATUS_NEW);
        return application;
    }
}
