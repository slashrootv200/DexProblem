package in.curium.myapp.myapp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import in.curium.myapp.myapp.FragmentTestActivity;
import in.curium.myapp.myapp.R;

public abstract class BaseFragment extends Fragment {

  @Bind(R.id.simple_fragment_btn)
  Button mSimpleBtn;

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.simple_fragment_layout, container, false);
    ButterKnife.bind(this, view);
    return view;
  }

  @Override
  public void onDestroyView() {
    super.onDestroyView();
    mSimpleBtn = null;
  }

  protected Button getSimpleBtn() {
    return mSimpleBtn;
  }

  protected void setTextOnSimpleBtn(String simpleText) {
    mSimpleBtn.setText(simpleText);
  }

  protected void addFragment(Fragment f, String tag) {
    ((FragmentTestActivity) getActivity()).addFragment(f, tag);
  }

  abstract Fragment getNextFragment();

  abstract String getNextTag();

  @OnClick(R.id.simple_fragment_btn)
  public void onSimpleBtnClicked(View v) {
    if (this instanceof F3) {
      FragmentManager fm = getActivity().getSupportFragmentManager();
      for (int i = 0; i < fm.getBackStackEntryCount(); ++i) {
        fm.popBackStack();
      }
    } else {
      Fragment f = getNextFragment();
      if (f != null) {
        addFragment(f, getNextTag());
      }
    }
  }
}
