package in.curium.myapp.myapp.utils;

import android.text.InputFilter;
import android.text.Spanned;
import android.util.Log;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TwoDecimalPointAccuracyInputFilter implements InputFilter {

  private final String TAG = TwoDecimalPointAccuracyInputFilter.class.getCanonicalName();

  private Pattern mPattern;

  public TwoDecimalPointAccuracyInputFilter() {
    mPattern = Pattern.compile("\\d+(\\.\\d{1,2})?|\\.(\\d{1,2})?");
  }

  private void debugLog(String message) {
    Log.d(TAG, message);
  }

  @Override
  public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart,
      int dend) {
    debugLog("source = "
        + source
        + ", start = "
        + start
        + ", end = "
        + end
        + ", dest = "
        + dest
        + ", dstart = "
        + dstart
        + ", dend = "
        + dend);
    String resultantString = "";
    // something was deleted
    String split1 = dest.toString().substring(0, dstart);
    String split2 = dest.toString().substring(dend, dest.length());
    debugLog("split1, split2 = " + split1 + ", " + split2);
    if (source.length() == 0) {
      resultantString = split1 + split2;
    } else {
      // something was added
      String whatWasAdded = source.toString().substring(start, end);
      debugLog("whatWasAdded = " + whatWasAdded);
      resultantString = split1 + whatWasAdded + split2;
    }
    if (resultantString.endsWith(".")) {
      // handle the ending dot
      resultantString = resultantString.substring(0, resultantString.length() - 1);
    }
    debugLog("resultantString = " + resultantString);
    Matcher matcher = mPattern.matcher(resultantString);
    if (!matcher.matches()) {
      debugLog("returning empty string to reject " + resultantString);
      return "";
    } else {
      debugLog("returning null to accept " + resultantString);
      return null;
    }
  }
}