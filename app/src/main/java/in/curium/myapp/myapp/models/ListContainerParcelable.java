package in.curium.myapp.myapp.models;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

public class ListContainerParcelable implements Parcelable {


  public static final Creator<ListContainerParcelable> CREATOR =
      new Creator<ListContainerParcelable>() {
        @Override
        public ListContainerParcelable createFromParcel(Parcel source) {
          return new ListContainerParcelable(source);
        }

        @Override
        public ListContainerParcelable[] newArray(int size) {
          return new ListContainerParcelable[size];
        }
      };
  private final List<TestParcelableItem> items;

  public ListContainerParcelable(List<TestParcelableItem> items) {
    this.items = items;
  }

  protected ListContainerParcelable(Parcel in) {
    this.items = in.createTypedArrayList(TestParcelableItem.CREATOR);
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeTypedList(items);
  }
}
