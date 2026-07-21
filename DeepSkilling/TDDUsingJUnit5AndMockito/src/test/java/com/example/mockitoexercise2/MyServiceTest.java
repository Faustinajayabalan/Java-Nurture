package com.example.mockitoexercise2;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;

public class MyServiceTest {

    @Test
    void testVerifyInteraction() {

        // Create the mock object
        ExternalApi mockApi = mock(ExternalApi.class);

        // Pass the mock object to the service
        MyService service = new MyService(mockApi);

        // Call the service method
        service.fetchData();

        // Verify that getData() was called once
        verify(mockApi).getData();
    }
}