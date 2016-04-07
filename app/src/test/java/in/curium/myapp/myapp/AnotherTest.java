package in.curium.myapp.myapp;

import java.util.Calendar;
import java.util.TimeZone;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AnotherTest {

  private Calendar calendar;

  @Before
  public void init() {
    calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
  }

  @Test
  public void testMyTime() {
    System.out.println("time = " + System.currentTimeMillis());
    assertEquals(5, 5);
    assertEquals("UTC", calendar.getTimeZone().getID());
  }
}
