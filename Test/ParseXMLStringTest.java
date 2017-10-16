import org.junit.Test;
import sample.CurrencyCollection;
import sample.ParseXML;
import sample.ParseXMLDocument;

import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

/**
 * Created by sojer on 16.10.2017.
 */
public class ParseXMLStringTest {
    @Test
    public void CreatingObjectTest()
    {
        ParseXML parser = new ParseXMLDocument(new CurrencyCollection());
    }


    @Test
    public void CreatingCollectionTest()
    {
        CurrencyCollection collection = new CurrencyCollection();
        ParseXML parser = new ParseXMLDocument(collection);
        parser.CreateCurrencyCollection();
        assertThat(0,not(collection.GetCollectionSize()));
    }
}
