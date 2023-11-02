package storage;


public enum Users {

  STANDART_USER("standard_user"),
  LOCKED_OUT_USER("locked_out_user"),
  PROBLEM_USER("problem_user"),
  PERFORMANCE_GLITCH_USER("performance_glitch_user");


  public final String abbr;

  Users(String abbr) {
    this.abbr = abbr;
  }

  public static Users findByAbbr(String abbr) {
    for (Users v : values()) {
      if (v.abbr.equals(abbr)) {
        return v;
      }
    }
    throw new RuntimeException("Нет такого юзера");
  }
}
