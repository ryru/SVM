package ch.addere;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ParameterParserTest {

  static private ParameterOptions defaultConfig;

  private static String[] tokenise(String args) {
    List<String> stringTokens = new ArrayList<>();
    StringTokenizer tokenizer = new StringTokenizer(args);
    while (tokenizer.hasMoreTokens()) {
      stringTokens.add(tokenizer.nextToken());
    }

    return stringTokens.toArray(new String[0]);
  }

  @BeforeAll
  static void initialise() {
    defaultConfig = new ParameterOptions();
    defaultConfig.setToday();
    defaultConfig.setMensa();
  }

  @Test
  void testEmptyArgumentList() {
    String args = "";
    ParameterParser parameterParser = new ParameterParser(tokenise(args));
    assertEquals(defaultConfig, parameterParser.parse());
  }

  @Test
  void testContentMensa() {
    String args = "mensa";
    ParameterParser parameterParser = new ParameterParser(tokenise(args));
    ParameterOptions result = parameterParser.parse();
    assertTrue(result.hasMensa());
  }

  @Test
  void testContentForschungszentrum() {
    String args = "bistro";
    ParameterParser parameterParser = new ParameterParser(tokenise(args));
    ParameterOptions result = parameterParser.parse();
    assertTrue(result.hasBistro());
  }

  @Test
  void testContentTod() {
    String args = "tod";
    ParameterParser parameterParser = new ParameterParser(tokenise(args));
    ParameterOptions result = parameterParser.parse();
    assertTrue(result.hasToday());
  }

  @Test
  void testContentToday() {
    String args = "today";
    ParameterParser parameterParser = new ParameterParser(tokenise(args));
    ParameterOptions result = parameterParser.parse();
    assertTrue(result.hasToday());
  }

  @Test
  void testContentTom() {
    String args = "tom";
    ParameterParser parameterParser = new ParameterParser(tokenise(args));
    ParameterOptions result = parameterParser.parse();
    assertTrue(result.hasTomorrow());
  }

  @Test
  void testContentTomorrow() {
    String args = "tomorrow";
    ParameterParser parameterParser = new ParameterParser(tokenise(args));
    ParameterOptions result = parameterParser.parse();
    assertTrue(result.hasTomorrow());
  }

  @Test
  void testContentV() {
    String args = "v";
    ParameterParser parameterParser = new ParameterParser(tokenise(args));
    ParameterOptions result = parameterParser.parse();
    assertTrue(result.hasVegetarianOnly());
  }

  @Test
  void testContentVegi() {
    String args = "vegi";
    ParameterParser parameterParser = new ParameterParser(tokenise(args));
    ParameterOptions result = parameterParser.parse();
    assertTrue(result.hasVegetarianOnly());
  }

  @Test
  void testContentVegetarian() {
    String args = "vegetarian";
    ParameterParser parameterParser = new ParameterParser(tokenise(args));
    ParameterOptions result = parameterParser.parse();
    assertTrue(result.hasVegetarianOnly());
  }

  @Test
  void testLotsOfBlanks() {
    String args = " mo tu we th all      vegi ";
    ParameterParser parameterParser = new ParameterParser(tokenise(args));
    ParameterOptions result = parameterParser.parse();
    ParameterOptions expected = new ParameterOptions();
    expected.setMensa();
    expected.setMonday();
    expected.setTuesday();
    expected.setWednesday();
    expected.setThursday();
    expected.setFriday();
    expected.setSaturday();
    expected.setVegetarianOnly();
    assertEquals(expected, result);
  }

  @Test
  void testAllVegi() {
    String args = "all vegi";
    ParameterParser parameterParser = new ParameterParser(tokenise(args));
    ParameterOptions result = parameterParser.parse();
    ParameterOptions expected = new ParameterOptions();
    expected.setMensa();
    expected.setMonday();
    expected.setTuesday();
    expected.setWednesday();
    expected.setThursday();
    expected.setFriday();
    expected.setSaturday();
    expected.setVegetarianOnly();
    assertEquals(expected, result);
  }

  @Test
  void testContentMon() {
    String args = "mon";
    ParameterParser parameterParser = new ParameterParser(tokenise(args));
    ParameterOptions result = parameterParser.parse();
    assertTrue(result.hasMonday());
  }

  @Test
  void testContentTue() {
    String args = "tue";
    ParameterParser parameterParser = new ParameterParser(tokenise(args));
    ParameterOptions result = parameterParser.parse();
    assertTrue(result.hasTuesday());
  }

  @Test
  void testContentWed() {
    String args = "wed";
    ParameterParser parameterParser = new ParameterParser(tokenise(args));
    ParameterOptions result = parameterParser.parse();
    assertTrue(result.hasWednesday());
  }

  @Test
  void testContentThu() {
    String args = "thu";
    ParameterParser parameterParser = new ParameterParser(tokenise(args));
    ParameterOptions result = parameterParser.parse();
    assertTrue(result.hasThursday());
  }

  @Test
  void testContentFri() {
    String args = "fri";
    ParameterParser parameterParser = new ParameterParser(tokenise(args));
    ParameterOptions result = parameterParser.parse();
    assertTrue(result.hasFriday());
  }

  @Test
  void testContentSat() {
    String args = "sat";
    ParameterParser parameterParser = new ParameterParser(tokenise(args));
    ParameterOptions result = parameterParser.parse();
    assertTrue(result.hasSaturday());
  }

  @Test
  void testContentHelp() {
    String args = "help";
    ParameterParser parameterParser = new ParameterParser(tokenise(args));
    ParameterOptions result = parameterParser.parse();
    assertTrue(result.hasHelp());
  }

  @Test
  void testInvalidArgument1() {
    String args = "foo";
    ParameterParser parameterParser = new ParameterParser(tokenise(args));
    assertThrows(IllegalArgumentException.class, parameterParser::parse);
  }
}