package conexionConector;

import java.net.*;
import java.io.*;
import java.util.ArrayList;

public class ThreadConector {

    private final int PUERTO = 9000;
    private int opportunities = 9;
    private ArrayList word, formedWord;

    private ServerSocket server;
    private Socket socket;
    private DataOutputStream salida;
    private DataInputStream entrada;

    public ThreadConector(String word) {
        this.formedWord = new ArrayList();
        this.word = new ArrayList();
        for (int i = 0; i < word.length(); i++) {
            this.word.add(word.charAt(i));
            formedWord.add("_");
        }
    }
    
    public void iniciar() {
        try {
            this.server = new ServerSocket(PUERTO);
            this.socket = new Socket();
            this.socket = server.accept();

            while (this.opportunities > 0) {
                if (this.socket.isConnected()) {
                    System.out.println("A new cliente has connected");
                }
                entrada = new DataInputStream(socket.getInputStream());
                salida = new DataOutputStream(socket.getOutputStream());
                char letter = entrada.readChar();
                findWord(letter);
                salida.writeUTF(this.formedWord.toString());
                System.out.println("------------------------------------------");
                printInfo(letter);
            }

        } catch (IOException e) {
            System.out.println("Error en (servidor) conexion.Conector() " + e.getMessage());
        };
    }

    private void printInfo(char letter) {
        System.out.println("Word: " + this.word);
        System.out.println("Entered letter: " + letter);
        System.out.println("Formed word: " + this.formedWord);
        System.out.println("Opportunities: " + this.opportunities);
        System.out.println("------------------------------------------");
    }

    /**
     * Busca la letra en la palabra, si encuentra la letra, 
     * la variable formedWord la reemplaza en la posición exacta dónde se encuentra en word
     * de la misma forma, también elimina la letra en la posición exacta de word. 
     * Finalmente le va restando vidas al jugador
     * @param letter letra para buscar en lla palabra
     */
    private void findWord(char letter) {
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
        if (!foundOne) {
            this.opportunities--;
        }
    }

}
