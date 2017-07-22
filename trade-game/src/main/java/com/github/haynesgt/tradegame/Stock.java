import lombok.Data;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Collection;

@Data
public class Stock {
  private final String name;
  private double yield;
  private double assets;
  private Collection<Share> shares;
  private double amount;
  private double volatility;
}
