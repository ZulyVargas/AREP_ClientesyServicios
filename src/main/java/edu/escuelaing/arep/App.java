package edu.escuelaing.arep;

import edu.escuelaing.arep.httpServer.HttpServer;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        HttpServer httpServer = new HttpServer();
        httpServer.startServer();
    }
}
