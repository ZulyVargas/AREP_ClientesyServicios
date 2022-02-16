package edu.escuelaing.arep.URLServices;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;

/**
 * This class gets and displays on the screen the components of a URL.
 * @author zuly.vargas
 */
import java.util.logging.Logger;

public class URLParser {
    public static URL yURL;
    //Ejercicio 1
    public static void main(String[] args) throws IOException {
        try{
            URL googleURL = new URL("https://campusvirtual.escuelaing.edu.co/moodle/course/view.php?id=892#init");
            System.out.println("PROTOCOL: " +googleURL.getProtocol());
            System.out.println("AUTHORITY: " +googleURL.getAuthority());
            System.out.println("HOST: " +googleURL.getHost());
            System.out.println("PORT: " +googleURL.getPort());
            System.out.println("PATH: " +googleURL.getPath());
            System.out.println("QUERY: " +googleURL.getQuery());
            System.out.println("FILE: " +googleURL.getFile());
            System.out.println("REF: " +googleURL.getRef());

        }catch(MalformedURLException ex){
            Logger.getLogger(URLParser.class.getName()).log(Level.SEVERE, null,ex);
        }
        saveInHtml();
        saveInHtmlSecondForm();
    }

    //Ejercicio 2
    /**
     * Save the url information in a html file.
     * @throws IOException - something wrong with the file to save.
     */
    public static void saveInHtml() throws IOException {
        yURL = new URL("https://www.youtube.com/watch?v=8IXLpoN8Xj0&ab_channel=Computerphile");
        FileWriter write = new FileWriter("resultado.html");
        BufferedWriter bw = new BufferedWriter(write);
        bw.write("<!DOCTYPE html>"
                +"<html>"
                +"<head>"
                +"<title> respuesta </title>"
                +"</head>"
                +"<body>"
                +"<h1> Datos de la URL :  https://www.youtube.com/watch?v=8IXLpoN8Xj0&ab_channel=Computerphile </h1>"
                +"<p>"+"PROTOCOL : "+getProtocol()+", AUTHORITY:"+getAuthority()+",HOST:"+getHost()+",PORT:"+getPort()+",PATH:"+getPath()+",QUERY:"+getQuery()+",FILE:"+getFile()+",REF:"+getRef()+"</p>"
                +"</body>"
                +"</html>"
        );
        bw.close();
    }
    //Ejercicio 2
    /**
     * Save the url information in a html file.
     * @throws IOException
     */
    public static void saveInHtmlSecondForm() throws IOException {
        FileWriter write = new FileWriter("resultado.html");
        BufferedWriter bw2 = new BufferedWriter(write);

        URL youtube = new URL("https://www.youtube.com/watch?v=8IXLpoN8Xj0&ab_channel=Computerphile");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(youtube.openStream()))) {
            String inputLine = null;
            while ((inputLine = reader.readLine()) != null) {
                bw2.write(inputLine);
            }
            bw2.close();
        } catch (IOException x) {
            System.err.println(x);
        }
    }

    /**
     * Returns the protocol of a URI.
     * @return - protocol of the url.
     */
    public static String getProtocol() {
        return yURL.getProtocol();
    }

    /**
     * Returns the authority of a URI.
     * @return - authority of the url.
     */
    public static String getAuthority() {
        return yURL.getAuthority();
    }

    /**
     * Returns the host of a URI.
     * @return - host of the url.
     */
    public static String getHost() {
        return yURL.getHost();
    }

    /**
     * Returns the port of a URI.
     * @return - port of the url.
     */
    public static int getPort() {
        return yURL.getPort();
    }

    /**
     * Returns the path of a URI.
     * @return - path of the url.
     */
    public static String getPath() {
        return yURL.getPath();
    }

    /**
     * Returns the query of a URI.
     * @return - query of the url.
     */
    public static String getQuery() {
        return yURL.getQuery();
    }


    /**
     * Returns the file of a URI.
     * @return - file of the url.
     */
    public static String getFile() {
        return yURL.getFile();
    }


    /**
     * Returns the ref of a URI.
     * @return - ref of the url.
     */
    public static String getRef() {
        return yURL.getRef();
    }
}
