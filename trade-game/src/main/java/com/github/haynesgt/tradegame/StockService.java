import lombok.Data;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class StockService {

  @Autowired
  private ShareRepository shareRepository;

  @Autowired
  private StockRepository stockRepository;

  public void buyShares(
      Account account,
      Stock stock,
      double amount
  ) {
    if (account.getBalance() > amount) {
      ShareId shareId = new ShareId(account, stock);
      Share share = shareRepository.get(shareId);
      if (share == null) {
        share = new Share(shareId);
        stock.getShares().add(share);
      }
      share.setAmount(share.getAmount() + amount);
      stock.setAmount(stock.getAmount() + amount);

      account.setBalance(account.getBalance() - amount);
      account.getShares().add(share);
    }
  }

  public double sellShares(
      Account account,
      Stock stock,
      double maximumAmount
  ) {
    ShareId shareId = new ShareId(account, stock);
    Share share = shareRepository.get(shareId);
    if (share != null) {
      if (share.getAmount() < maximumAmount) {
        maximumAmount = share.getAmount();
      }
      account.setBalance(account.getBalance() + maximumAmount);
      share.setAmount(share.getAmount() - maximumAmount);
      stock.setAmount(stock.getAmount() - maximumAmount);
      return maximumAmount;
    }
    return 0;
  }

  public void distributeYield() {
    for (Stock stock: stockRepository.values()) {
      if (stock.getAmount() != 0) {
        for (Share share: stock.getShares()) {
          share.getShareId().getAccount().setBalance(
            share.getShareId().getAccount().getBalance() + stock.getYield() * share.getAmount() / stock.getAmount()
          );
        }
      }
    }
  }
}
