package pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

  @JsonProperty("name")
  private Name fullName;
  private Location location;


  @Getter
  @Setter
  @JsonIgnoreProperties(ignoreUnknown = true)
  private static class Name {
    @JsonProperty("first")
    private String firstName;
    @JsonProperty("last")
    private String lastName;

    @Override
    public String toString() {
      return firstName + " " + lastName;
    }
  }
  @Getter
  @Setter
  @JsonIgnoreProperties(ignoreUnknown = true)
  private static class Location {
    @JsonProperty("postcode")
    private String postCode;
  }
}
