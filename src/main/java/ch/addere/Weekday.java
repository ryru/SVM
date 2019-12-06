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

  private Weekdays weekday;
  private String date;

  public Weekday(Weekdays weekday) {
    this.weekday = weekday;
    this.date = "";
  }

  public Weekday(Weekdays weekday, String date) {
    this.weekday = weekday;
    this.date = date;
  }

  public static Weekdays parseWeekday(String day) {
    if (day == null || day.length() != 2) {
      throw new IllegalArgumentException("Invalid day");
    }

    day = day.toLowerCase();

    Weekdays weekday;

    if (day.equals("mo")) {
      weekday = Weekdays.MONDAY;
    } else if (day.equals("di")) {
      weekday = Weekdays.TUESDAY;
    } else if (day.equals("mi")) {
      weekday = Weekdays.WEDNESDAY;
    } else if (day.equals("do")) {
      weekday = Weekdays.THURSDAY;
    } else if (day.equals("fr")) {
      weekday = Weekdays.FRIDAY;
    } else if (day.equals("sa")) {
      weekday = Weekdays.SATURDAY;
    } else {
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

    Weekday weekday = (Weekday) obj;
    return Objects.equals(weekday.weekday, this.weekday);

  }

  @Override
  public int hashCode() {
    return Objects.hash(weekday);
  }

  public String getDay() {
    String day;

    switch (weekday) {
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
