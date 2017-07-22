import lombok.Data;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.HashMap;

@Repository
public class ShareRepository extends HashMap<ShareId, Share> {
}
