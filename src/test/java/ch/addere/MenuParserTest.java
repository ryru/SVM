package ch.addere;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class MenuParserTest {
  static private File htmlFile;
  static private final String HOST = "https://hochschule-rapperswil.sv-restaurant.ch";
  static private final String TEST_FILE = "src/test/resources/HSRMensa.html";

  @BeforeAll
  static void initialise() {
    htmlFile = new File(TEST_FILE);
  }

  @Test
  void testParseSize() throws IOException {
    MenuParser menuParser = new MenuParser(htmlFile, HOST);
    MealList mealList = menuParser.parseMenus();
    assertEquals(5, mealList.getSize());
  }



}