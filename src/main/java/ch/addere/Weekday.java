package ch.addere;

import java.util.Objects;

enum Weekdays {
  MONDAY,
  TUESDAY,
  WEDNESDAY,
  THURSDAY,
  FRIDAY,
  SATURDAY
}

public class Weekday {

  private Weekdays weekdays;
  private String date;

  public Weekday(Weekdays weekdays) {
    this.weekdays = weekdays;
    this.date = "";
  }

  public Weekday(Weekdays weekdays, String date) {
    this.weekdays = weekdays;
    this.date = date;
  }

  public static Weekdays parseWeekday(String day) {
    if (day == null || day.length() != 2) {
      throw new IllegalArgumentException("Invalid day");
    }

    day = day.toLowerCase();

    Weekdays weekday;

    switch (day) {
      case "mo":
        weekday = Weekdays.MONDAY;
        break;
      case "di":
        weekday = Weekdays.TUESDAY;
        break;
      case "mi":
        weekday = Weekdays.WEDNESDAY;
        break;
      case "do":
        weekday = Weekdays.THURSDAY;
        break;
      case "fr":
        weekday = Weekdays.FRIDAY;
        break;
      case "sa":
        weekday = Weekdays.SATURDAY;
        break;
      default:
        throw new IllegalArgumentException("Invalid day: " + day);
    }

    return weekday;
  }

  @Override
  public String toString() {
    return getDay() + " " + date;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }

    if (!(obj instanceof Weekday)) {
      return false;
    }

    Weekday wd = (Weekday) obj;
    return Objects.equals(wd.weekdays, this.weekdays);

  }

  @Override
  public int hashCode() {
    return Objects.hash(weekdays);
  }

  public String getDay() {
    String day;

    switch (weekdays) {
      case MONDAY:
        day = "Mo";
        break;
      case TUESDAY:
        day = "Tu";
        break;
      case WEDNESDAY:
        day = "We";
        break;
      case THURSDAY:
        day = "Th";
        break;
      case FRIDAY:
        day = "Fr";
        break;
      case SATURDAY:
        day = "Sa";
        break;
      default:
        day = "";
    }

    return day;
  }
}
