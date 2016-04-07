package in.curium.myapp.myapp.models;

import android.os.Parcelable;
import com.google.auto.value.AutoValue;
import in.curium.myapp.myapp.autogson.AutoGson;
import java.util.List;

@AutoValue
@AutoGson
public abstract class Person implements Parcelable, IPerson {
  abstract public String name();
  abstract public List<String> addresses();
  abstract public int likes();

  static public Person create(String name, List<String> addresses, int likes) {
    return new AutoValue_Person(name, addresses, likes);
  }

  @Override
  public String getName() {
    return name();
  }

  @Override
  public List<String> getAddresses() {
    return addresses();
  }

  @Override
  public int getLikes() {
    return likes();
  }
}
