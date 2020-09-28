import java.util.*;

public class Game {

    private boolean showCode;

    public static void main(String[] args) {
        Game g = new Game(true);
        g.runGame();
    }

    public Game(boolean showCode) {
        this.showCode = showCode;
    }

    public void runGame() {

        printInstructions();

        Board board = new Board();
        board.addDots();
        Result results = new Result();

        int numGuesses = board.getNumGuesses();

        System.out.println("Tienes " + numGuesses + " intentos de adivinar la repsuesta correcta\n");

        System.out.println("Generando codigo secreto...\n");

        Code compCode = new Code();
        Scanner keyboard = new Scanner(System.in);

        boolean canContinue = true;

        while(canContinue) {
            if(showCode) {
                System.out.println("El codigo secreto es: "+ compCode+"\n");
            }

            System.out.println("Tienes " + numGuesses + " intentos.");

            boolean badcode = true;
            Code userCode = new Code();

            while(badcode) {

                badcode = false;
                System.out.println("Ingresa un nuevo intento: ");
                System.out.println("Por ejemplo: (BRRY) ");

                String guess = keyboard.nextLine();

                try {
                    userCode = new Code(guess.toUpperCase());
                } catch (IllegalArgumentException e) {
                    badcode = true;
                }
            }

            boolean winner = results.getResults(compCode, userCode);

            if(showCode) {
                System.out.println("El codigo secreto es: "+ compCode +"\n");
            }

            board.changeRow(userCode, results);

            if(winner) {
                System.out.println(board.winnerToString());
            } else {
                System.out.println(board);
            }

            numGuesses--;

            if(numGuesses == 0 || winner)
            {
                canContinue = false;
                if(numGuesses == 0) {
                    System.out.println("Has perdido.");
                }

                if(winner) {
                    System.out.println("Has ganado.");
                }
            }
        }
    }

    public static void printInstructions() {
        System.out.println("Mastermind Consola. \n" +
                "Se generara un codigo secreto.\n" +
                "El codigo esta formado por 4 colores\n" +
                "Los colores pueden ser:\n" +
                "Azul (B)\n" +
                "Verde (G)\n" +
                "Naranja (O)\n" +
                "Rojo (R)\n" +
                "Amarillo (Y)\n" +
                "Un color puede aparacer mas de una vez\n" +
                "Debes intentar adivinar introduciendo 4 digitos por ejemplo:\n" +
                "BRYO\n\n" +
                "Si tienes un digito correcto en posicion y color entonces se te dara una ficha Negra (K)\n" +
                "Si tienes un digito correcto en color entonces se te dara una ficha Blanca (W)\n" +
                "Ganas cuando adivinas el codigo secreto\n"
                );
    }

}