package info.dmerej;

import org.junit.jupiter.api.Test;

public class MailSenderTest {
    @Test
    void should_make_a_valid_http_request() {
        // TODO: write a test to demonstrate the bug in MailSender.sendV1()

        StubHttpClient httpClient = new StubHttpClient();
        MailSender MailSenderTest = new MailSender(httpClient);
        User user = new User("user@example.com");

        // Act
        mailSender.sendV1(user, "stringTest");

        // Assert
        assertEquals(1, httpClient.requests.size(), "Expected one HTTP request to be sent");
        SendMailRequest request = httpClient.requests.get(0);

        // Check sendV1
        assertEquals("New notification", request.subject(), "Subject should be 'New notification'");
        assertEquals("user@example.com", request.recipient(), "Recipient email should be correct");
        assertEquals("stringTest", request.body(), "Message body should match");
    }

    @Test
    void should_retry_when_getting_a_503_error() {
        // TODO: write a test to demonstrate the bug in MailSender.sendV2()

        // Arrange
        StubHttpClient httpClient = new StubHttpClient();
        httpClient.simulate503 = true; // Simulate a 503 response
        MailSender mailSender = new MailSender(httpClient);
        User user = new User("user@example.com");

        // Act
        mailSender.sendV2(user, "test");

        // Assert
        assertEquals(2, httpClient.requests.size(), "Expected two HTTP requests due to retry");
        SendMailRequest request = httpClient.requests.get(0);

        // Check sendV2
        assertEquals("user@example.com", request.recipient(), "Recipient email should be correct");
        assertEquals("test", request.body(), "Message body should match");
        assertTrue(httpClient.wasRetried, "Request should have been retried");
    }
}
