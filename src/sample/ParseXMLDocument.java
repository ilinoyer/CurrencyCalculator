package sample;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

/**
 * Created by sojer on 13.10.2017.
 */
public class ParseXMLDocument implements ParseXML {

    private DownloadXML connection;
    private CurrencyCollection collection;
    private Document XMLDoc;

    public ParseXMLDocument(CurrencyCollection collection)
    {
        this.connection = new DownloadXML("https://www.nbp.pl/kursy/xml/lastA.xml");
        this.collection = collection;
        this.XMLDoc = this.connection.GetXMLDocument();
    }

    public void CreateCurrencyCollection()
    {
        String currencyName;
        int converter;
        String code;
        String temp;
        double rateOfExchange;


        NodeList currencyNameNode = XMLDoc.getElementsByTagName("nazwa_waluty");
        NodeList converterNode = XMLDoc.getElementsByTagName("przelicznik");
        NodeList codeNode = XMLDoc.getElementsByTagName("kod_waluty");
        NodeList rateOfExchangeNode = XMLDoc.getElementsByTagName("kurs_sredni");

        for(int i = 0; i < currencyNameNode.getLength(); ++i )
        {
                currencyName = currencyNameNode.item(i).getTextContent();
                converter = parseInt(converterNode.item(i).getTextContent());
                code = codeNode.item(i).getTextContent();

                temp = rateOfExchangeNode.item(i).getTextContent();
                temp = temp.replace(",", ".");
                rateOfExchange = parseDouble(temp);

                collection.AddElementToCollection(new Currency(currencyName, converter, code, rateOfExchange));
        }
    }
}
