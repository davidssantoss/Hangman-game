package conexionConector;

import java.net.*;
import java.io.*;

public class Conector {
    int PUERTO = 9000;
    
    ServerSocket server;
    Socket socket;
    DataOutputStream salida;
    BufferedReader entrada;
    
    public void iniciar() {
        try {
            server = new ServerSocket(PUERTO);
            socket = new Socket();
            socket = server.accept();
            
            entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String mensaje = entrada.readLine();
            System.out.println(mensaje);
            salida = new DataOutputStream(socket.getOutputStream());
            salida.writeUTF("adios mundo");
            socket.close();
        } catch (IOException e) {
            System.out.println("Error en (servidor) conexion.Conector() "+e.getMessage());
        }
;
    }
}
