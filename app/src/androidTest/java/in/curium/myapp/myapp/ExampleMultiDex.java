package in.curium.myapp.myapp;

import android.content.Context;
import android.test.InstrumentationTestCase;

public class ExampleMultiDex extends InstrumentationTestCase {

  public void testMe() {
    Context context = getInstrumentation().getContext();
    System.out.println("context = " + context);
    assertTrue(true);
  }
}
