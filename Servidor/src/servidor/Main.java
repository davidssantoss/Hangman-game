/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import conexionConector.Conector;

/**
 *
 * @author Estudiantes
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Interfaz i = new Interfaz();
//        i.setVisible(true);
        Conector c = new Conector();
        c.iniciar();
        
    }
    
}
