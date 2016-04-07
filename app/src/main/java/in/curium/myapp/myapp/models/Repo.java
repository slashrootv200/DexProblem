package in.curium.myapp.myapp.models;

import android.os.Parcelable;
import com.google.auto.value.AutoValue;
import in.curium.myapp.myapp.autogson.AutoGson;

@AutoGson
@AutoValue
public abstract class Repo implements Parcelable, IRepo {

  static public Repo create(long id, String name, String full_name, boolean mPrivate,
      String git_url) {
    return new AutoValue_Repo(id, name, full_name, mPrivate, git_url);
  }

  public abstract long id();

  public abstract String name();

  public abstract String full_name();

  public abstract boolean mPrivate();

  public abstract String git_url();

  @Override
  public long getId() {
    return id();
  }

  @Override
  public String getName() {
    return name();
  }

  @Override
  public String getFullName() {
    return full_name();
  }

  @Override
  public boolean getPrivate() {
    return mPrivate();
  }

  @Override
  public String getGitUrl() {
    return git_url();
  }
}
