package in.curium.myapp.myapp.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

public class F1 extends BaseFragment {
  @Override
  public void onViewCreated(View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    setTextOnSimpleBtn("F1");
  }

  @Override
  Fragment getNextFragment() {
    return new F2();
  }

  @Override
  String getNextTag() {
    return "F2";
  }
}
