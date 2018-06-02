package servidor;

import Logica.Palabras;
import conexionConector.Conector;

public class Main {

    public static void main(String[] args) {
        Palabras p = new Palabras();
        Conector c = new Conector(p.randomWord());
        c.iniciar();
        
    }
    
}
