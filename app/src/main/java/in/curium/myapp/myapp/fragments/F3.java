package in.curium.myapp.myapp.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

public class F3 extends BaseFragment {
  @Override
  public void onViewCreated(View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    setTextOnSimpleBtn("F3");
  }

  @Override
  Fragment getNextFragment() {
    return null;
  }

  @Override
  String getNextTag() {
    return null;
  }
}
