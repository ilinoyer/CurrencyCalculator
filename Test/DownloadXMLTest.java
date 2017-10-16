import org.junit.Test;
import sample.DownloadXML;

import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;

/**
 * Created by sojer on 13.10.2017.
 */
public class DownloadXMLTest {

    @Test
    public void CreatingObjectTest()
    {
        DownloadXML connection = new DownloadXML("https://www.nbp.pl/kursy/xml/lastA.xml");

    }

    @Test
    public void CheckingXMLString()
    {
        DownloadXML connection = new DownloadXML("https://www.nbp.pl/kursy/xml/lastA.xml");
        assertThat("" ,not(connection.GetXMLString()));
    }

    @Test
    public void CheckingXMLDoc()
    {
        DownloadXML connection = new DownloadXML("https://www.nbp.pl/kursy/xml/lastA.xml");
        assertThat(null, not(connection.GetXMLDocument()));
    }
}
