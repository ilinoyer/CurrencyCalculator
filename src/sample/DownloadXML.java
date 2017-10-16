package sample;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import jdk.internal.org.xml.sax.InputSource;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.net.URL;

import static java.lang.System.exit;

/**
 * Created by sojer on 13.10.2017.
 */

public class DownloadXML {
     private String urlAddres;

     public DownloadXML(String urlAddres)
     {
         this.urlAddres = urlAddres;
     }

     public String GetXMLString()
     {
         URL url;
         InputStream is = null;
         BufferedReader br;
         String line;
         String result = "";

         try {
             url = new URL(urlAddres);
             is = url.openStream();
             br = new BufferedReader(new InputStreamReader(is));

             while ((line = br.readLine()) != null) {
                 result = result + line + "\n";
             }
         } catch (Exception e) {
             return "";
         } finally {
             try {
                 if (is != null) is.close();
             } catch (IOException ioe) {}
         }

         return result;

     }

    public Document GetXMLDocument()
    {
        Document doc = null;
        InputStream is = null;

        try {

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            URL url = new URL(urlAddres);
            is = url.openStream();
            doc = db.parse(is);

        }
        catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Wymagany internet! ", ButtonType.YES);
            alert.showAndWait();

            if (alert.getResult() == ButtonType.YES) {
                exit(1);
            }
        }
        finally {

            try {
                if (is != null) is.close();
            } catch (IOException ioe) {}
        }

        return doc;
    }
}
