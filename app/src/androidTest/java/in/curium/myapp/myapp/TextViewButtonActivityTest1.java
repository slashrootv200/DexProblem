package in.curium.myapp.myapp;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import com.android.test.runner.MultiDexTestRunner;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
@RunWith(AndroidJUnit4.class)

public class TextViewButtonActivityTest1 extends MultiDexTestRunner {

  @Rule
  public ActivityTestRule mActivityRule = new ActivityTestRule<>(TextViewButtonActivity.class);

  //@Override
  //public void onCreate(Bundle arguments) {
  //  MultiDex.install(getTargetContext());
  //  super.onCreate(arguments);
  //}

  @Test
  public void textTest1() {
    onView(withText("Button")).perform(click());
  }
}
