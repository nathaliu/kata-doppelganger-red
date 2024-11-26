package info.dmerej;

import info.dmerej.mailprovider.SendMailRequest;
import info.dmerej.mailprovider.SendMailResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MailSenderTest {
    private HttpClient httpClient;
    private MailSender mailSender;


    @BeforeEach
    void setUp() {
        httpClient = new HttpClient() {
            @Override
            public SendMailResponse post(String url, Object request) {
                if(!(request instanceof SendMailRequest)) {
                    throw new IllegalArgumentException("Expected a SendMailRequest");
                }
                if(!((SendMailRequest) request).recipient().contains("@")) {
                    throw new IllegalArgumentException("Invalid email address");
                }
                return new SendMailResponse(503, ((SendMailRequest) request).body());
            }
        };
        mailSender = new MailSender(httpClient);
    }

    @Test
    void should_make_a_valid_http_request() {
        // TODO: write a test to demonstrate the bug in MailSender.sendV1()
        
        // Arrange
        User user = new User("user", "user@example.com");
        SendMailRequest sendMailExpected =  new SendMailRequest("user@example.com","New notification", "stringTest");

        // Act



        // Assert
        Assertions.assertEquals(sendMailExpected, mailSender.sendV1(user, "stringTest"));




    }

    @Test
    void should_retry_when_getting_a_503_error() {
        // TODO: write a test to demonstrate the bug in MailSender.sendV2()

        // Arrange
        User user = new User("user", "user@example.com");
        SendMailRequest sendMailExpected =  new SendMailRequest("user@example.com","New notification", "stringTest");

        // Act




        // Assert
        Assertions.assertEquals(sendMailExpected, mailSender.sendV2(user, "stringTest"));

    }
}
