package ch.addere;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class MenuOptionTest {

  private static MenuOption menu1;

  @BeforeAll
  static void initialiseMenus() {
    Weekday weekday1 = new Weekday(Weekdays.FRIDAY, "22.11.");
    Price price1 = new Price(8.0, 12.0);
    menu1 = new MenuOption(weekday1, "Paniertes MSC Kabeljau Filet",
        "mit Mayonnaise, Petersilien-Kartoffeln und Lattich mit Zwiebeln",
        "Herkunft: Kabeljau / Nord-Ost Atlantik", price1, false);
  }

  @Test
  void testMenuToString() {
    String expected = "Fr 22.11.\n" +
        "Paniertes MSC Kabeljau Filet " +
        "mit Mayonnaise, Petersilien-Kartoffeln und Lattich mit Zwiebeln\n" +
        "Herkunft: Kabeljau / Nord-Ost Atlantik\n" +
        "INT " + String.format("%.2f", 8.0) + " | EXT " + String.format("%.2f", 12.0);
    assertEquals(expected, menu1.toString());
  }

  @Test
  void testMenuGetDate() {
    assertEquals("Fr 22.11.", menu1.getDate());
  }

  @Test
  void testMenuGetTitle() {
    assertEquals("Paniertes MSC Kabeljau Filet", menu1.getTitle());
  }

  @Test
  void testMenuGetDescription() {
    assertEquals("mit Mayonnaise, Petersilien-Kartoffeln und Lattich mit Zwiebeln", menu1.getDescription());
  }

  @Test
  void testMenuGetProvenance() {
    assertEquals("Herkunft: Kabeljau / Nord-Ost Atlantik", menu1.getProvenance());
  }

  @Test
  void testMenuGetPrice() {
    assertEquals(new Price(8.0, 12.0).toString(), menu1.getPrice());
  }

  @Test
  void testMenuIsVegetarian() {
    assertFalse(menu1.isVegetarian());
  }
}