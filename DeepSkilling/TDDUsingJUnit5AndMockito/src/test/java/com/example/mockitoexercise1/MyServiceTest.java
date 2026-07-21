package com.example.mockitoexercise1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

public class MyServiceTest {

    @Test
    void testMockingAndStubbing() {

        // Create mock object
        ExternalApi mockApi = mock(ExternalApi.class);

        // Stub the method
        when(mockApi.getData()).thenReturn("Mock Data");

        // Use the mock in the service
        MyService service = new MyService(mockApi);

        // Call the method
        String result = service.fetchData();

        // Check the result
        assertEquals("Mock Data", result);
    }
}