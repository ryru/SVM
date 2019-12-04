package ch.addere;

import java.util.Objects;

public class ParameterOptions {

  private boolean isMensa;
  private boolean isBistro;

  private boolean isToday;
  private boolean isTomorrow;

  private boolean vegetarianOnly;

  private boolean isMonday;
  private boolean isTuesday;
  private boolean isWednesday;
  private boolean isThursday;
  private boolean isFriday;
  private boolean isSaturday;

  private boolean isHelp;

  private boolean hasDate;
  private boolean hasRestaurant;

  public ParameterOptions() {
    this.isMensa = false;
    this.isBistro = false;
    this.isToday = false;
    this.isTomorrow = false;
    this.vegetarianOnly = false;
    this.isMonday = false;
    this.isTuesday = false;
    this.isWednesday = false;
    this.isThursday = false;
    this.isFriday = false;
    this.isSaturday = false;
    this.hasDate = false;
    this.hasRestaurant = false;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }

    if (!(obj instanceof ParameterOptions)) {
      return false;
    }

    ParameterOptions po = (ParameterOptions) obj;
    return po.isMensa == this.isMensa && po.isBistro == this.isBistro
        && po.isToday == this.isToday &&
        po.isTomorrow == this.isTomorrow && po.vegetarianOnly == this.vegetarianOnly
        && po.isMonday == this.isMonday && po.isTuesday == this.isTuesday &&
        po.isWednesday == this.isWednesday && po.isThursday == this.isThursday
        && po.isFriday == this.isFriday && po.isSaturday == this.isSaturday;
  }

  @Override
  public int hashCode() {
    return Objects
        .hash(isMensa, isBistro, isToday, isTomorrow, isMonday, isTuesday, isWednesday, isThursday,
            isFriday, isSaturday);
  }

  public boolean hasMensa() {
    return isMensa;
  }

  public void setMensa() {
    isMensa = true;
    hasRestaurant = true;
  }

  public boolean hasBistro() {
    return isBistro;
  }

  public void setBistro() {
    isBistro = true;
    hasRestaurant = true;
  }

  public boolean hasToday() {
    return isToday;
  }

  public void setToday() {
    isToday = true;
    hasDate = true;
  }

  public boolean hasTomorrow() {
    return isTomorrow;
  }

  public void setTomorrow() {
    isTomorrow = true;
    hasDate = true;
  }

  public boolean hasVegetarianOnly() {
    return vegetarianOnly;
  }

  public void setVegetarianOnly() {
    this.vegetarianOnly = true;
  }

  public boolean hasMonday() {
    return isMonday;
  }

  public void setMonday() {
    isMonday = true;
    hasDate = true;
  }

  public boolean hasTuesday() {
    return isTuesday;
  }

  public void setTuesday() {
    isTuesday = true;
    hasDate = true;
  }

  public boolean hasWednesday() {
    return isWednesday;
  }

  public void setWednesday() {
    isWednesday = true;
    hasDate = true;
  }

  public boolean hasThursday() {
    return isThursday;
  }

  public void setThursday() {
    isThursday = true;
    hasDate = true;
  }

  public boolean hasFriday() {
    return isFriday;
  }

  public void setFriday() {
    isFriday = true;
    hasDate = true;
  }

  public boolean hasHelp() {
    return isHelp;
  }

  public void setHelp() {
    isHelp = true;
  }

  public boolean hasSaturday() {
    return isSaturday;
  }

  public void setSaturday() {
    isSaturday = true;
    hasDate = true;
  }

  public boolean hasDate() {
    return hasDate;
  }

  public boolean hasRestaurant() {
    return hasRestaurant;
  }
}
