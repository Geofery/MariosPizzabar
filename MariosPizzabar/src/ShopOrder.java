import java.time.LocalDateTime;
import java.util.ArrayList;

public class ShopOrder extends Order {
    public ShopOrder(int id, ArrayList orderNr, LocalDateTime localDateTime) {
        super(id, orderNr, localDateTime.plusMinutes(20));
    }

}
