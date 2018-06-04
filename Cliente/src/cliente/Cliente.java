package cliente;

import Vista.Interfaz;
import conexionCliente.Conector;
import java.io.IOException;

/**
 *
 * @author Estudiantes
 */
public class Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Conector c;
        Interfaz i;
        try {
            i = new Interfaz();
            i.setVisible(true);
            //c = new Conector();
            //c.conectar();
        } catch (Exception e) {
            System.out.println("Error en cliente.Cliente(): "+e.getMessage());
        }
    }

}
