package in.curium.testeverything;

import java.util.regex.Pattern;
import org.junit.Assert;
import org.junit.Test;

public class RegexTest {

  private Pattern getPattern(int digitsBeforeZero, int digitsAfterZero) {
    return Pattern.compile("[0-9]{0,"
        + (digitsBeforeZero - 1)
        + "}+((\\.[0-9]{0,"
        + (digitsAfterZero - 1)
        + "})?)||(\\.)?");
  }

  private boolean match(int digitsBeforeZero, int digitsAfterZero, String number) {
    return getPattern(digitsBeforeZero, digitsAfterZero).matcher(number).matches();
  }

  @Test
  public void testRegex() {
    Assert.assertFalse(match(2, 2, "as23.441"));
  }
}