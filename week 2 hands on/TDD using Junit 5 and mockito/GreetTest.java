import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class GreetTest {

    Greet greeter;

    @BeforeAll
    static void initAll() {
        System.out.println(">> Starting all tests");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println(">> Finished all tests");
    }

    @BeforeEach
    void init() {
        greeter = new Greet(); // Arrange (test fixture)
        System.out.println("-- Test setup");
    }

    @AfterEach
    void cleanup() {
        System.out.println("-- Test cleanup");
    }

    @Test
    void testSays() {
           String result = greeter.says();
          // Assert
        assertEquals("Hello", result);
    }

    @Test
    void testShout() {
        String result = greeter.shout("Anu");

        // Assert
        assertEquals("HELLO ANU", result);
        assertNotNull(result);
        assertTrue(result.startsWith("HELLO"));
    }
}
