package logica;

import conexionCliente.Conector;

public class GameLogic {

    private String formedWord, oldWord;
    private boolean continueGame, win;
    private char readLetter;
    private int hangedLevel = 0;
    private Conector c;

    public GameLogic() {
        this.continueGame = true;
        this.win = false;
        c = new Conector();
        this.oldWord = "";
    }

    /**
     * Prueba la letra que fue enviada al servidor y después recibe su
     * respuesta. Si no es posible enviar la letra al servidor, significa que el
     * juego ha finalizado y cambiar el valor de continueGame a false
     */
    public void testLetter() {
        try {
            if (hangedLevel > 7) {
                this.continueGame = false;
            } else {
                c.setLetter(this.readLetter);
                this.continueGame = c.sendLetter();
                this.formedWord = formatWord(c.getServerWord());
                validateWord();
                this.oldWord = formedWord;
            }
        } catch (Exception e) {
            System.out.println("Error in thread logica.testLetter() " + e.getMessage());
        }
    }

    /**
     * Recibe la palabra del juego quitando los carácteres especiales [ y ]
     *
     * @return un String con la palabra sin [ y ]
     */
    private String formatWord(String word) {
        String formatedWord = word.replace("[", "");
        formatedWord = formatedWord.replace("]", "");
        return formatedWord;
    }

    private void validateWord() {
        if (this.formedWord.equals(oldWord)) {
            hangedLevel++;
        }
        System.out.println(this.formedWord);
        if (!this.formedWord.contains("_")) {
            this.win = true;
        } 
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

    public int getHangedLevel() {
        return hangedLevel;
    }

    public boolean isWin() {
        return win;
    }
}
