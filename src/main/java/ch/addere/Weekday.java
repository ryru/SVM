package ch.addere;

import java.util.Objects;
import java.util.StringTokenizer;

enum Weekdays {
  MONDAY,
  TUESDAY,
  WEDNESDAY,
  THURSDAY,
  FRIDAY,
  SATURDAY
}

public class Weekday implements Comparable<Weekday> {

  private Weekdays weekdays;
  private WeekDate date;

  public Weekday(Weekdays weekdays) {
    this.weekdays = weekdays;
    this.date = null;
  }

  public Weekday(Weekdays weekdays, String date) {
    this.weekdays = weekdays;
    this.date = parseDate(date);
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

  public Weekdays getWeekday() {
    return weekdays;
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

  private WeekDate parseDate(String date) {
    if (date == null || date.isEmpty() || date.length() > 6) {
      throw new IllegalArgumentException("Error: Invalid date");
    }

    StringTokenizer stringTokenizer = new StringTokenizer(date, ".");
    int day = Integer.parseInt(stringTokenizer.nextToken());
    int month = Integer.parseInt(stringTokenizer.nextToken());

    return new WeekDate(day, month);
  }

  @Override
  public int compareTo(Weekday other) {
    if (date != null) {
      return date.compareTo(other.date);
    } else {
      return 0;
    }
  }
}
