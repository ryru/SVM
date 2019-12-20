package ch.addere;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.SortedSet;
import java.util.TreeSet;
import org.junit.jupiter.api.Test;

class WeekDateTest {

  @Test
  public void testIllegalDay0() {
    assertThrows(IllegalArgumentException.class, () -> new WeekDate(0, 2));
  }

  @Test
  public void testIllegalDay32() {
    assertThrows(IllegalArgumentException.class, () -> new WeekDate(32, 2));
  }

  @Test
  public void testValidDay1() {
    WeekDate weekDate = new WeekDate(1, 2);
    assertEquals(1, weekDate.getDay());
  }

  @Test
  public void testValidDay31() {
    WeekDate weekDate = new WeekDate(31, 2);
    assertEquals(31, weekDate.getDay());
  }

  @Test
  public void testIllegalMonth0() {
    assertThrows(IllegalArgumentException.class, () -> new WeekDate(1, 0));
  }

  @Test
  public void testIllegalMonth13() {
    assertThrows(IllegalArgumentException.class, () -> new WeekDate(2, 13));
  }

  @Test
  public void testValidMonth1() {
    WeekDate weekDate = new WeekDate(1, 1);
    assertEquals(1, weekDate.getMonth());
  }

  @Test
  public void testValidMonth12() {
    WeekDate weekDate = new WeekDate(1, 12);
    assertEquals(12, weekDate.getMonth());
  }

  @Test
  public void testCompareTwoEqualDates() {
    WeekDate weekDate1 = new WeekDate(1, 1);
    WeekDate weekDate2 = new WeekDate(1, 1);
    assertEquals(weekDate1, weekDate2);
  }

  @Test
  public void testCompareTwoNonEqualDates1() {
    WeekDate weekDate1 = new WeekDate(1, 1);
    WeekDate weekDate2 = new WeekDate(2, 1);
    assertNotEquals(weekDate1, weekDate2);
  }

  @Test
  public void testCompareTwoNonEqualDates2() {
    WeekDate weekDate1 = new WeekDate(1, 1);
    WeekDate weekDate2 = new WeekDate(1, 2);
    assertNotEquals(weekDate1, weekDate2);
  }

  @Test
  public void testCompareMonth1() {
    WeekDate weekDate1 = new WeekDate(1, 1);
    WeekDate weekDate2 = new WeekDate(1, 2);
    SortedSet<WeekDate> weekDateSet = new TreeSet<>();
    weekDateSet.add(weekDate1);
    weekDateSet.add(weekDate2);
    assertEquals(weekDate1, weekDateSet.toArray()[0]);
    assertEquals(weekDate2, weekDateSet.toArray()[1]);
  }

  @Test
  public void testCompareMonth2() {
    WeekDate weekDate1 = new WeekDate(1, 1);
    WeekDate weekDate2 = new WeekDate(1, 2);
    SortedSet<WeekDate> weekDateSet = new TreeSet<>();
    weekDateSet.add(weekDate2);
    weekDateSet.add(weekDate1);
    assertEquals(weekDate1, weekDateSet.toArray()[0]);
    assertEquals(weekDate2, weekDateSet.toArray()[1]);
  }

  @Test
  public void testCompareDay1() {
    WeekDate weekDate1 = new WeekDate(1, 1);
    WeekDate weekDate2 = new WeekDate(2, 1);
    SortedSet<WeekDate> weekDateSet = new TreeSet<>();
    weekDateSet.add(weekDate1);
    weekDateSet.add(weekDate2);
    assertEquals(weekDate1, weekDateSet.toArray()[0]);
    assertEquals(weekDate2, weekDateSet.toArray()[1]);
  }

  @Test
  public void testCompareDay2() {
    WeekDate weekDate1 = new WeekDate(1, 1);
    WeekDate weekDate2 = new WeekDate(2, 1);
    SortedSet<WeekDate> weekDateSet = new TreeSet<>();
    weekDateSet.add(weekDate2);
    weekDateSet.add(weekDate1);
    assertEquals(weekDate1, weekDateSet.toArray()[0]);
    assertEquals(weekDate2, weekDateSet.toArray()[1]);
  }

  @Test
  public void testCompareTwoDates1() {
    WeekDate weekDate1 = new WeekDate(7, 1);
    WeekDate weekDate2 = new WeekDate(2, 4);
    SortedSet<WeekDate> weekDateSet = new TreeSet<>();
    weekDateSet.add(weekDate2);
    weekDateSet.add(weekDate1);
    assertEquals(weekDate1, weekDateSet.toArray()[0]);
    assertEquals(weekDate2, weekDateSet.toArray()[1]);
  }

}