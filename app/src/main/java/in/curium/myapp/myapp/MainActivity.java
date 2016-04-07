package in.curium.myapp.myapp;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.InputFilter;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import in.curium.myapp.myapp.models.Apple;
import in.curium.myapp.myapp.models.BooleanParcel;
import in.curium.myapp.myapp.models.ListParcel;
import in.curium.myapp.myapp.models.Person;
import in.curium.myapp.myapp.utils.TwoDecimalPointAccuracyInputFilter;
import in.curium.myapp.myapp.widget.ErrorStateSpinner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

  private TextView tv;
  private ErrorStateSpinner errorStateSpinner;
  private static final String TAG = MainActivity.class.getCanonicalName();

  public void changeColor(View v) {
    errorStateSpinner.setError();
    List<String> addresses = new ArrayList<>(2);
    addresses.add("L-74-B, L-Block, Saket, New Delhi 110017");
    addresses.add("B-134, Sector 6, Noida, UP 201301");
    Map<Person, Integer> likes = new HashMap<>();
    Person person = Person.create("Pratap", addresses, 15);
    Log.d(TAG, "person = " + person);
    Intent intent = new Intent(this, PersonActivity.class);
    intent.putExtra(PersonActivity.PERSON_EXTRA, person);
    intent.putExtra(PersonActivity.BOOLEAN_EXTRA, new BooleanParcel(null));
    ArrayList<Person> persons = new ArrayList<>();
    persons.add(person);
    intent.putParcelableArrayListExtra(PersonActivity.PERSONS_EXTRA, persons);

    Apple apple1 = new Apple(5, 10, 15);
    Apple apple2 = new Apple(50, 100, 150);

    LinkedList<Apple> appleHashSet = new LinkedList<>();

    appleHashSet.add(apple1);
    appleHashSet.add(apple2);

    ListParcel listParcel = new ListParcel(appleHashSet);
    intent.putExtra(PersonActivity.APPLES_LIST_EXTRA, listParcel);
    startActivity(intent);
  }

  private void setBackgroundDrawable(int drawableId, View v) {
    if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
      v.setBackground(ContextCompat.getDrawable(this, drawableId));
    } else {
      v.setBackgroundDrawable(ContextCompat.getDrawable(this, drawableId));
    }
  }

  @Bind(R.id.two_decimal)
  EditText twoDecimalEt;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
    tv = (TextView) findViewById(R.id.id1);
    mythread.start();
    errorStateSpinner = (ErrorStateSpinner) findViewById(R.id.err_spin);
    twoDecimalEt.setFilters(new InputFilter[] { new TwoDecimalPointAccuracyInputFilter() });
  }

  MyThread mythread = new MyThread("testing string") {

    @Override
    public void onDataProcessed(String processedData) {
      System.out.println("Thread = " + Thread.currentThread().getName());
      tv.setText(processedData);
    }
  };

  public void openFragmentTestActivity(View view) {
    startActivity(new Intent(this, FragmentTestActivity.class));
  }
}
