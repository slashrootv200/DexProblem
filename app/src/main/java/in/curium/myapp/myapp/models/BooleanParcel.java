package in.curium.myapp.myapp.models;

import android.os.Parcel;
import android.os.Parcelable;

public class BooleanParcel implements Parcelable {
  public final Boolean aBoolean;

  public BooleanParcel(Boolean aBoolean) {
    this.aBoolean = aBoolean;
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeValue(this.aBoolean);
  }

  protected BooleanParcel(Parcel in) {
    this.aBoolean = (Boolean) in.readValue(Boolean.class.getClassLoader());
  }

  public static final Creator<BooleanParcel> CREATOR = new Creator<BooleanParcel>() {
    @Override
    public BooleanParcel createFromParcel(Parcel source) {
      return new BooleanParcel(source);
    }

    @Override
    public BooleanParcel[] newArray(int size) {
      return new BooleanParcel[size];
    }
  };
}
