package ch.addere;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

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
    parameterOptions = new ParameterOptions();
    argumentList = new ArrayList<>(Arrays.asList(args));
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

    checkForInvalidArguments();

    setDefaultDayIfNotAlreadySet();
    setDefaultRestaurantIfNotAlreadySet();

    return parameterOptions;
  }

  private void checkForInvalidArguments() {
    argumentList.removeAll(foundArguments);

    if (!argumentList.isEmpty()) {
      throw new IllegalArgumentException(argumentList.get(0));
    }
  }

  private void setDefaultRestaurantIfNotAlreadySet() {
    if (!parameterOptions.hasRestaurant()) {
      parameterOptions.setMensa();
    }
  }

  private void setDefaultDayIfNotAlreadySet() {
    if (!parameterOptions.hasDate()) {
      parameterOptions.setToday();
    }
  }

  private void findMensa(String arg) {
    if (Stream.of(MENSA).anyMatch(arg::equalsIgnoreCase)) {
      parameterOptions.setMensa();
      foundArguments.add(arg);
    }
  }

  private void findBistro(String arg) {
    if (Stream.of(BISTRO).anyMatch(arg::equalsIgnoreCase)) {
      parameterOptions.setBistro();
      foundArguments.add(arg);
    }
  }

  private void findVegetarianOnly(String arg) {
    if (Stream.of(VEGI, VEGETARIAN, V).anyMatch(arg::equalsIgnoreCase)) {
      parameterOptions.setVegetarianOnly();
      foundArguments.add(arg);
    }
  }

  private void findToday(String arg) {
    if (Stream.of(TOD, TODAY).anyMatch(arg::equalsIgnoreCase)) {
      parameterOptions.setToday();
      foundArguments.add(arg);
    }
  }

  private void findTomorrow(String arg) {
    if (Stream.of(TOM, TOMORROW).anyMatch(arg::equalsIgnoreCase)) {
      parameterOptions.setTomorrow();
      foundArguments.add(arg);
    }
  }

  private void findMonday(String arg) {
    if (Stream.of(MO, MON, MONDAY).anyMatch(arg::equalsIgnoreCase)) {
      parameterOptions.setMonday();
      foundArguments.add(arg);
    }
  }

  private void findTuesday(String arg) {
    if (Stream.of(TU, TUE, TUESDAY).anyMatch(arg::equalsIgnoreCase)) {
      parameterOptions.setTuesday();
      foundArguments.add(arg);
    }
  }

  private void findWednesday(String arg) {
    if (Stream.of(WE, WED, WEDNESDAY).anyMatch(arg::equalsIgnoreCase)) {
      parameterOptions.setWednesday();
      foundArguments.add(arg);
    }
  }

  private void findThursday(String arg) {
    if (Stream.of(TH, THU, THURSDAY).anyMatch(arg::equalsIgnoreCase)) {
      parameterOptions.setThursday();
      foundArguments.add(arg);
    }
  }

  private void findFriday(String arg) {
    if (Stream.of(FR, FRI, FRIDAY).anyMatch(arg::equalsIgnoreCase)) {
      parameterOptions.setFriday();
      foundArguments.add(arg);
    }
  }

  private void findSaturday(String arg) {
    if (Stream.of(SA, SAT, SATURDAY).anyMatch(arg::equalsIgnoreCase)) {
      parameterOptions.setSaturday();
      foundArguments.add(arg);
    }
  }

  private void findAllWeek(String arg) {
    if (Stream.of(ALL).anyMatch(arg::equalsIgnoreCase)) {
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
