import org.junit.Test;
import sample.Currency;
import sample.CurrencyCollection;

import static org.junit.Assert.assertEquals;

/**
 * Created by sojer on 13.10.2017.
 */
public class CurrencyCollectionTest {

    @Test
    public void CreatingCurrencyCollectionObject()
    {
        CurrencyCollection collection = new CurrencyCollection();
    }

    @Test
    public void AddingElementToCollectionTest()
    {
        CurrencyCollection collection = new CurrencyCollection();
        collection.AddElementToCollection(new Currency("Złoty", 1, "PLN", 0.50));
        assertEquals(1,collection.GetCollectionSize());
    }
}
