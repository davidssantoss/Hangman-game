package conexionConector;

import java.net.*;
import java.io.*;
import java.util.ArrayList;
public class Conector {

    private final int PUERTO = 9000;
    private String word;
    private int opportunities = 8;
    
    private ArrayList formedWord;
    
    private ServerSocket server;
    private Socket socket;
    private DataOutputStream salida;
    private DataInputStream entrada;

    public Conector(String word) {
        this.word = word;
        this.formedWord = new ArrayList();
        for (int i = 0; i < this.word.length(); i++) {
            formedWord.add("");
        }
    }

    public void iniciar() {
        try {
            this.server = new ServerSocket(PUERTO);
            this.socket = new Socket();
            this.socket = server.accept();

            while (this.opportunities > 0) {
                entrada = new DataInputStream(socket.getInputStream());
                char letter = entrada.readChar();
                salida = new DataOutputStream(socket.getOutputStream());
                salida.writeInt(findWord(letter)); // Devuelve 1 o 0 si encontró la palabra   
                printInfo(letter);
            }

            socket.close();
        } catch (IOException e) {
            System.out.println("Error en (servidor) conexion.Conector() " + e.getMessage());
        };
    }

    private void printInfo(char letter) {
        System.out.println("Word: " + this.word);
        System.out.println("Entered letter: " + letter);
        System.out.println("Formed word: " + this.formedWord);
        System.out.println("Player opportunities: " + this.opportunities);
    }

    /*
    Devuelve 1 si la letra está en la palabra
    de lo contrario devuelve 0
     */
    private int findWord(char letter) {
        int letterIndex = this.word.indexOf(letter);
        if ( letterIndex >= 0) {
            if (!this.formedWord.contains(letter)) {
                this.formedWord.add(letterIndex, letter);
            }
            return 1;
        }
        this.opportunities--;
        return 0;
    }

}
