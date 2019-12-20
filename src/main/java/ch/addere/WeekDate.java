package ch.addere;

import java.util.Objects;

public class WeekDate implements Comparable<WeekDate> {

  private int day;
  private int month;

  public WeekDate(int day, int month) {
    if (day <= 0 || day > 31) {
      throw new IllegalArgumentException("Error: Day is not valid");
    }
    if (month <= 0 || month > 12) {
      throw new IllegalArgumentException("Error: Month is not valid");
    }
    this.day = day;
    this.month = month;
  }

  public int getDay() {
    return day;
  }

  public int getMonth() {
    return month;
  }

  @Override
  public int compareTo(WeekDate other) {
    int result = this.getMonth() - other.getMonth();
    if (result == 0) {
      result = this.getDay() - other.getDay();
    }
    return result;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.getDay(), this.getMonth());
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }

    if (!(obj instanceof WeekDate)) {
      return false;
    }

    WeekDate wd = (WeekDate) obj;
    return this.month == wd.getMonth() && this.day == wd.getDay();

  }

  @Override
  public String toString() {
    return String.format("%02d.%02d.", this.getDay(), this.getMonth());
  }
}
