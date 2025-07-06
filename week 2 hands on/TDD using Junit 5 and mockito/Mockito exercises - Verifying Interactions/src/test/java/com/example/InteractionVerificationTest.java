package com.example;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class InteractionVerificationTest {

    @Test
    void testVerifyInteraction() {
        // Mock
        UserRepository mockRepo = mock(UserRepository.class);

        // Stub
        when(mockRepo.findNameById(1)).thenReturn("Anu");

        // Use in real class
        UserService service = new UserService(mockRepo);
        String result = service.getUserName(1);

        // Assert
        assertEquals("Anu", result);

        // ✅ VERIFY interaction
        verify(mockRepo).findNameById(1); // called once with 1
        verify(mockRepo, times(1)).findNameById(1); // explicitly once
        verify(mockRepo, never()).findNameById(2);  // never called with 2
    }
}