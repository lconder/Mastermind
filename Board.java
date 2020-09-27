import java.util.*;

public class Board {

    public static void main(String[] args) {
        Board b = new Board();
        b.addDots();
        Code userGuess = new Code("PPPP");
        Code compGuess = new Code("PPPP");
        Result r = new Result();
        r.getResults(compGuess, userGuess);

        b.changeRow(userGuess,  r);

        System.out.println(b.winnerToString());

    }

    private static final int NUM_GUESSES = 12;

    private ArrayList<String> board;
    private int index;

    public Board() {
        board = new ArrayList<String>();
        index = 0;
        board.add(".... C\u00F3digo secreto");
        index++;
    }

    public void addDots() {
        for(int i = 1; i <= NUM_GUESSES; i++){
            board.add("....");
        }
    }


    public void changeRow(Code user, Result r) {
        if(user == null || r == null) {
            throw new IllegalArgumentException("El c\u00F3digo de usuario y el resultado no pueden ser nulos");
        }
        String str = "";
        str += user.toString() + " ";
        str += "Resultado: " + r.toString();
        board.set(index, str);
        index++;
    }

    public int getNumGuesses() {
        return NUM_GUESSES;
    }

    public String toString(){
        String str = "";
        for(int i = 0; i <= NUM_GUESSES; i++) {
            str += board.get(i) + "\n";
        }
        return str;
    }

    public String winnerToString(){
        String str = "";
        for(int i = 1; i <= index; i++) {
            str += board.get(i) + "\n";
        }
        return str;
    }

}