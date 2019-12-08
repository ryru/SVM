package ch.addere;

import java.util.Objects;

public class Price {

  private double priceINT;
  private double priceEXT;

  public Price(double priceINT, double priceEXT) {
    this.priceINT = priceINT;
    this.priceEXT = priceEXT;
  }

  public String getPriceINT() {
    return String.format("%.2f", priceINT);
  }

  public String getPriceEXT() {
    return String.format("%.2f", priceEXT);
  }

  @Override
  public String toString() {
    return "INT " + getPriceINT() + " " +
        "| EXT " + getPriceEXT();

  }

  @Override
  public int hashCode() {
    return Objects.hash(priceINT, priceEXT);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }

    if (!(obj instanceof Price)) {
      return false;
    }

    Price p = (Price) obj;
    return (p.priceINT == this.priceINT && p.priceEXT == this.priceEXT);
  }
}
