package exam_preparations.examI.Problem04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by Chilly on 21.10.2017 г..
 */
public class Highscore {
    private static Map<String,Long> playersPointsOnly = new HashMap<>();
    private static Map<String,LinkedList<String>> playersWithOpponents = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            String[] matchData = reader.readLine().split("<->");
            if (matchData[0].equals("osu!")) {
                break;
            }
            String[] firstPlayer = matchData[0].split(" ");
            String[] secondPlayer = matchData[1].split(" ");
            fillData(firstPlayer[1], secondPlayer[0], Long.valueOf(firstPlayer[0]), Long.valueOf(secondPlayer[1]));
            fillData(secondPlayer[0], firstPlayer[1], Long.valueOf(secondPlayer[1]), Long.valueOf(firstPlayer[0]));
        }
        StringBuilder result = new StringBuilder();
        playersPointsOnly.entrySet().stream().sorted((a,b) -> Long.compare(b.getValue(), a.getValue()))
                            .forEach(value -> {
                                result.append(value.getKey()).append(" - (").append(value.getValue()).append(")").append("\n");
                                playersWithOpponents.get(value.getKey()).forEach((s -> result.append(s).append("\n")));
                            });
        System.out.println(result);
    }

    private static StringBuilder getMatchInfo (String s2Name, long score) {
        StringBuilder builder = new StringBuilder();
        return builder.append("*   ").append(s2Name).append(" <-> ").append(score);
    }

    private static void fillData (String p1Name, String p2Name, long p1Score, long p2Score) {
        long currDiff = p1Score - p2Score;
        if (!playersWithOpponents.containsKey(p1Name)) {
            playersWithOpponents.put(p1Name, new LinkedList<>());
            playersWithOpponents.get(p1Name).add(getMatchInfo(p2Name, currDiff).toString());

            playersPointsOnly.put(p1Name, currDiff);
        }
        else {
            playersWithOpponents.get(p1Name).add(getMatchInfo(p2Name, currDiff).toString());

            playersPointsOnly.replace(p1Name, playersPointsOnly.get(p1Name) + currDiff);
        }
    }
}