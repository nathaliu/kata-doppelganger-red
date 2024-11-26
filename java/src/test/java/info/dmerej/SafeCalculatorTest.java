package info.dmerej;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SafeCalculatorTest {
  private SafeCalculator calculator;
  @BeforeEach
    void setUp() {
    calculator = new SafeCalculator(() -> true);
  }
  @Test
  void should_not_throw_when_authorized() {
    // TODO: write a test to demonstrate the bug in SafeCalculator.add()
    // Arrange
    int a = 1, b = 2;
    int expected = 3;
    // Act
    int result = calculator.add(a, b);
    // Assert
    Assertions.assertEquals(expected, result,"The calculator should return the correct sum");
  }
}
