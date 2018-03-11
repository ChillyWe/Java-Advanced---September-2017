package object_classes_and_APIS.Problem16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Chilly on 10.10.2017 г..
 */
public class DragonArmy {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<String, List<Dragon>> dragonData = new LinkedHashMap<>();

        int n = Integer.parseInt(reader.readLine());

        fillDragonData(reader, dragonData, n);

        print(dragonData);
    }

    private static void print(LinkedHashMap<String, List<Dragon>> dragonData) {
        Comparator<Dragon> byName = (a, b) -> a.getName().compareTo(b.getName());
        for (Map.Entry<String, List<Dragon>> kvp : dragonData.entrySet()) {
            String type = kvp.getKey();
            List<Dragon> dragons = kvp.getValue();
            double averageDamage = 0;
            double averageHealth = 0;
            double averageArmor = 0;
            for (Dragon dragon : dragons) {
                averageDamage += dragon.getDamage();
                averageHealth += dragon.getHealth();
                averageArmor += dragon.getArmor();
            }
            averageDamage = calculate(averageDamage, dragons.size());
            averageHealth = calculate(averageHealth, dragons.size());
            averageArmor = calculate(averageArmor, dragons.size());
            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", type, averageDamage, averageHealth, averageArmor);
            for (Dragon dragon : dragons.stream()
                    .sorted(byName).collect(Collectors.toList())) {
                System.out.println(dragon.toString());
            }
        }
    }

    private static double calculate(double number, int length) {
        return number / length;
    }

    private static void fillDragonData(BufferedReader reader, LinkedHashMap<String, List<Dragon>> dragonData, int n) throws IOException {
        for (int i = 0; i < n; i++) {
            List<String> inputTokens = Arrays.stream(reader.readLine().split("\\s+"))
                                            .collect(Collectors.toList());
            String type = inputTokens.get(0);
            String name = inputTokens.get(1);
            int[] stats = setStats(inputTokens, new int[3]);

            if(dragonData.containsKey(type)) {
                List<Dragon> list = dragonData.get(type);
                boolean dragonIsThere = false;
                int j;
                for (j = 0; j < list.size(); j++) {
                    dragonIsThere = list.get(j).compare(name);
                    if (dragonIsThere){
                        break;
                    }
                }
                if (dragonIsThere) {
                    dragonData.get(type).remove(j);
                    dragonData.get(type).add(new Dragon(name, stats));
                }
                else {
                    dragonData.get(type).add(new Dragon(name, stats));
                }
            }
            else {
                dragonData.put(type, new ArrayList<>());
                dragonData.get(type).add(new Dragon(name, stats));
            }
        }
    }

    private static int[] setStats(List<String> inputTokens, int[] stats) {
        for (int j = 2; j < 5; j++) {
            try {
                int currStat = Integer.parseInt(inputTokens.get(j));
                stats[j - 2] = currStat;
            }
            catch (Exception nulL) {
                if(inputTokens.get(j).equals("null"));
                switch (j) {
                    case 2: stats[0] = 45; break;
                    case 3: stats[1] = 250; break;
                    case 4: stats[2] = 10; break;
                }
            }
        }
        return stats;
    }
}

class Dragon {
    private String name;
    private int damage;
    private int health;
    private int armor;

    public Dragon(String name, int[] stats) {
        this.name = name;
        this.damage = stats[0];
        this.health = stats[1];
        this.armor = stats[2];
    }

    public boolean compare(String name2) {
        if (name.equals(name2)) {
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public int getHealth() {
        return health;
    }

    public int getArmor() {
        return armor;
    }

    @Override
    public String toString()
    {
        return String.format("-%s -> damage: %d, health: %d, armor: %d",
                this.name, this.damage, this.health, this.armor);
    }
}