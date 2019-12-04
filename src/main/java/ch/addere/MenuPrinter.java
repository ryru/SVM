package ch.addere;

import java.util.ArrayList;
import java.util.List;

public class MenuPrinter {

  private static final String LABEL_VEGETARIAN = "Vegetarisch";

  private MealList mealList;
  private List<List<MenuOption>> listOfMenusToPrint;
  private ParameterOptions parameterOptions;

  MenuPrinter(MealList mealList, ParameterOptions parameterOptions) {
    this.mealList = mealList;
    this.parameterOptions = parameterOptions;
    this.listOfMenusToPrint = new ArrayList<>();

    // extraxt me later
    listOfMenusToPrint = parse();
  }

  @Override
  public String toString() {
    return defaultPrinter();
  }

  private String defaultPrinter() {
    StringBuilder sb = new StringBuilder();

    for (List<MenuOption> menus : listOfMenusToPrint) {
      if (menus != null) {
        sb.append("=== ").append(menus.get(0).getDate()).append('\n');
        sb.append(dayPrinter(menus));
      }
    }
    return sb.toString();
  }

  private String dayPrinter(List<MenuOption> menus) {
    StringBuilder sb = new StringBuilder();
    for (MenuOption menu : menus) {
      sb.append("---").append('\n');
      sb.append(menuPrinter(menu));
    }
    return sb.toString();
  }

  private String menuPrinter(MenuOption menu) {
    StringBuilder sb = new StringBuilder();
    sb.append(menu.getTitle()).append(' ').append(menu.getDescription()).append('\n');
    if (menu.isVegetarian()) {
      sb.append(LABEL_VEGETARIAN).append('\n');
    }
    if (!menu.getProvenance().isEmpty()) {
      sb.append(menu.getProvenance()).append('\n');
    }
    sb.append(menu.getPrice()).append('\n');
    sb.append('\n');
    return sb.toString();
  }

  private List<List<MenuOption>> parse() {
    List<List<MenuOption>> menuOptions = new ArrayList<>();

    parseDate(menuOptions);
    menuOptions = parseVegetarianOnly(menuOptions);

    return menuOptions;
  }

  private void parseDate(List<List<MenuOption>> menuOptions) {
    parseRelativeDate(menuOptions);
    parseAbsoluteDate(menuOptions);
  }

  private void parseRelativeDate(List<List<MenuOption>> menuOptions) {
    if (parameterOptions.hasToday()) {
      menuOptions.add(mealList.getMealToday());
    }

    if (parameterOptions.hasTomorrow()) {
      menuOptions.add(mealList.getMealTomorrow());
    }
  }

  private void parseAbsoluteDate(List<List<MenuOption>> menuOptions) {
    if (parameterOptions.hasMonday() && !menuOptions.contains(mealList.getMealMonday())) {
      menuOptions.add(mealList.getMealMonday());
    }

    if (parameterOptions.hasTuesday() && !menuOptions.contains(mealList.getMealTuesday())) {
      menuOptions.add(mealList.getMealTuesday());
    }

    if (parameterOptions.hasWednesday() && !menuOptions.contains(mealList.getMealWednesday())) {
      menuOptions.add(mealList.getMealWednesday());
    }

    if (parameterOptions.hasThursday() && !menuOptions.contains(mealList.getMealThursday())) {
      menuOptions.add(mealList.getMealThursday());
    }

    if (parameterOptions.hasFriday() && !menuOptions.contains(mealList.getMealFriday())) {
      menuOptions.add(mealList.getMealFriday());
    }

    if (parameterOptions.hasSaturday() && !menuOptions.contains(mealList.getMealSaturday())) {
      menuOptions.add(mealList.getMealSaturday());
    }

  }

  private List<List<MenuOption>> parseVegetarianOnly(List<List<MenuOption>> menuOptions) {
    if (parameterOptions.hasVegetarianOnly()) {
      return removeAllNonVegetarianFood(menuOptions);
    } else {
      return menuOptions;
    }
  }

  private List<List<MenuOption>> removeAllNonVegetarianFood(List<List<MenuOption>> menuOptions) {
    List<List<MenuOption>> newMenuOptions = new ArrayList<>();
    menuOptions.forEach(listOfMeals -> {
      if (listOfMeals != null) {
        List<MenuOption> newMenuList = new ArrayList<>();
        listOfMeals.forEach(meal -> {
          if (meal.isVegetarian()) {
            newMenuList.add(meal);
          }
        });
        newMenuOptions.add(newMenuList);
      }
    });

    return newMenuOptions;
  }

}
