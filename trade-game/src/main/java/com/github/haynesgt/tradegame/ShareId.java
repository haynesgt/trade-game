import lombok.Data;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class ShareId {
  private final Account account;
  private final Stock stock;
}
