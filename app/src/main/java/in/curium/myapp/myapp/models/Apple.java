package in.curium.myapp.myapp.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Apple implements Parcelable {
  public final int iPads;
  public final int iPhones;
  public final int iMacs;

  public Apple(int iPads, int iPhones, int iMacs) {
    this.iPads = iPads;
    this.iPhones = iPhones;
    this.iMacs = iMacs;
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeInt(this.iPads);
    dest.writeInt(this.iPhones);
    dest.writeInt(this.iMacs);
  }

  protected Apple(Parcel in) {
    this.iPads = in.readInt();
    this.iPhones = in.readInt();
    this.iMacs = in.readInt();
  }

  public static final Parcelable.Creator<Apple> CREATOR = new Parcelable.Creator<Apple>() {
    @Override
    public Apple createFromParcel(Parcel source) {
      return new Apple(source);
    }

    @Override
    public Apple[] newArray(int size) {
      return new Apple[size];
    }
  };
}
