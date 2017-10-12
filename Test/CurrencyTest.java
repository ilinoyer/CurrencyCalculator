import org.junit.Test;
import sample.Currency;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class CurrencyTest {

    @Test
    public void CreatingCurrencyObjectTest()
    {
        Currency currency = new Currency("Złoty", 1,"PLN", 1.5);
    }

    @Test
    public void GetterTest()
    {
        Currency currency = new Currency("Złoty", 1,"PLN", 1.5);
        assertEquals(1,currency.getConverter());
    }

    @Test
    public void SetterTest()
    {
        Currency currency = new Currency("Złoty", 1,"PLN", 1.5);
        currency.setConverter(2);
        assertNotEquals(1, currency.getConverter());
    }
}
