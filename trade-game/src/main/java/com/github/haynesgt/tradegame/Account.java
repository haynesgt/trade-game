import lombok.Data;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Collection;

@Data
public class Account {
  private final String id;
  private Collection<Share> shares;
  private double balance;

  public boolean equals(Account o) {
    if (o == null) {
      return false;
    }
    if (this == o) {
      return true;
    }
    return id.equals(o.id);
  }
}
