package in.curium.myapp.myapp.models;

public interface IRepo {
  long getId();

  String getName();

  String getFullName();

  boolean getPrivate();

  String getGitUrl();
}
