package in.curium.myapp.myapp;

public abstract class MyThread extends Thread {

  public abstract void onDataProcessed(String processedData);

  private String unprocessedData = null;

  /** initialize the unprocessedData in constructor */
  public MyThread(String unprocessedData) {
    this.unprocessedData = unprocessedData;
  }

  @Override
  public void run() {
    String processedData = "asdasdsad";

    if (unprocessedData != null) {
      // do some processing and set processedData
    }

    /** send the callback */
    onDataProcessed(processedData);
  }

}
