import java.time.LocalDateTime;
import java.util.ArrayList;

public class PhoneOrder extends Order{
    public PhoneOrder(int id, ArrayList orderNr, LocalDateTime localDateTime) {
        super(id, orderNr, localDateTime.plusHours(1));
    }
}
