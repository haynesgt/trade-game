import lombok.Data;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class Share {
  private final ShareId shareId;
  private double amount;

  public boolean equals(Share o) {
    if (o == null) {
      return false;
    }
    if (this == o) {
      return true;
    }
    return this.shareId.equals(o.shareId);
  }

  public int hashCode() {
    return shareId.hashCode();
  }
}

