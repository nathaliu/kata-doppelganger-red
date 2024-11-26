package info.dmerej;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.plaf.nimbus.NimbusStyle;
import java.util.Arrays;
import java.util.List;

public class DiscountApplierTest {
    private NotifierTest notifierTest;
    private DiscountApplier discountApplier = new DiscountApplier(notifierTest);

  private List<User> users;
  private final User user1 = new User("User1","user1@gmail.com");
  private final User user2 = new User("User2","user2@gmail.com");
  @BeforeEach
  void setUp() {
      NotifierTest notifierTest = new NotifierTest();
  }

  @Test
  void should_notify_twice_when_applying_discount_for_two_users_v1() {
    // TODO: write a test to demonstrate the bug in DiscountApplier.applyV1()
    // Arrange
    users = Arrays.asList(user1, user2);
    int discount = 10;
    // Act
    discountApplier.applyV1(discount, users);
    // Assert
    // Check that all users have been notified
    for(User user : users){
        List<String> notificationsExpected = Arrays.asList(user.name() + " You've got a new discount of "+ discount);
        List<String> notificationsResult = notifierTest.getNotifications();
        Assertions.assertEquals(notificationsExpected, notificationsResult);
    }
  }

  @Test
  void should_notify_twice_when_applying_discount_for_two_users_v2() {
    // TODO: write a test to demonstrate the bug in DiscountApplier.applyV2()
      users = Arrays.asList(user1, user2);
      int discount = 10;
      // Act
      discountApplier.applyV2(discount, users);
      // Assert
      // Check that all users have been notified
      for(User user : users){
          List<String> notificationsExpected = Arrays.asList(user.name() + " You've got a new discount of "+ discount);
          List<String> notificationsResult = notifierTest.getNotifications();
          Assertions.assertEquals(notificationsExpected, notificationsResult);
      }
  }

}
