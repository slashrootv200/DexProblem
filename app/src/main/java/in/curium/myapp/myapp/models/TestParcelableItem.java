package in.curium.myapp.myapp.models;

import android.os.Parcel;
import android.os.Parcelable;

public class TestParcelableItem implements Parcelable {
  public static final Creator<TestParcelableItem> CREATOR = new Creator<TestParcelableItem>() {
    @Override
    public TestParcelableItem createFromParcel(Parcel source) {
      return new TestParcelableItem(source);
    }

    @Override
    public TestParcelableItem[] newArray(int size) {
      return new TestParcelableItem[size];
    }
  };
  private String testString;
  private int testInt;

  public TestParcelableItem() {
  }

  protected TestParcelableItem(Parcel in) {
    this.testString = in.readString();
    this.testInt = in.readInt();
  }

  public String getTestString() {
    return testString;
  }

  public void setTestString(String testString) {
    this.testString = testString;
  }

  public int getTestInt() {
    return testInt;
  }

  public void setTestInt(int testInt) {
    this.testInt = testInt;
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(this.testString);
    dest.writeInt(this.testInt);
  }
}
