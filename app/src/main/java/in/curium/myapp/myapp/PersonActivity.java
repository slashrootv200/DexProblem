package in.curium.myapp.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import in.curium.myapp.myapp.autogson.AutoValueAdapterFactory;
import in.curium.myapp.myapp.models.BooleanParcel;
import in.curium.myapp.myapp.models.IPerson;
import in.curium.myapp.myapp.models.ListParcel;
import in.curium.myapp.myapp.models.Person;
import in.curium.myapp.myapp.models.Repo;
import in.curium.myapp.myapp.network.Caller;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PersonActivity extends AppCompatActivity {

  private Person person;
  private IPerson iPerson;
  private Gson gson;
  private BooleanParcel booleanParcel;
  private ListParcel listParcel;

  public static final String PERSON_EXTRA = "PERSON_EXTRA";
  public static final String PERSONS_EXTRA = "PERSONS_EXTRA";
  public static final String BOOLEAN_EXTRA = "BOOLEAN_EXTRA";
  public static final String APPLES_LIST_EXTRA = "APPLES_LIST_EXTRA";
  public static final String TAG = PersonActivity.class.getCanonicalName();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_person);
    initGson();
    initPersonFromIntent(getIntent());
    Log.d(TAG, "person = " + person);
    Log.d(TAG, "iPerson = " + iPerson);
  }

  private void initGson() {
    gson = new GsonBuilder().registerTypeAdapterFactory(new AutoValueAdapterFactory()).create();
  }

  private void initPersonFromIntent(Intent intent) {
    Parcelable parcelable = intent.getParcelableExtra(PERSON_EXTRA);
    ArrayList<Person> persons = intent.getParcelableArrayListExtra(PERSONS_EXTRA);
    if (parcelable != null) {
      person = (Person) parcelable;
      iPerson = (Person) parcelable;
    }
    booleanParcel = (BooleanParcel) intent.getParcelableExtra(BOOLEAN_EXTRA);
    listParcel = (ListParcel) intent.getParcelableExtra(APPLES_LIST_EXTRA);
  }

  public void onButton1Clicked(View v) {
    Log.d(TAG, "person = " + person);
    Log.d(TAG, "iPerson = " + iPerson);
    Log.d(TAG, "booleanParcel.aBoolean = " + booleanParcel.aBoolean);

    Log.d(TAG, "listParcel.appleList = " + listParcel.appleList);

    String json = gson.toJson(person);
    Log.d(TAG, "json = " + json);

    String jsonPerson = PersonAsJson.getPersonAsJsonString();
    Person person2 = gson.fromJson(jsonPerson, Person.class);

    Log.d(TAG, "person2 = " + person2);

    Caller caller = new Caller(gson);
    caller.getListOfRepos(new Callback<List<Repo>>() {
      @Override
      public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
        List<Repo> list = response.body();
        Log.d(TAG, "repos list = " + list);
      }

      @Override
      public void onFailure(Call<List<Repo>> call, Throwable t) {
        Log.d(TAG, "failure");
        t.printStackTrace();
      }
    });
  }
}
