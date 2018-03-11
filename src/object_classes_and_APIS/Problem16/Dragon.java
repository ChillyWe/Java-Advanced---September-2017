package object_classes_and_APIS.Problem16;//package Problem16;
//
///**
// * Created by Chilly on 10.10.2017 г..
// */
//public class Dragon {
//    private String name;
//    private int damage;
//    private int health;
//    private int armor;
//
//    public Dragon(String name, int[] stats) {
//        this.name = name;
//        this.damage = stats[0];
//        this.health = stats[1];
//        this.armor = stats[2];
//    }
//
//    public boolean compare(String name2) {
//        if (name.equals(name2)) {
//            return true;
//        }
//        return false;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public int getDamage() {
//        return damage;
//    }
//
//    public int getHealth() {
//        return health;
//    }
//
//    public int getArmor() {
//        return armor;
//    }
//
//    @Override
//    public String toString()
//    {
//        return String.format("-%s -> damage: %d, health: %d, armor: %d",
//                            this.name, this.damage, this.health, this.armor);
//    }
//}