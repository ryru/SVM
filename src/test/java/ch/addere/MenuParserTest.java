package ch.addere;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class MenuParserTest {

  static private File htmlFile;
  static private final String TEST_FILE_ORDERING = "src/test/resources/Ordering.html";
  static private final String HOST = "https://hochschule-rapperswil.sv-restaurant.ch";
  static private final String TEST_FILE = "src/test/resources/HSRMensa.html";
  static private File htmlFileOrdering;

  @BeforeAll
  static void initialise() {
    htmlFile = new File(TEST_FILE);
    htmlFileOrdering = new File(TEST_FILE_ORDERING);
  }

  @Test
  void testParseSize() throws IOException {
    MenuParser menuParser = new MenuParser(htmlFile, HOST);
    MealList mealList = menuParser.parseMenus();
    assertEquals(5, mealList.getSize());
  }

  @Test
  void testCorrectOrdering() throws IOException {
    MenuParser menuParser = new MenuParser(htmlFileOrdering, HOST);
    MealList mealList = menuParser.parseMenus();
    assertEquals(new Weekday(Weekdays.FRIDAY), mealList.getAllMeals().firstKey());
    assertEquals(new Weekday(Weekdays.WEDNESDAY), mealList.getAllMeals().lastKey());
  }


}