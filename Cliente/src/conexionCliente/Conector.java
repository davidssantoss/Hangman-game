package conexionCliente;

import java.net.*;
import java.io.*;

public class Conector {

    int PUERTO = 9000;
    String IP = "127.0.0.1";
    
    Socket cliente;
    BufferedReader entrada, teclado;
    PrintStream salida;
    
    public void conectar() {
        try {
            cliente = new Socket(IP, PUERTO);
            entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            teclado = new BufferedReader(new InputStreamReader(System.in));
            
            String tec = teclado.readLine();
            salida = new PrintStream(cliente.getOutputStream());
            salida.println(tec);
            String msg = entrada.readLine();
            System.out.println(msg);
            
            entrada.close();
            salida.close();
            teclado.close();
            cliente.close();
        } catch (Exception e) {
            System.out.println("Error en (cliente) conexion.Conector() "+e.getMessage());
        }
    }
}
