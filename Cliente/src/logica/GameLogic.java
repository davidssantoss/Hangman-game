package logica;

import conexionCliente.Conector;

public class GameLogic {

    private String formedWord;
    private boolean continueGame;
    private char readLetter;
    private Conector c;

    public GameLogic() {
        this.continueGame = true;
        c = new Conector();
    }

    /**
     * Prueba la letra que fue enviada al servidor y después recibe su respuesta.
     * Si no es posible enviar la letra al servidor, significa que el juego ha finalizado
     * y cambiar el valor de continueGame a false
     */
    public void testLetter() {
        try {
            c.setLetter(readLetter);
            this.continueGame = c.sendLetter();
            this.formedWord = formatWord(c.getServerWord());
            System.out.println(this.formedWord);
        } catch (Exception e) {
            System.out.println("Error in thread logica.testLetter() " + e.getMessage());
        }
    }

    /**
     * Recibe la palabra del juego quitando los carácteres especiales [ y ]
     * @return un String con la palabra sin [ y ]
     */
    private String formatWord(String word) {
        System.out.println("Entro a formatword...");
        String formatedWord = word.replace("[", "");
        formatedWord = formatedWord.replace("]", "");
        return formatedWord;
    }

    public void setReadLetter(char readLetter) {
        this.readLetter = readLetter;
    }

    public String getFormedWord() {
        return formedWord;
    }

    public boolean isContinueGame() {
        return continueGame;
    }

    public void setContinueGame(boolean continueGame) {
        this.continueGame = continueGame;
    }

}
