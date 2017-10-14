package sample;

import jdk.internal.org.xml.sax.InputSource;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringReader;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

/**
 * Created by sojer on 13.10.2017.
 */
public class ParseXMLString implements ParseXML {

    private DownloadXML connection;
    private CurrencyCollection collection;
    private String XMLString;

    public ParseXMLString(CurrencyCollection collection)
    {
        this.connection = new DownloadXML("https://www.nbp.pl/kursy/xml/lastA.xml");
        this.collection = collection;
        this.XMLString = this.connection.GetXMLString();
    }


    public void CreateCurrencyCollection() // temporary
    {
        DocumentBuilder builder = null;

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            builder = factory.newDocumentBuilder();
        }
        catch(ParserConfigurationException e)
        {
            e.printStackTrace();
        }

        Document XMLDoc = builder.newDocument();
        InputStream inputStream = new ByteArrayInputStream(XMLString.getBytes());
        try{
            XMLDoc = builder.parse(inputStream);
        }
        catch(Exception e)
        {

        }

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


