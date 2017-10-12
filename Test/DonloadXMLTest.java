import org.junit.Test;
import sample.DownloadXML;

/**
 * Created by sojer on 13.10.2017.
 */
public class DonloadXMLTest {

    @Test
    public void CreatingObjectTest()
    {
        DownloadXML connection = new DownloadXML("https://www.nbp.pl/kursy/xml/lastA.xml");

    }

    @Test
    public void CheckingXMLString()
    {
        DownloadXML connection = new DownloadXML("https://www.nbp.pl/kursy/xml/lastA.xml");
        System.out.println(connection.XMLToString());
    }
}
