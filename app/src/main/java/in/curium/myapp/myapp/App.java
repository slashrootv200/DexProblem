package in.curium.myapp.myapp;

import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;
import android.util.Log;

public class App extends MultiDexApplication {
  private final String TAG = App.class.getCanonicalName();
  @Override
  public void onCreate() {
    super.onCreate();
    Log.d(TAG, "in App.onCreate()");
    System.out.println("in App.onCreate()");
  }

  @Override
  protected void attachBaseContext(Context base) {
    super.attachBaseContext(base);
    MultiDex.install(this);
  }
}
