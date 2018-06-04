package conexionCliente;

import java.net.*;
import java.io.*;

public class Conector {

    private final int PUERTO = 9000;
    private final String IP = "127.0.0.1";

    private Socket cliente;
    private DataOutputStream dos;
    private DataInputStream dis;

    private char letter;
    private String serverWord;

    public Conector() {
        conectar();
    }

    private void conectar() {
        try {
            cliente = new Socket(IP, PUERTO);
            System.out.println("connected to server...");
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error en (cliente) conexion.Conector() " + e.getMessage());
        }
    }

    public boolean sendLetter() {
        boolean continueConnection = true;
        try {
            dos = new DataOutputStream(cliente.getOutputStream());
            dis = new DataInputStream((cliente.getInputStream()));
            
            dos.writeChar(this.letter);
            String serverResponse = dis.readUTF();
            this.serverWord = serverResponse;
        } catch (IOException e) {
            continueConnection = false;
            System.out.println("Error en conexion.sendLetter() " + e.getMessage());
        }
        return continueConnection;
    }

    public String getServerWord() {
        return serverWord;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }
}
