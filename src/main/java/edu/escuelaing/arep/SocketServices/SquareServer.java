package edu.escuelaing.arep.SocketServices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SquareServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(35000);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35000.");
            System.exit(1);
        }
        Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        Double inputLine, outputLine; //Input lo que llega
        System.out.println("PARA SALIR INGRESE '0'");
        while ((inputLine = Double.valueOf(Integer.valueOf(in.readLine()))) != null) {
            System.out.println( "NÚMERO INGRESADO:   " + inputLine);
            outputLine = Double.valueOf( Math.pow(inputLine,2)); //Lo que debe mandar
            String outputLineString = "CUADRADO DEL NÚMERO INGRESADO: " + outputLine;
            out.println(outputLineString); //Salida
            if (outputLine == 0) {
                break;
            }
        }
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }

}
