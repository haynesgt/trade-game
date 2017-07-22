import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GameController {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private StockService stockService;

  @GetMapping(value = "/")
  @ResponseBody
  public String getHome() {
    return "home";
  }

  @PostMapping(value = "/users")
  @ResponseBody
  public void createUser(
      String username,
      String password
  ) {
    Account account = new Account(username);
    User user = new User(username, account);
    user.setPassword(password);
    userRepository.put(username, user);
  }

  @GetMapping(value = "/users/{username}")
  @ResponseBody
  public User getUser(
    @PathVariable String username
  ) {
    return userRepository.get(username);
  }

  @PostMapping
  @ResponseBody
  public void stepGame() {
    stockService.distributeYield();
  }

}
