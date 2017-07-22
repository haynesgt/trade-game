import lombok.Data;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class User {
  private final String username;
  private String password;
  private final Account account;

  public boolean equals(User o) {
    if (o == null) {
      return false;
    }
    if (this == o) {
      return true;
    }
    return this.username.equals(o.username);
  }

  public int hashCode() {
    return username.hashCode();
  }
}
