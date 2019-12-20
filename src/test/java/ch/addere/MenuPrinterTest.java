package ch.addere;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class MenuPrinterTest {

  private static MealList mealList;
  static private final String HOST = "https://hochschule-rapperswil.sv-restaurant.ch";
  static private final String TEST_FILE = "src/test/resources/HSRMensa.html";

  @BeforeAll
  static void initialise() throws IOException {
    File htmlFile = new File(TEST_FILE);
    mealList = new MenuParser(htmlFile, HOST).parseMenus();
  }

  @Test
  void testTodayVegiMenu() {
    ParameterOptions parameterOptions = new ParameterOptions();
    parameterOptions.setMensa();
    parameterOptions.setToday();
    parameterOptions.setVegetarianOnly();
    MenuPrinter menuPrinter = new MenuPrinter(mealList, parameterOptions);
    String expected = "=== Mo 09.12.\n" +
        "---\n" +
        "Quorn-Geschnetzeltes mit Tomaten-Gemüse-Sauce und Fusilli Menüsalat\n" +
        "Vegetarisch\n" +
        "INT " + String.format("%.2f", 8.0) + " | EXT " + String.format("%.2f", 12.0) + "\n\n";
    assertEquals(expected, menuPrinter.toString());
  }

  @Test
  void testMondayVegiMenu() {
    ParameterOptions parameterOptions = new ParameterOptions();
    parameterOptions.setMensa();
    parameterOptions.setMonday();
    parameterOptions.setVegetarianOnly();
    MenuPrinter menuPrinter = new MenuPrinter(mealList, parameterOptions);
    String expected = "=== Mo 09.12.\n" +
        "---\n" +
        "Quorn-Geschnetzeltes mit Tomaten-Gemüse-Sauce und Fusilli Menüsalat\n" +
        "Vegetarisch\n" +
        "INT " + String.format("%.2f", 8.0) + " | EXT " + String.format("%.2f", 12.0) + "\n\n";
    assertEquals(expected, menuPrinter.toString());
  }

  @Test
  void testAllVegiMenu() {
    ParameterOptions parameterOptions = new ParameterOptions();
    parameterOptions.setMensa();
    parameterOptions.setMonday();
    parameterOptions.setTuesday();
    parameterOptions.setWednesday();
    parameterOptions.setThursday();
    parameterOptions.setFriday();
    parameterOptions.setSaturday();
    parameterOptions.setVegetarianOnly();
    MenuPrinter menuPrinter = new MenuPrinter(mealList, parameterOptions);
    String expected = "=== Mo 09.12.\n" +
        "---\n" +
        "Quorn-Geschnetzeltes mit Tomaten-Gemüse-Sauce und Fusilli Menüsalat\n" +
        "Vegetarisch\n" +
        "INT " + String.format("%.2f", 8.0) + " | EXT " + String.format("%.2f", 12.0) + "\n\n" +
        "=== Tu 10.12.\n" +
        "---\n" +
        "Valess Schnitzel mit Limonen­rahmsauce, Bulgur und Ofengemüse\n" +
        "Vegetarisch\n" +
        "INT " + String.format("%.2f", 8.0) + " | EXT " + String.format("%.2f", 12.0) + "\n\n" +

        "=== We 11.12.\n" +
        "---\n" +
        "Risotto Caprese mit getrockneten Tomaten, Mozzarella Kugeln und Basilikum Pesto Menüsalat\n"
        +
        "Vegetarisch\n" +
        "INT " + String.format("%.2f", 8.0) + " | EXT " + String.format("%.2f", 12.0) + "\n\n" +
        "=== Th 12.12.\n" +
        "---\n" +
        "Mediterraner Dinkelburger mit Cheddar, Gurke, Zwiebeln, BBQ Sauce, Pommes Carree und Peperonigemüse\n"
        +
        "Vegetarisch\n" +
        "INT " + String.format("%.2f", 8.0) + " | EXT " + String.format("%.2f", 12.0) + "\n\n" +
        "=== Fr 13.12.\n" +
        "---\n" +
        "Soba Bowl Buchweizen-Nudeln mit Frühlingszwiebeln, gekochtem Soja-Ei und Sesam Menüsalat\n"
        +
        "Vegetarisch\n" +
        "INT " + String.format("%.2f", 8.0) + " | EXT " + String.format("%.2f", 12.0) + "\n\n";
    assertEquals(expected, menuPrinter.toString());
  }


}