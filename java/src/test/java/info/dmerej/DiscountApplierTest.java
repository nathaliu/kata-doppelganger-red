package info.dmerej;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.plaf.nimbus.NimbusStyle;
import java.util.Arrays;
import java.util.List;

public class DiscountApplierTest {
  @Test
  void should_notify_twice_when_applying_discount_for_two_users_v1() {
    // TODO: write a test to demonstrate the bug in DiscountApplier.applyV1()
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
