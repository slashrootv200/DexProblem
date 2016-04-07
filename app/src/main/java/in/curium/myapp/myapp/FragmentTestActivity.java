package in.curium.myapp.myapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import in.curium.myapp.myapp.fragments.F1;

public class FragmentTestActivity extends AppCompatActivity {
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_fragment_test);
    addFragmentWithoutBackStack(new F1(), "F1");
  }

  public void addFragment(Fragment f, String tag) {
    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
    ft.add(R.id.simple_fragment_container, f, tag);
    ft.addToBackStack(null);
    ft.commit();
  }

  public void addFragmentWithoutBackStack(Fragment f, String tag) {
    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
    ft.add(R.id.simple_fragment_container, f, tag);
    ft.commit();
  }
}
