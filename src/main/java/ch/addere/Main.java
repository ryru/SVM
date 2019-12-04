package ch.addere;


import java.io.IOException;

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
      MenuParser menuParserMensa = new MenuParser(MENSA_URL);
      MealList mensaMeals = menuParserMensa.parseMenues();
      MenuPrinter menuMensaPrinter = new MenuPrinter(mensaMeals, parameterOptions);
      System.out.println(menuMensaPrinter.toString());
    }

    if (parameterOptions.hasBistro()) {
      MenuParser menuParserBistro = new MenuParser(BISTRO_URL);
      MealList bistroMeals = menuParserBistro.parseMenues();
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
