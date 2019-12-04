package ch.addere;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class MenuOptionTest {

  private static MenuOption menu1;

  @BeforeAll
  static void initialiseMenus() {
    Weekday weekday1 = new Weekday("Fr", "22.11.");
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
        "INT 8.00 | EXT 12.00";
    assertEquals(expected, menu1.toString());
  }
}