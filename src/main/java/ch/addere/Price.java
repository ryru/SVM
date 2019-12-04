package ch.addere;

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
}
