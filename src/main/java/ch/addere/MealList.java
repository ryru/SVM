package ch.addere;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class MealList {

  private Map<Weekday, List<MenuOption>> meals;
  private Weekday today;
  private Weekday tomorrow;

  public MealList() {
    this.meals = new HashMap<>();
  }

  public Weekday getToday() {
    return today;
  }

  public void setToday(Weekday today) {
    this.today = today;
  }

  public Weekday getTomorrow() {
    return tomorrow;
  }

  public void setTomorrow(Weekday tomorrow) {
    this.tomorrow = tomorrow;
  }

  public void put(Weekday weekday, List<MenuOption> menuOptions) {
    meals.put(weekday, menuOptions);
  }

  public List<MenuOption> getMealToday() {
    return meals.get(today);
  }

  public List<MenuOption> getMealTomorrow() {
    if (meals.containsKey(tomorrow)) {
      return meals.get(tomorrow);
    } else {
      throw new NoSuchElementException("Error: Nu meal for tomorrow found.");
    }
  }

  public List<MenuOption> getMealMonday() {
    return meals.get(new Weekday(("Mo")));
  }

  public List<MenuOption> getMealTuesday() {
    return meals.get(new Weekday(("Di")));
  }

  public List<MenuOption> getMealWednesday() {
    return meals.get(new Weekday(("Mi")));
  }

  public List<MenuOption> getMealThursday() {
    return meals.get(new Weekday(("Do")));
  }

  public List<MenuOption> getMealFriday() {
    return meals.get(new Weekday(("Fr")));
  }

  public List<MenuOption> getMealSaturday() {
    return meals.get(new Weekday(("Sa")));
  }
}
