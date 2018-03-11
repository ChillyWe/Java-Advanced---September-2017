package exam_preparations.examII.Problem04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Chilly on 20.10.2017 г..
 */
public class FootballStats {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, List<String>> data = new HashMap<>();
        HashMap<String, Long> totalScore = new HashMap<>();

        String inputLine = reader.readLine();
        while (!inputLine.equals("Season End")) {
            String[] matchData = inputLine.split("\\s+");
            String firstTeamName = matchData[0];
            String secondTeamName = matchData[2];
            String[] teamGoals = matchData[4].split(":");

            String firstTeamString = createString(firstTeamName, secondTeamName, Integer.parseInt(teamGoals[0]), Integer.parseInt(teamGoals[1]));
            String secondTeamString = createString(secondTeamName, firstTeamName, Integer.parseInt(teamGoals[1]), Integer.parseInt(teamGoals[0]));
            if (!data.containsKey(firstTeamName)) {
                data.put(firstTeamName, new ArrayList<>());
            }
            data.get(firstTeamName).add(firstTeamString);
            totalScore.putIfAbsent(firstTeamName,0L);
            totalScore.replace(firstTeamName, totalScore.get(firstTeamName) + Long.parseLong(teamGoals[0]));
            if(!data.containsKey(secondTeamName)) {
                data.put(secondTeamName, new ArrayList<>());
            }
            data.get(secondTeamName).add(secondTeamString);
            totalScore.putIfAbsent(secondTeamName,0L);
            totalScore.replace(secondTeamName, totalScore.get(secondTeamName) + Long.parseLong(teamGoals[1]));

            inputLine = reader.readLine();
        }

        LinkedHashMap<String,Long> sorted = totalScore.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1,e2) -> e1 ,LinkedHashMap::new));
        
        List<String> printThisTeams = Arrays.asList(reader.readLine().split(", "));
        for (Map.Entry<String, Long> kvp : sorted.entrySet()) {
            if(printThisTeams.contains(kvp.getKey())){
                data.get(kvp.getKey()).stream()
                        .sorted((t1,t2) -> t1.substring(0,t1.indexOf(" "))
                                .compareTo(t2.substring(0,t2.indexOf(" "))))
                        .forEach(t -> System.out.printf("%s - %s\n",kvp.getKey(),t));
            }
        }
    }

    private static String createString(String firstTeamN, String secondTeamN, int firstTeamG, int secondTeamG) {
        StringBuilder sb = new StringBuilder();
        sb.append(firstTeamN).append(" - ").append(secondTeamN).append(" -> ").append(firstTeamG).append(":").append(secondTeamG);
        return sb.toString();
    }
}