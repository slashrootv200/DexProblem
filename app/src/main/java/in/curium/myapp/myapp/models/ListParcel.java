package in.curium.myapp.myapp.models;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

public class ListParcel implements Parcelable {
  public final List<Apple> appleList;

  public ListParcel(List<Apple> appleList) {
    this.appleList = appleList;
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeTypedList(appleList);
  }

  protected ListParcel(Parcel in) {
    this.appleList = in.createTypedArrayList(Apple.CREATOR);
  }

  public static final Parcelable.Creator<ListParcel> CREATOR =
      new Parcelable.Creator<ListParcel>() {
        @Override
        public ListParcel createFromParcel(Parcel source) {
          return new ListParcel(source);
        }

        @Override
        public ListParcel[] newArray(int size) {
          return new ListParcel[size];
        }
      };
}
