import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int numRounds = Integer.parseInt(in.next());
        String result = "NO";
        for(int i = 0; i < numRounds; i++) {
            result = "NO";
            String s1 = in.next();
            String s2 = in.next();
            for(int j = 0; j < s1.length(); j++) {
                for(int m = 0; m < s2.length(); m++) {
                    if(s1.charAt(j) == s2.charAt(m)) {
                        result = "YES";
                        break;
                    }
                }
            }
            System.out.println(result);
        }
    }
}
