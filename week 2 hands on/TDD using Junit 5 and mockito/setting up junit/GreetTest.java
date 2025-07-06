import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreetTest {
    @Test
    void testGreeting() {
        Greet gre = new Greet();
        assertEquals("Hello", gre.says());
    }
}

