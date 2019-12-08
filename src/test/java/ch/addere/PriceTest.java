package ch.addere;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PriceTest {

  @Test
  void testToString() {
    Price price = new Price(8.0, 12.0);
    String expected = "INT " + String.format("%.2f", 8.0) + " | EXT " + String.format("%.2f", 12.0);
    assertEquals(expected, price.toString());
  }

  @Test
  void testHashCode() {
    Price price1 = new Price(8.0, 12.0);
    Price price2 = new Price(8.0, 12.0);
    assertEquals(price1.hashCode(), price2.hashCode());
  }

  @Test
  void testEqual() {
    Price price1 = new Price(8.0, 12.0);
    Price price2 = new Price(8.0, 12.0);
    assertEquals(price1, price2);
  }

  @Test
  void testEqualSelf() {
    Price price1 = new Price(8.0, 12.0);
    assertEquals(price1, price1);
  }

  @Test
  void testNotEqual1() {
    Price price1 = new Price(8.0, 12.0);
    Price price2 = new Price(8.5, 12.0);
    assertNotEquals(price1, price2);
  }

  @Test
  void testNotEqual2() {
    Price price1 = new Price(8.0, 12.0);
    Price price2 = new Price(8.0, 12.5);
    assertNotEquals(price1, price2);
  }

  @Test
  void testNotEqual3() {
    Price price1 = new Price(8.0, 12.0);
    assertNotEquals(price1, null);
  }
}