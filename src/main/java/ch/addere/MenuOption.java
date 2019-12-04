package ch.addere;

public class MenuOption {

  private Weekday weekday;
  private String title;
  private String description;
  private String provenance;
  private Price price;
  private boolean isVegetarian;

  public MenuOption(Weekday weekday, String title, String description, String provenance,
      Price price,
      boolean isVegetarian) {
    this.weekday = weekday;
    this.title = title;
    this.description = description;
    this.provenance = provenance;
    this.price = price;
    this.isVegetarian = isVegetarian;
  }

  @Override
  public String toString() {
    return weekday.toString() + '\n' + title + ' '
        + description + '\n'
        + ((isVegetarian) ? "(vegetarisch)\n" : "")
        + ((provenance == null || provenance.isEmpty()) ? "" : provenance + '\n')
        + price.toString();
  }

  public String getDate() {
    return weekday.toString();
  }

  public String getTitle() {
    return title;
  }

  public String getDescription() {
    return description;
  }

  public String getProvenance() {
    return provenance;
  }

  public String getPrice() {
    return price.toString();
  }

  public boolean isVegetarian() {
    return isVegetarian;
  }
}
