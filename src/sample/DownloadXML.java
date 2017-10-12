package sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by sojer on 13.10.2017.
 */

public class DownloadXML {
     private String urlAddres;

     public DownloadXML(String urlAddres)
     {
         this.urlAddres = urlAddres;
     }

     public String XMLToString()
     {
         URL url;
         InputStream is = null;
         BufferedReader br;
         String line;
         String result = null;

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
}
