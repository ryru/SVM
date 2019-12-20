package ch.addere;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class MealListTest {

  private static MealList mealList;
  static private final String HOST = "https://hochschule-rapperswil.sv-restaurant.ch";
  static private final String TEST_FILE = "src/test/resources/HSRMensa.html";

  @BeforeAll
  static void initialise() throws IOException {
    File htmlFile = new File(TEST_FILE);
    mealList = new MenuParser(htmlFile, HOST).parseMenus();
  }

  @Test
  void testGetTodayWeekday() {
    Weekday expected = new Weekday(Weekdays.MONDAY);
    assertEquals(expected, mealList.getToday());
  }

  @Test
  void testGetTomorrowWeekday() {
    Weekday expected = new Weekday(Weekdays.TUESDAY);
    assertEquals(expected, mealList.getTomorrow());
  }

  @Test
  void testGetMealToday() {
    assertEquals(4, mealList.getMealToday().size());
  }

  @Test
  void testGetMealTomorrow() {
    assertEquals(4, mealList.getMealTomorrow().size());
  }

  @Test
  void testGetMealMonday() {
    assertEquals(4, mealList.getMealMonday().size());
  }

  @Test
  void testGetMealTuesday() {
    assertEquals(4, mealList.getMealTuesday().size());
  }

  @Test
  void testGetMealWednesday() {
    assertEquals(4, mealList.getMealWednesday().size());
  }

  @Test
  void testGetMealThursday() {
    assertEquals(4, mealList.getMealThursday().size());
  }

  @Test
  void testGetMealFriday() {
    assertEquals(4, mealList.getMealFriday().size());
  }

}