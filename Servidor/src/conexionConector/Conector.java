package conexionConector;

import java.net.*;
import java.io.*;
import java.util.ArrayList;

public class Conector {

    private final int PUERTO = 9000;
    private int opportunities = 8;

    private ArrayList word, formedWord;

    private ServerSocket server;
    private Socket socket;
    private DataOutputStream salida;
    private DataInputStream entrada;

    public Conector(String word) {
        this.formedWord = new ArrayList();
        this.word = new ArrayList();
        for (int i = 0; i < word.length(); i++) {
            this.word.add(word.charAt(i));
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
        System.out.println("------------------------------------------");
    }

    /*
    Devuelve 1 si la letra está en la palabra
    de lo contrario devuelve 0
     */
    private int findWord(char letter) {
        boolean foundOne = false;
        for (int i = 0; i < this.word.size(); i++) {
            if (this.word.get(i).equals(letter)) {
                this.word.remove(i);
                this.word.add(i, "");
                this.formedWord.remove(i);
                this.formedWord.add(i, letter);
                foundOne = true;
            }

        }
        if (this.formedWord.contains(letter)) {
            foundOne = true;
        }
        if (foundOne) {
            return 1;
        } else {
            this.opportunities--;
            return 0;
        }
    }

}
