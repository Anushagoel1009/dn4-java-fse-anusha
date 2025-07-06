import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MockingTest {

    @Test
    void testMockingList() {
        List<String> mockList = mock(List.class); // Mocking

        when(mockList.get(0)).thenReturn("Anu");  // Stubbing
        when(mockList.size()).thenReturn(1);

        assertEquals("Anu", mockList.get(0));
        assertEquals(1, mockList.size());

        verify(mockList).get(0); // Verification
        verify(mockList).size();
    }

    @Test
    void testUserServiceWithMockedRepository() {
        UserRepository mockRepo = mock(UserRepository.class); // Mocking
        when(mockRepo.findNameById(1)).thenReturn("Anusha");   // Stubbing

        UserService service = new UserService(mockRepo); // Injecting mock

        assertEquals("Anusha", service.getUserName(1)); // Using stubbed response
        verify(mockRepo).findNameById(1); // Verifying interaction
    }
}
