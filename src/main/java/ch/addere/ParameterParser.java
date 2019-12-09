package ch.addere;

import java.util.ArrayList;
import java.util.List;

public class ParameterParser {

  private static final String MENSA = "mensa";
  private static final String BISTRO = "bistro";
  private static final String VEGI = "vegi";
  private static final String VEGETARIAN = "vegetarian";
  private static final String V = "v";
  private static final String TOD = "tod";
  private static final String TODAY = "today";
  private static final String TOM = "tom";
  private static final String TOMORROW = "tomorrow";
  private static final String MO = "mo";
  private static final String MON = "mon";
  private static final String MONDAY = "monday";
  private static final String TU = "tu";
  private static final String TUE = "tue";
  private static final String TUESDAY = "tuesday";
  private static final String WE = "we";
  private static final String WED = "wed";
  private static final String WEDNESDAY = "wednesday";
  private static final String TH = "th";
  private static final String THU = "thu";
  private static final String THURSDAY = "thursday";
  private static final String FR = "fr";
  private static final String FRI = "fri";
  private static final String FRIDAY = "friday";
  private static final String SA = "sa";
  private static final String SAT = "sat";
  private static final String SATURDAY = "saturday";
  private static final String ALL = "all";
  private static final String HELP = "help";

  private List<String> argumentList;
  private ParameterOptions parameterOptions;
  private List<String> foundArguments = new ArrayList<>();

  public ParameterParser(String[] args) {
    argumentList = new ArrayList<>();

    parameterOptions = new ParameterOptions();
    for (String s : args) {
      String newArg = s.toLowerCase().trim();
      argumentList.add(newArg);
    }
  }

  public ParameterOptions parse() {

    argumentList.forEach(arg -> {
      findMensa(arg);
      findBistro(arg);
      findVegetarianOnly(arg);
      findToday(arg);
      findTomorrow(arg);
      findMonday(arg);
      findTuesday(arg);
      findWednesday(arg);
      findThursday(arg);
      findFriday(arg);
      findSaturday(arg);
      findAllWeek(arg);
      findHelp(arg);
    });

    argumentList.removeAll(foundArguments);

    if (!parameterOptions.hasDate()) {
      parameterOptions.setToday();
    }

    if (!parameterOptions.hasRestaurant()) {
      parameterOptions.setMensa();
    }

    if (!argumentList.isEmpty()) {
      throw new IllegalArgumentException(argumentList.get(0));
    }

    return parameterOptions;
  }

  private void findMensa(String arg) {
    if (arg.equals(MENSA)) {
      parameterOptions.setMensa();
      foundArguments.add(arg);
    }
  }

  private void findBistro(String arg) {
    if (arg.equals(BISTRO)) {
      parameterOptions.setBistro();
      foundArguments.add(arg);
    }
  }

  private void findVegetarianOnly(String arg) {
    if (arg.equals(VEGI) || arg.equals(VEGETARIAN) || arg.equals(V)) {
      parameterOptions.setVegetarianOnly();
      foundArguments.add(arg);
    }
  }

  private void findToday(String arg) {
    if (arg.equals(TOD) || arg.equals(TODAY)) {
      parameterOptions.setToday();
      foundArguments.add(arg);
    }
  }

  private void findTomorrow(String arg) {
    if (arg.equals(TOM) || arg.equals(TOMORROW)) {
      parameterOptions.setTomorrow();
      foundArguments.add(arg);
    }
  }

  private void findMonday(String arg) {
    if (arg.equals(MO) || arg.equals(MON) || arg.equals(MONDAY)) {
      parameterOptions.setMonday();
      foundArguments.add(arg);
    }
  }

  private void findTuesday(String arg) {
    if (arg.equals(TU) || arg.equals(TUE) || arg.equals(TUESDAY)) {
      parameterOptions.setTuesday();
      foundArguments.add(arg);
    }
  }

  private void findWednesday(String arg) {
    if (arg.equals(WE) || arg.equals(WED) || arg.equals(WEDNESDAY)) {
      parameterOptions.setWednesday();
      foundArguments.add(arg);
    }
  }

  private void findThursday(String arg) {
    if (arg.equals(TH) || arg.equals(THU) || arg.equals(THURSDAY)) {
      parameterOptions.setThursday();
      foundArguments.add(arg);
    }
  }

  private void findFriday(String arg) {
    if (arg.equals(FR) || arg.equals(FRI) || arg.equals(FRIDAY)) {
      parameterOptions.setFriday();
      foundArguments.add(arg);
    }
  }

  private void findSaturday(String arg) {
    if (arg.equals(SA) || arg.equals(SAT) || arg.equals(SATURDAY)) {
      parameterOptions.setSaturday();
      foundArguments.add(arg);
    }
  }

  private void findAllWeek(String arg) {
    if (arg.equals(ALL)) {
      parameterOptions.setMonday();
      parameterOptions.setTuesday();
      parameterOptions.setWednesday();
      parameterOptions.setThursday();
      parameterOptions.setFriday();
      parameterOptions.setSaturday();
      foundArguments.add(arg);
    }
  }

  private void findHelp(String arg) {
    if (arg.equals(HELP)) {
      parameterOptions.setHelp();
      foundArguments.add(arg);
    }
  }
}
