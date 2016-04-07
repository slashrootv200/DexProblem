package in.curium.myapp.myapp;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class TextViewButtonActivityTest {

  @Rule
  public ActivityTestRule mActivityRule = new ActivityTestRule<>(TextViewButtonActivity.class);

  @Test
  public void testButton() {
    onView(withText("Button")).perform(click());
  }
}