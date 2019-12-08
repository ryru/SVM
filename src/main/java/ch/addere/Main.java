package ch.addere;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Main {

  private static final String MENSA_URL = "https://hochschule-rapperswil.sv-restaurant.ch/de/menuplan/mensa/";
  private static final String BISTRO_URL = "https://hochschule-rapperswil.sv-restaurant.ch/de/menuplan/forschungszentrum/";

  public static void main(String[] args) throws IOException {
    ParameterParser parameterParser = new ParameterParser(args);
    ParameterOptions parameterOptions = null;
    try {
      parameterOptions = parameterParser.parse();
    } catch (IllegalArgumentException e) {
      System.err.println("Invalid argument: " + e.getMessage());
      printHelp();
      System.exit(1);
    }

    if (parameterOptions.hasHelp()) {
      printHelp();
      System.exit(1);
    }

    if (parameterOptions.hasMensa()) {

      InputStream in = new URL(MENSA_URL).openStream();
      File tempFile = File.createTempFile("mensa","html");
      tempFile.deleteOnExit();
      Files.copy(in, Paths.get(tempFile.toURI()), StandardCopyOption.REPLACE_EXISTING);


      MenuParser menuParserMensa = new MenuParser(tempFile, MENSA_URL);
      MealList mensaMeals = menuParserMensa.parseMenus();
      MenuPrinter menuMensaPrinter = new MenuPrinter(mensaMeals, parameterOptions);
      System.out.println(menuMensaPrinter.toString());
    }

    if (parameterOptions.hasBistro()) {
      InputStream in = new URL(BISTRO_URL).openStream();
      File tempFile = File.createTempFile("bistro","html");
      tempFile.deleteOnExit();
      Files.copy(in, Paths.get(tempFile.toURI()), StandardCopyOption.REPLACE_EXISTING);

      MenuParser menuParserBistro = new MenuParser(tempFile, BISTRO_URL);
      MealList bistroMeals = menuParserBistro.parseMenus();
      MenuPrinter menuForschPrinter = new MenuPrinter(bistroMeals, parameterOptions);
      System.out.println(menuForschPrinter.toString());
    }
  }

  private static void printHelp() {
    System.out.println("Usage svm [options...]");
    System.out.println();
    System.out.println("Options");
    printArgument("mensa", "", "Print menu of HSR Mensa");
    printArgument("bistro", "", "Print menu of HSR Bistor");
    printArgument("vegi", "vegetarian, v", "Print vegetarian menus only");
    System.out.println();
    printArgument("tod", "today", "Print menu of this day");
    printArgument("tom", "tomorrow", "Print menu of tomorrow");
    printArgument("mo", "mon, monday", "Print monday's menu");
    printArgument("tu", "tue, tuesday", "Print tuesday's menu");
    printArgument("we", "wed, wednesday", "Print tuesday's menu");
    printArgument("th", "thu, thursday", "Print thursday's menu");
    printArgument("fr", "fri, friday", "Print friday's menu");
    printArgument("sa", "sat, saturday", "Print saturday's menu");
    printArgument("all", "", "Print all upcoming menus");
    System.out.println();
    printArgument("help", "", "Print this help message");
    System.out.println();
    System.out.println();
  }

  private static void printArgument(String arg, String alias, String description) {
    System.out.print(" " + arg);
    System.out.print("\t" + alias);
    System.out.println("\t" + description);
  }

}
