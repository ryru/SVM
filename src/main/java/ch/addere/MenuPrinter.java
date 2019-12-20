package ch.addere;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedMap;

public class MenuPrinter {

  private static final String LABEL_VEGETARIAN = "Vegetarisch";

  private MealList mealList;
  private SortedMap<Weekday, List<MenuOption>> listOfSortedMealsToPrint;
  private ParameterOptions parameterOptions;

  MenuPrinter(MealList mealList, ParameterOptions parameterOptions) {
    this.mealList = mealList;
    this.parameterOptions = parameterOptions;
    this.listOfSortedMealsToPrint = mealList.getAllMeals();
  }

  @Override
  public String toString() {
    return composeString();
  }

  private String composeString() {

    boolean vegetarianOnly = parameterOptions.hasVegetarianOnly();

    StringBuilder sb = new StringBuilder();

    for (Map.Entry<Weekday, List<MenuOption>> dayEntry : listOfSortedMealsToPrint.entrySet()) {

      if (parameterOptions.hasToday() && (mealList.getToday() == dayEntry.getKey())) {
        composeDayMenu(vegetarianOnly, sb, dayEntry);
      }

      if (parameterOptions.hasTomorrow() && (mealList.getTomorrow() == dayEntry.getKey())) {
        composeDayMenu(vegetarianOnly, sb, dayEntry);
      }

      if (parameterOptions.containsWeekday(dayEntry.getValue().get(0).getWeekday())) {

        composeDayMenu(vegetarianOnly, sb, dayEntry);


      }


    }

    return sb.toString();
  }

  private void composeDayMenu(boolean vegetarianOnly, StringBuilder sb,
      Entry<Weekday, List<MenuOption>> dayEntry) {
    sb.append("=== ").append(dayEntry.getValue().get(0).getDate()).append('\n');

    for (MenuOption menus : dayEntry.getValue()) {
      if (menus != null && (vegetarianOnly && menus.isVegetarian())) {
        sb.append(composeDay(menus));
      }
    }
  }


  private String composeDay(MenuOption menu) {
    return "---" + '\n'
        + menuPrinter(menu);
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
}
