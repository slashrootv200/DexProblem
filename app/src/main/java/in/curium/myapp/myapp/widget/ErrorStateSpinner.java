package in.curium.myapp.myapp.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.Spinner;
import android.widget.TextView;
import in.curium.myapp.myapp.R;

public class ErrorStateSpinner extends FrameLayout implements View.OnTouchListener {

  private final String TAG = ErrorStateSpinner.class.getCanonicalName();

  private FrameLayout errorStateSpinnerFrameLayoutContainer;
  private Spinner errorStateSpinner;

  public ErrorStateSpinner(Context context, AttributeSet attrs) {
    super(context, attrs);
    init(attrs);
  }

  public ErrorStateSpinner(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init(attrs);
  }

  @TargetApi(Build.VERSION_CODES.LOLLIPOP)
  public ErrorStateSpinner(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
    super(context, attrs, defStyleAttr, defStyleRes);
    init(attrs);
  }

  protected void setSpinnerTextColor(int color) {
    debugLog("entering setSpinnerTextColor with color = " + color);
    View child = errorStateSpinner.getChildAt(0);
    debugLog("child = " + child);
    if (child != null && child instanceof TextView) {
      debugLog("setting color");
      ((TextView) child).setTextColor(color);
    } else {
      debugLog("not setting color");
    }
    debugLog("exiting setSpinnerTextColor");
  }

  public void setStringArrayResource(int stringArrayResource) {
    debugLog("entering setStringArrayResource");
    setAdapterOnSpinner(stringArrayResource);
    debugLog("exiting setStringArrayResource");
  }

  public void setStringArray(String[] stringArray) {
    debugLog("entering setStringArrayResource");
    setAdapterOnSpinner(stringArray);
    debugLog("exiting setStringArrayResource");
  }

  public void setError() {
    debugLog("entering setError");
    setSpinnerTextColor(ContextCompat.getColor(getContext(), android.R.color.holo_red_dark));
    errorStateSpinnerFrameLayoutContainer.setBackground(
        ContextCompat.getDrawable(getContext(), R.drawable.red_rectangle_shape));
    debugLog("exiting setError");
  }

  protected void init(AttributeSet attrs) {
    debugLog("entering init");
    TypedArray typedArray =
        getContext().getTheme().obtainStyledAttributes(attrs, R.styleable.ErrorStateSpinner, 0, 0);
    int stringArrayResource;
    try {
      stringArrayResource = typedArray.getResourceId(R.styleable.ErrorStateSpinner_stringArray, 0);
    } finally {
      debugLog("recycling TypedArray");
      typedArray.recycle();
    }
    View view = inflate(getContext(), R.layout.error_state_spinner_view, null);
    errorStateSpinnerFrameLayoutContainer =
        (FrameLayout) view.findViewById(R.id.error_state_spinner_container);

    errorStateSpinnerFrameLayoutContainer.setBackgroundColor(
        ContextCompat.getColor(getContext(), android.R.color.white));
    errorStateSpinner = (Spinner) view.findViewById(R.id.error_state_spinner);
    setAdapterOnSpinner(stringArrayResource);
    setSpinnerTextColor(ContextCompat.getColor(getContext(), android.R.color.black));
    errorStateSpinner.setOnTouchListener(this);
    addView(view);
    debugLog("exiting init");
  }

  public int getSelectedItemPosition() {
    debugLog("entering getSelectedItem");
    int selectedItemPosition = -1;
    if (errorStateSpinner != null) {
      debugLog("errorStateSpinner != null");
      selectedItemPosition = errorStateSpinner.getSelectedItemPosition();
    }
    debugLog("exiting getSelectedItem; returning object = " + selectedItemPosition);
    return selectedItemPosition;
  }

  public long getSelectedItemId() {
    debugLog("entering getSelectedItem");
    long selectedItemId = -1L;
    if (errorStateSpinner != null) {
      debugLog("errorStateSpinner != null");
      selectedItemId = errorStateSpinner.getSelectedItemId();
    }
    debugLog("exiting getSelectedItem; returning object = " + selectedItemId);
    return selectedItemId;
  }

  public Object getSelectedItem() {
    debugLog("entering getSelectedItem");
    Object object = null;
    if (errorStateSpinner != null) {
      object = errorStateSpinner.getSelectedItem();
    }
    debugLog("exiting getSelectedItem; returning object = " + object);
    return object;
  }

  protected void setAdapterOnSpinner(int stringArrayResource) {
    debugLog("entering setAdapterOnSpinner");
    if (stringArrayResource != 0) {
      debugLog("stringArrayResource != 0");
      ArrayAdapter arrayAdapter = ArrayAdapter.createFromResource(getContext(), stringArrayResource,
          android.R.layout.simple_list_item_1);
      errorStateSpinner.setAdapter(arrayAdapter);
    } else {
      debugLog("stringArrayResource == 0");
    }
    debugLog("exiting setAdapterOnSpinner");
  }

  protected void setAdapterOnSpinner(String[] stringArray) {
    debugLog("entering setAdapterOnSpinner");
    if (stringArray != null) {
      debugLog("stringArrayResource != 0");
      ArrayAdapter<String> arrayAdapter =
          new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, stringArray);
      errorStateSpinner.setAdapter(arrayAdapter);
    } else {
      debugLog("stringArrayResource == 0");
    }
    debugLog("exiting setAdapterOnSpinner");
  }

  private final void debugLog(String message) {
    if (!isInEditMode()) Log.d(TAG, message);
  }

  @Override
  public boolean onTouch(View v, MotionEvent event) {
    if (v.getId() == R.id.error_state_spinner) {
      setSpinnerTextColor(ContextCompat.getColor(getContext(), android.R.color.black));
      errorStateSpinnerFrameLayoutContainer.setBackgroundColor(
          ContextCompat.getColor(getContext(), android.R.color.white));
    }
    return false;
  }
}