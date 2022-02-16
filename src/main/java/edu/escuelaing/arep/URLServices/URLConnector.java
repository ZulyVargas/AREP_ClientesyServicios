package edu.escuelaing.arep.URLServices;


import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author zuly.vargas
 */
public class URLConnector {

    public static void main(String[] args) throws MalformedURLException, IOException {

        System.out.println("MAIN---");
        // Crea el objeto que representa una URL
        String site = "http://google.com/";
        URL siteURL = new URL(site);
        // Crea el objeto URLConnection
        URLConnection urlConnection = siteURL.openConnection();
        //Obtiene los campos del encabezado y los almacena en un estructura Map
        Map<String, List<String>> headers = urlConnection.getHeaderFields();
        //Obtiene una vista del mapa como conjunto de pares <K,V>
        // para poder navegarlo
        Set<Map.Entry<String, List<String>>> entrySet = headers.entrySet();
        // Recorre la lista de campos e imprime los valores
        for (Map.Entry<String, List<String>> entry : entrySet) {
            String headerName = entry.getKey();
            //Si el nombre es nulo, significa que es la linea de estado
            if (headerName != null) {
                System.out.print(headerName + ":");
            }
            List<String> headerValues = entry.getValue();
            for (String value : headerValues) {
                System.out.print(value);
            }
            System.out.println("");
        }
    }
    }
