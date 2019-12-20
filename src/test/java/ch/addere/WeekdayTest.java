package ch.addere;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class WeekdayTest {


  @Test
  void testEqualDays() {
    Weekday day1 = new Weekday(Weekdays.MONDAY);
    Weekday day2 = new Weekday(Weekdays.MONDAY);
    assertEquals(day1, day2);
  }

  @Test
  void testEqualDates() {
    Weekday day1 = new Weekday(Weekdays.MONDAY, "6.12");
    Weekday day2 = new Weekday(Weekdays.MONDAY, "6.12");
    assertEquals(day1, day2);
  }

  @Test
  void testHashCode() {
    Weekday day1 = new Weekday(Weekdays.MONDAY, "6.12");
    Weekday day2 = new Weekday(Weekdays.MONDAY, "6.12");
    assertEquals(day1.hashCode(), day2.hashCode());
  }

  @Test
  void testToString() {
    Weekday result = new Weekday(Weekdays.MONDAY, "6.12.");
    String expected = "Mo 06.12.";
    assertEquals(expected, result.toString());
  }

  @Test
  void testDayParserMo1() {
    Weekdays expected = Weekdays.MONDAY;
    Weekdays result = Weekday.parseWeekday("mo");
    assertEquals(expected, result);
  }

  @Test
  void testDayParserMo2() {
    Weekdays expected = Weekdays.MONDAY;
    Weekdays result = Weekday.parseWeekday("Mo");
    assertEquals(expected, result);
  }

  @Test
  void testDayParserMo3() {
    Weekdays expected = Weekdays.MONDAY;
    Weekdays result = Weekday.parseWeekday("MO");
    assertEquals(expected, result);
  }

  @Test
  void testDayParserTu() {
    Weekdays expected = Weekdays.TUESDAY;
    Weekdays result = Weekday.parseWeekday("di");
    assertEquals(expected, result);
  }

  @Test
  void testDayParserWe() {
    Weekdays expected = Weekdays.WEDNESDAY;
    Weekdays result = Weekday.parseWeekday("mi");
    assertEquals(expected, result);
  }

  @Test
  void testDayParserTh() {
    Weekdays expected = Weekdays.THURSDAY;
    Weekdays result = Weekday.parseWeekday("do");
    assertEquals(expected, result);
  }

  @Test
  void testDayParserFr() {
    Weekdays expected = Weekdays.FRIDAY;
    Weekdays result = Weekday.parseWeekday("fr");
    assertEquals(expected, result);
  }

  @Test
  void testDayParserSa() {
    Weekdays expected = Weekdays.SATURDAY;
    Weekdays result = Weekday.parseWeekday("sa");
    assertEquals(expected, result);
  }

  @Test
  void testDayParserInvalid1() {
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
        () -> Weekday.parseWeekday(null));

    assertEquals("Invalid day", exception.getMessage());
  }

  @Test
  void testDayParserInvalid2() {
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
        () -> Weekday.parseWeekday(""));

    assertEquals("Invalid day", exception.getMessage());
  }

  @Test
  void testDayParserInvalid3() {
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
        () -> Weekday.parseWeekday("foo"));

    assertEquals("Invalid day", exception.getMessage());
  }

  @Test
  void testDayParserInvalid4() {
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
        () -> Weekday.parseWeekday("fo"));

    assertEquals("Invalid day: fo", exception.getMessage());
  }

  @Test
  void testGetDayMo() {
    String result = new Weekday(Weekdays.MONDAY).getDay();
    String expected = "Mo";
    assertEquals(expected, result);
  }

  @Test
  void testGetDayTu() {
    String result = new Weekday(Weekdays.TUESDAY).getDay();
    String expected = "Tu";
    assertEquals(expected, result);
  }

  @Test
  void testGetDayWe() {
    String result = new Weekday(Weekdays.WEDNESDAY).getDay();
    String expected = "We";
    assertEquals(expected, result);
  }

  @Test
  void testGetDayTh() {
    String result = new Weekday(Weekdays.THURSDAY).getDay();
    String expected = "Th";
    assertEquals(expected, result);
  }

  @Test
  void testGetDayFr() {
    String result = new Weekday(Weekdays.FRIDAY).getDay();
    String expected = "Fr";
    assertEquals(expected, result);
  }

  @Test
  void testGetDaySa() {
    String result = new Weekday(Weekdays.SATURDAY).getDay();
    String expected = "Sa";
    assertEquals(expected, result);
  }
}