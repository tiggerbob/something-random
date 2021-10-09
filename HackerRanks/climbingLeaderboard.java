import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        // initialize
        BufferedReader in = new BufferedReader(new FileReader("src/in.txt"));

        int playerNum = Integer.parseInt(in.readLine());
        String[] rankedString = in.readLine().split("\\s+");
        ArrayList<Integer> ranked = new ArrayList<Integer>();
        for(int i = 0; i < playerNum; i++) {
            ranked.add(Integer.parseInt(rankedString[i]));
        }
        Collections.reverse(ranked);

        ranked = (ArrayList<Integer>) ranked.stream().distinct().collect(Collectors.toList());

        int numGames = Integer.parseInt(in.readLine());
        String[] gamesString = in.readLine().split("\\s+");
        ArrayList<Integer> player = new ArrayList<Integer>();
        for(int i = 0; i < numGames; i++) {
            player.add(Integer.parseInt(gamesString[i]));
        }

        // algorithm
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i = 0; i < player.size(); i++) {
            if(player.get(i) > ranked.get(ranked.size()-1)) {
                result.add(1);
            } else {
                for (int m = 0; m < ranked.size(); m++) {
                    if (player.get(i) < ranked.get(m)) {
                        result.add(ranked.size() - m + 1);
                        break;
                    } else if (player.get(i).equals(ranked.get(m))) {
                        result.add(ranked.size() - m);
                        break;
                    }
                }
            }
        }

        int count = 0;
        for(Integer a : result) {
            if(a == 1) {
                count++;
            }
        }

        // output
        System.out.println(count);
        System.out.println(result);
    }
}
