package conexionCliente;

import java.net.*;
import java.io.*;

public class Conector {

    private final int PUERTO = 9000;
    private final String IP = "127.0.0.1";
    private int opportunities = 8;
    
    private Socket cliente;
    private BufferedReader teclado;
    private DataOutputStream dos;
    private DataInputStream dis;

    public void conectar() {
        try {
            cliente = new Socket(IP, PUERTO);
            dos = new DataOutputStream(cliente.getOutputStream());
            dis = new DataInputStream((cliente.getInputStream()));
            teclado = new BufferedReader(new InputStreamReader(System.in));
            
            while(this.opportunities > 0) {
                String tec = teclado.readLine();

                dos.writeChar(tec.charAt(0));
               // System.out.println("error?");
                int serverResponse = dis.readInt();
                if (serverResponse != 1) {
                    this.opportunities--;
                }
            }
            dos.close();
            teclado.close();
            cliente.close();
            System.out.println("connection close");
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error en (cliente) conexion.Conector() " + e.getMessage());
        } 
    }
}
