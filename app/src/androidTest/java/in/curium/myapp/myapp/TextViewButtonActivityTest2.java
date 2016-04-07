package in.curium.myapp.myapp;

import android.support.test.filters.LargeTest;
import android.test.ActivityInstrumentationTestCase2;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@LargeTest
public class TextViewButtonActivityTest2
    extends ActivityInstrumentationTestCase2<TextViewButtonActivity> {
  private TextViewButtonActivity activity;

  public TextViewButtonActivityTest2() {
    super(TextViewButtonActivity.class);
  }

  public void setUp() throws
      Exception {
    super.setUp();
    try {
      activity = getActivity();
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("ex1");
    }
  }

  public void testActivityExists() throws
      Exception {
    try {
      assertNotNull(activity);
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("ex2");
    }
  }

  public void testButtonClick() throws
      Exception {
    try {
      onView(withText("Button")).perform(click());
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("ex3");
    }
  }
}
