package servidor;

import Logica.Palabras;
import conexionConector.ThreadConector;

public class Main {

    public static void main(String[] args) {
        Palabras p = new Palabras();
        ThreadConector c = new ThreadConector(p.randomWord());
        c.iniciar();
    }
    
}
