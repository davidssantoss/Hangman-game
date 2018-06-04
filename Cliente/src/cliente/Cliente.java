package cliente;

import Vista.Interfaz;
import conexionCliente.Conector;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import logica.GameLogic;

/**
 *
 * @author Estudiantes
 */
public class Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Interfaz i;
        GameLogic l;
        //BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        i = new Interfaz();
        i.setVisible(true);
        l = new GameLogic();
        String tec;
        while (l.isContinueGame()) {
            //tec = teclado.readLine();
            l.setReadLetter(i.getLetter());
            l.testLetter();
            i.setWord(l.getFormedWord());
        }
    }

}
