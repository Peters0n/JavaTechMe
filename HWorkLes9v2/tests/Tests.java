import org.junit.Test;
import static org.junit.Assert.*;

public class Tests {
    @Test
    public void testCountWords() {
        var result = TextFormatter.countWords("qwerwr werwer werwe er er we fe");
        assertEquals(result, 7);
    }
    @Test
    public void testPalyndromTrue(){
        var result2 = TextFormatter.palyndrom("qwerwr werew werwe er er we fe");
        assertTrue(result2);
    }
    @Test
    public void testPalyndromFalse(){
        var result3 = TextFormatter.palyndrom("qwerwr werewwe werwe er er we fe");
        assertFalse(result3);
    }
}
