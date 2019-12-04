package ch.addere;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MenuParser {

  private String url;

  MenuParser(String url) {
    this.url = url;
  }

  public MealList parseMenues() throws IOException {

    Document doc = Jsoup.connect(url).get();

    // date
    Elements days = doc.getElementsByClass("day-nav");
    Elements span = days.select("li");

    List<Weekday> weekdayList = new ArrayList<>();
    span.forEach(e -> {
      String day = e.getElementsByClass("day").text().trim();
      String date = e.getElementsByClass("date").text().trim();
      weekdayList.add(new Weekday(day, date));
    });

    // menu
    Elements tabs = doc.getElementsByClass("menu-plan-grid");

    MealList mealList = new MealList();
    mealList.setToday(weekdayList.get(0));
    mealList.setTomorrow(weekdayList.get(1));
    final int[] i = {0};
    tabs.forEach(e -> {
      Weekday thisWeekday = weekdayList.get(i[0]);
      i[0]++;
      mealList.put(thisWeekday, parseTab(e, thisWeekday));
    });

    return mealList;
  }

  private List<MenuOption> parseTab(Element tabElement, Weekday thisWeekday) {
    List<MenuOption> menuOptions = new ArrayList<>();
    tabElement.getElementsByClass("menu-item").forEach(menuItem -> {
      MenuOption menu1 = createMenu(menuItem, thisWeekday);
      menuOptions.add(menu1);
    });
    return menuOptions;
  }

  private String getMenuTitle(Element menuItem) {
    return menuItem.getElementsByClass("menu-title").text().trim();
  }

  private String getMenuDescription(Element menuItem) {
    return menuItem.getElementsByClass("menu-description").text().trim();
  }

  private String getProvenance(Element menuItem) {
    return menuItem.getElementsByClass("menu-provenance").text().trim();
  }

  private Price getMenuPrice(Element menuItem) {
    List<String> priceList = new ArrayList<>();
    Elements menuPrices = menuItem.getElementsByClass("val");
    menuPrices.forEach(p -> priceList.add(p.text().trim()));

    double priceINT;
    double priceEXT;
    if (priceList.size() >= 2) {
      priceINT = Double.parseDouble(priceList.get(0));
      priceEXT = Double.parseDouble(priceList.get(1));
    } else {
      priceINT = 23.0;
      priceEXT = 42.0;
    }
    return new Price(priceINT, priceEXT);
  }

  private boolean isVegetarian(Element menuItem) {
    return !menuItem.getElementsByClass("label-vegetarian").isEmpty();
  }

  private MenuOption createMenu(Element menuItem, Weekday weekday) {
    String menuTitle = getMenuTitle(menuItem);
    String menuDescription = getMenuDescription(menuItem);
    String provenance = getProvenance(menuItem);
    Price price = getMenuPrice(menuItem);
    boolean isVegetarian = isVegetarian(menuItem);

    return new MenuOption(weekday, menuTitle, menuDescription, provenance, price, isVegetarian);
  }
}
