package phonebook;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import phonebook.controller.ApplicationController;
import phonebook.controller.PhonebookController;

public class RouterTests {
    private Router router;

    @Before
    public void setUp() {
        this.router = new Router();
    }

    @Test
    public void testPhonebookController() {
        this.router.setArguments(new String[]{"phonebook/save"});
        var controller = this.router.getController();
        assertTrue(controller instanceof PhonebookController);
    }

    @Test
    public void testApplicationController() {
        this.router.setArguments(new String[]{"application/list"});
        var controller = this.router.getController();
        assertTrue(controller instanceof ApplicationController);
    }
}
