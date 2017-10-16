import org.junit.Test;
import sample.Currency;
import sample.CurrencyCollection;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;

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
        assertThat(1, is(collection.GetCollectionSize()));
    }

    @Test
    public void GettingElementByCode()
    {
        CurrencyCollection collection = new CurrencyCollection();
        collection.AddElementToCollection(new Currency("Złoty", 1, "PLN", 0.50));
        assertThat("PLN", is(collection.GetCurrencyElementByCode("PLN").GetCode()));
    }

    @Test
    public void GettingEmentByPosition()
    {
        CurrencyCollection collection = new CurrencyCollection();
        Currency currency = new Currency("Złoty", 1, "PLN", 0.50);
        collection.AddElementToCollection(currency);
        assertThat(currency, is(collection.GetCollectionElementByPosition(0)));
    }
}
