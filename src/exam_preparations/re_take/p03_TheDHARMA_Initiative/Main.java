package exam_preparations.re_take.p03_TheDHARMA_Initiative;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.*;
        import java.util.stream.Collectors;

/**
 * Created by Chilly on 03.01.2018 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Map<Integer, String>> stations = new TreeMap<>();
        stations.put("Hydra", new HashMap<>());
        stations.put("Arrow", new HashMap<>());
        stations.put("Flame", new HashMap<>());
        stations.put("Pearl", new HashMap<>());
        stations.put("Orchid", new HashMap<>());

        String line = reader.readLine();
        while (!"Recruit".equals(line)) {
            String[] inputTokens = line.split(":");
            String recName = inputTokens[0];
            int recNumber = Integer.parseInt(inputTokens[1]);
            String stationName = inputTokens[2];

            if (stations.containsKey(stationName)) {
                stations.get(stationName).putIfAbsent(recNumber, recName);
            }

            line = reader.readLine();
        }

        String[] lastCommand = reader.readLine().split("\\s+");
        if (lastCommand.length == 1) {
            StringBuilder sb = new StringBuilder();
            switch (lastCommand[0]) {
                case "Hydra":
                    sb.append("The Hydra station: Zoological Research.").append(System.lineSeparator());
                    Map<Integer, String> hydra = stations.get("Hydra").entrySet()
                            .stream()
                            .sorted(Map.Entry.comparingByKey(Collections.reverseOrder()))
                            .collect(Collectors.toMap(
                                    Map.Entry::getKey,
                                    Map.Entry::getValue,
                                    (e1, e2) -> e1,
                                    LinkedHashMap::new
                            ));
                    if (hydra.size() == 0) {
                        sb.append("No recruits.").append(System.lineSeparator());
                    } else {
                        for (Map.Entry<Integer, String> recStats : hydra.entrySet()) {
                            sb.append(String.format("###%s - %d", recStats.getValue(), recStats.getKey())).append(System.lineSeparator());
                        }
                    }
                    break;
                case "Arrow":
                    sb.append("The Arrow station: Development of defensive strategies, and Intelligence gathering.").append(System.lineSeparator());
                    Map<Integer, String> arrow = stations.get("Arrow").entrySet()
                            .stream()
                            .sorted(Map.Entry.comparingByKey(Collections.reverseOrder()))
                            .collect(Collectors.toMap(
                                    Map.Entry::getKey,
                                    Map.Entry::getValue,
                                    (e1, e2) -> e1,
                                    LinkedHashMap::new
                            ));
                    if (arrow.size() == 0) {
                        sb.append("No recruits.").append(System.lineSeparator());
                    } else {
                        for (Map.Entry<Integer, String> recStats : arrow.entrySet()) {
                            sb.append(String.format("###%s - %d", recStats.getValue(), recStats.getKey())).append(System.lineSeparator());
                        }
                    }
                    break;
                case "Flame":
                    sb.append("The Flame station: Communication.").append(System.lineSeparator());
                    Map<Integer, String> flame = stations.get("Flame").entrySet()
                            .stream()
                            .sorted(Map.Entry.comparingByKey(Collections.reverseOrder()))
                            .collect(Collectors.toMap(
                                    Map.Entry::getKey,
                                    Map.Entry::getValue,
                                    (e1, e2) -> e1,
                                    LinkedHashMap::new
                            ));
                    if (flame.size() == 0) {
                        sb.append("No recruits.").append(System.lineSeparator());
                    } else {
                        for (Map.Entry<Integer, String> recStats : flame.entrySet()) {
                            sb.append(String.format("###%s - %d", recStats.getValue(), recStats.getKey())).append(System.lineSeparator());
                        }
                    }
                    break;
                case "Pearl":
                    sb.append("The Pearl station: Psychological Research and/or Observation.").append(System.lineSeparator());
                    Map<Integer, String> pearl = stations.get("Pearl").entrySet()
                            .stream()
                            .sorted(Map.Entry.comparingByKey(Collections.reverseOrder()))
                            .collect(Collectors.toMap(
                                    Map.Entry::getKey,
                                    Map.Entry::getValue,
                                    (e1, e2) -> e1,
                                    LinkedHashMap::new
                            ));
                    if (pearl.size() == 0) {
                        sb.append("No recruits.").append(System.lineSeparator());
                    } else {
                        for (Map.Entry<Integer, String> recStats : pearl.entrySet()) {
                            sb.append(String.format("###%s - %d", recStats.getValue(), recStats.getKey())).append(System.lineSeparator());
                        }
                    }
                    break;
                case "Orchid":
                    sb.append("The Orchid station: Space-time manipulation research, disguised as a Botanical station.").append(System.lineSeparator());
                    Map<Integer, String> orchid = stations.get("Orchid").entrySet()
                            .stream()
                            .sorted(Map.Entry.comparingByKey(Collections.reverseOrder()))
                            .collect(Collectors.toMap(
                                    Map.Entry::getKey,
                                    Map.Entry::getValue,
                                    (e1, e2) -> e1,
                                    LinkedHashMap::new
                            ));
                    if (orchid.size() == 0) {
                        sb.append("No recruits.").append(System.lineSeparator());
                    } else {
                        for (Map.Entry<Integer, String> recStats : orchid.entrySet()) {
                            sb.append(String.format("###%s - %d", recStats.getValue(), recStats.getKey())).append(System.lineSeparator());
                        }
                    }
                    break;
                default:
                    sb.append("DHARMA Initiative does not have such a station!").append(System.lineSeparator());
                    break;
            }
            System.out.println(sb.toString());
        } else if ("DHARMA".equals(lastCommand[0])) {
            StringBuilder sb = new StringBuilder();

            stations.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue((a,b) -> Integer.compare(b.size(), a.size())))
                    .forEach(v ->  sb.append(String.format("The %s has %d DHARMA recruits in it.", v.getKey(), v.getValue().size())).append(System.lineSeparator()));
            System.out.println(sb.toString().trim());
        }
    }
}