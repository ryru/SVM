package ch.addere;

import java.util.Objects;

public class Weekday {

  private String day;
  private String date;

  public Weekday(String day) {
    this.day = day;
    this.date = "";
  }

  public Weekday(String day, String date) {
    this.day = day;
    this.date = date;
  }

  @Override
  public String toString() {
    return day + " " + date;
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
    return Objects.equals(weekday.day, this.day);

  }

  @Override
  public int hashCode() {
    return Objects.hash(day);
  }

  public String getDay() {
    return day;
  }

  public String getDate() {
    return date;
  }
}
