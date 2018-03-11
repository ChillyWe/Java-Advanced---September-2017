package exam_preparations.prepare_for_re.p03_VLogger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Chilly on 02.01.2018 г..
 */
public class Main {
    private static Map<String, Logger> vloggers = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();
        while (line != null) {
            if ("Statistics".equals(line)) {
                statisticMethod();
                break;
            }
                String[] tokens = line.split("\\s+");
                String command = tokens[1];

                switch (command) {
                    case "joined":
                        createVlogger(tokens[0]);
                        break;
                    case "followed":
                        followMethod(tokens);
                        break;
                }
                line = reader.readLine();
            }
        }

    private static void statisticMethod() {
        int count = 1;

        List<Logger> loggers = new ArrayList<>(vloggers.values());
        loggers.sort(new LoggerComparator());
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("The V-Logger has a total of %d vloggers in its logs.", vloggers.size())).append(System.lineSeparator());
        for (Logger logger : loggers) {
            sb.append(String.format("%d. %s : %d followers, %d following"
                    , count++, logger.getName(), logger.getFollowers().size(), logger.getFollowed().size())).append(System.lineSeparator());
            if (logger.getFollowers().size() > 0 && count == 2) {
                List<String> followers = new ArrayList<>(logger.getFollowers());
                followers.sort(String::compareTo);
                for (String follower : followers) {
                    sb.append(String.format("*  %s", follower)).append(System.lineSeparator());
                }
            }
        }
        System.out.println(sb.toString());
    }

    private static void followMethod(String[] tokens) {
        String logger = tokens[2];
        String follower = tokens[0];

        if (vloggers.containsKey(logger) && vloggers.containsKey(follower) && !(logger.equals(follower))) {
            vloggers.get(logger).addFollowers(vloggers.get(follower).getName());
            vloggers.get(follower).addFollowed(vloggers.get(logger).getName());
        }
    }

    private static void createVlogger(String token) {
        Logger newLogger = new Logger(token);
        vloggers.putIfAbsent(newLogger.getName(), newLogger);
    }
}

class Logger {
    private String name;
    private List<String> followers;
    private List<String> followed;

    Logger(String name) {
        this.name = name;
        this.followers = new ArrayList<>();
        this.followed = new ArrayList<>();
    }

    String getName() {
        return this.name;
    }

    List<String> getFollowers() {
        return this.followers;
    }

    List<String> getFollowed() {
        return this.followed;
    }

    void addFollowers(String follower) {
        if (!followers.contains(follower)) {
            this.followers.add(follower);
        }
    }

    void addFollowed(String follow) {
        if (!followed.contains(follow)) {
            this.followed.add(follow);
        }
    }
}

class LoggerComparator implements Comparator<Logger> {
    public int compare(Logger log1, Logger log2) {
        int value1 = Integer.compare(log2.getFollowers().size(), (log1.getFollowers().size()));
        if (value1 == 0) {
            int value2 = Integer.compare(log1.getFollowed().size(), log2.getFollowed().size());
            return value2;
        }
        return value1;
    }
}