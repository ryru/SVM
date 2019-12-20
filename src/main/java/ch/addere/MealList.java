package ch.addere;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.SortedMap;
import java.util.TreeMap;

public class MealList {

  private SortedMap<Weekday, List<MenuOption>> meals;
  private Weekday today;
  private Weekday tomorrow;

  public MealList() {
    this.meals = new TreeMap<>();
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
      throw new NoSuchElementException("Error: No meal for tomorrow found.");
    }
  }

  public List<MenuOption> getMealMonday() {
    return getMealForDay(Weekdays.MONDAY);
  }

  public List<MenuOption> getMealTuesday() {
    return getMealForDay(Weekdays.TUESDAY);
  }

  public List<MenuOption> getMealWednesday() {
    return getMealForDay(Weekdays.WEDNESDAY);
  }

  public List<MenuOption> getMealThursday() {
    return getMealForDay(Weekdays.THURSDAY);
  }

  public List<MenuOption> getMealFriday() {
    return getMealForDay(Weekdays.FRIDAY);
  }

  public SortedMap<Weekday, List<MenuOption>> getAllMeals() {
    return meals;
  }

  public int getSize() {
    return meals.size();
  }

  private List<MenuOption> getMealForDay(Weekdays weekdays) {
    Weekday key = new Weekday(weekdays);
    boolean keyFound = meals.containsKey(key);
    if (keyFound) {
      return meals.get(key);
    } else {
      throw new NoSuchElementException("No meal for this day");
    }
  }
}
