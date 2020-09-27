import java.util.*;

public class Peg {

    private static final char BLACK = 'K';
    private static final char BLUE = 'B';
    private static final char GREEN = 'G';
    private static final char ORANGE = 'O';
    private static final char PURPLE = 'P';
    private static final char RED = 'R';
    private static final char YELLOW = 'Y';
    private static final char WHITE = 'W';

    private char color;

    public Peg() {

        Character[] colors = {
          BLUE,
          GREEN,
          ORANGE,
          PURPLE,
          RED,
          YELLOW
        };

        Random rand = new Random();

        int random = rand.nextInt(colors.length);

        color = colors[random];

    }

    public Peg(Character c) {

        ArrayList<Character> colors = new ArrayList<Character>();
        colors.add(BLACK);
        colors.add(BLUE);
        colors.add(GREEN);
        colors.add(ORANGE);
        colors.add(PURPLE);
        colors.add(RED);
        colors.add(YELLOW);
        colors.add(WHITE);

        if(!colors.contains(c)) {
            throw new IllegalArgumentException("Valor inadecuado de color");
        }

        color = c;
    }

    public char getColor() {
        return color;
    }

    public boolean compare(Object object) {

        if (!(object instanceof Peg)) {
            return false;
        }

        Peg other = (Peg)object;
        return this.color == other.color;
    }
}