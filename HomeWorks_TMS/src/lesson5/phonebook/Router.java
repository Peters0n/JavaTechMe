package lesson5.phonebook;

import lesson5.phonebook.controller.ApplicationController;
import lesson5.phonebook.controller.IController;
import lesson5.phonebook.controller.PhonebookController;

import java.util.Arrays;

public class Router {
    private String[] arguments;

    public Router(String[] arguments) {
        this.arguments = arguments;
    }

    public void dispatch() {
        IController controller;
        var action = this.arguments[0];
        if (action.startsWith("application/")) {
            controller = new ApplicationController();
        } else if (action.startsWith("phonebook/")) {
            controller = new PhonebookController();
        } else {
            throw new IllegalArgumentException("Wrong action: " + action);
        }
        controller.process(Arrays.asList(this.arguments));
    }
}
