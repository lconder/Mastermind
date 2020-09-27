import java.util.*;

public class Code {

    private static final int SIZE = 4;

    private ArrayList<Peg> code;

    public Code() {
        code = new ArrayList<Peg>();

        for (int i=0; i < SIZE; i++) {
            Peg p = new Peg();
            code.add(p);
        }
    }

    public Code(String input) {

        if(input.length() != SIZE) {
            throw new IllegalArgumentException("Longitud de c\u00F3digo err\u00F3nea");
        }

        this.code = new ArrayList<Peg>();

        for (int i=0; i < SIZE; i++) {
            Peg p = new Peg(input.charAt(i));
            this.code.add(p);
        }
    }


    public Peg getPeg(int pos) {
        if (pos < 0 || pos >= SIZE) {
            throw new IllegalArgumentException("No es una posici\u00F3n v\u00E1lida");
        }
        return this.code.get(pos);
    }


    public boolean compare(Object other) {
        if(other instanceof Code) {
            Code otherCode = (Code)other;
            for (int i=0; i<SIZE; i++) {
                if(!this.getPeg(i).compare(otherCode.getPeg(i))) {
                    return false;
                }
            }
        }
        return true;
    }

    public String toString() {
        String str = "";

        for (int i=0; i < SIZE; i++) {
            Peg p = this.getPeg(i);
            char c = p.getColor();
            str += c;
        }
        return str;
    }

    public int size() {
        return SIZE;
    }
}
