package ch.addere;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class MenuPrinterTest {

  private static MealList mealList;
  private static ParameterOptions parameterOptions;
  static private final String HOST = "https://hochschule-rapperswil.sv-restaurant.ch";
  static private final String TEST_FILE = "src/test/resources/HSRMensa.html";

  @BeforeAll
  static void initialise() throws IOException {
    File htmlFile = new File(TEST_FILE);
    mealList = new MenuParser(htmlFile, HOST).parseMenus();
    parameterOptions = new ParameterOptions();
    parameterOptions.setMensa();
    parameterOptions.setToday();
    parameterOptions.setVegetarianOnly();
  }

  @Test
  void testTodayVegiMenu() {
    MenuPrinter menuPrinter = new MenuPrinter(mealList, parameterOptions);
    String expected = "=== Mo 09.12.\n" +
        "---\n" +
        "Quorn-Geschnetzeltes mit Tomaten-Gemüse-Sauce und Fusilli Menüsalat\n" +
        "Vegetarisch\n" +
        "INT 8,00 | EXT 12,00\n\n";
    assertEquals(expected, menuPrinter.toString());
  }


}