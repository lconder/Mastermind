import java.util.*;

public class Result {

    public static void main(String[] args) {
        Code comp = new Code("BRPR");
        Code user = new Code("BRRB");

        Result r = new Result();
        r.getResults(comp, user);
        System.out.println(r);
    }

    String result;

    public Result() {
        result = "";
    }

    public boolean getResults(Code comp, Code user)
    {
        if(comp == null || user == null)  {
            throw new IllegalArgumentException("Valores nulos");
        }

        result = "";
        char black = 'B';
        char white = 'W';

        ArrayList<Peg> userCode = new ArrayList<Peg>();
        ArrayList<Peg> compCode = new ArrayList<Peg>();

        for(int i = 0; i < comp.size(); i++) {
            userCode.add(user.getPeg(i));
            compCode.add(comp.getPeg(i));
        }

        int maxSize = compCode.size();

        for(int i = 0; i < maxSize; i++) {

            if(compCode.get(i).compare(userCode.get(i))) {
                result += black;
                compCode.set(i, null);
                userCode.set(i, null);

            } else {
                for(int j = 0; j < maxSize; j++) {

                    if(compCode.get(i) != null && userCode.get(j) != null) {
                        if(compCode.get(i).compare(userCode.get(j))) {
                            result += white;
                            compCode.set(i, null);
                            userCode.set(j, null);
                        }
                    }
                }
            }
        }

        if(comp.compare(user)) {
            return true;
        } else {
            return false;
        }
    }

    public String toString()
    {
        String str = "";
        if(result.length() == 0) {
            str += "Sin ficha";
        } else {
            for(int i = 0; i < result.length(); i++) {
                if(result.charAt(i) == 'B') {
                    str += "Negro ";
                }
            }

            for(int i = 0; i < result.length(); i++) {
                if(result.charAt(i) == 'W') {
                    str += "Blanco ";
                }
            }
        }

        return str;
    }
}