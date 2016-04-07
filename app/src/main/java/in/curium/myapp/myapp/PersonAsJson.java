package in.curium.myapp.myapp;

public class PersonAsJson {

  static public String getPersonAsJsonString() {
    return "{\n"
        + "  \"addresses\": [\n"
        + "    \"101, Sankalp Apt., I-Block, Gwalior - 474002\",\n"
        + "    \"A-34, Sector 60, IEnergizer Inc, Noida - 201301\"\n"
        + "  ],\n"
        + "  \"likes\": 235,\n"
        + "  \"name\": \"Patil\"\n"
        + "}";
  }
}
