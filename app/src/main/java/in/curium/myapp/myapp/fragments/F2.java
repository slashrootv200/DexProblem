package in.curium.myapp.myapp.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

public class F2 extends BaseFragment {
  @Override
  public void onViewCreated(View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    setTextOnSimpleBtn("F2");
  }

  @Override
  Fragment getNextFragment() {
    return new F3();
  }

  @Override
  String getNextTag() {
    return "F3";
  }
}
