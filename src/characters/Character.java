package characters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import exceptions.InvalidArmorException;
import exceptions.InvalidWeaponException;
import items.BaseItem;
import items.armor.Armor;
import items.weapon.Weapon;

public abstract class Character implements PrimaryStat {
    private String name;
    private int level;
    private static Map<String, BaseItem> items;
    private ArrayList<String> usableArmor;
    private ArrayList<String> usableWeapon;
    private ArrayList<Integer> baseStats;
    private ArrayList<Integer> levelStats;

    public Character(String name, int level, ArrayList<String> usableArmor, ArrayList<String> usableWeapon,
                     ArrayList<Integer> baseStats, ArrayList<Integer> levelStats) {
        this.items = new HashMap<>();
        this.name = name;
        this.level = level;
        this.usableArmor = usableArmor;
        this.usableWeapon = usableWeapon;
        this.baseStats = baseStats;
        this.levelStats = levelStats;
    }

    @Override
    public void plusOneLevel() {
        this.level++;
    }
    public ArrayList<String> getUsableArmor() {
        return usableArmor;
    }
    public ArrayList<String> getUsableWeapon() {
        return usableWeapon;
    }
    public ArrayList<Integer> getBaseStats() {
        return baseStats;
    }
    public ArrayList<Integer> getLevelStats() {
        return levelStats;
    }
    public String getName() {
        return name;
    }
    public int getLevel() {
        return level;
    }
    public static Map<String, BaseItem> getItems() {
        return items;
    }
    public static BaseItem getItems(String key) {
        return items.get(key);
    }
    public static void setItems(String key, BaseItem item) {
        Character.items.put(key,item);
    }
    @Override
    public int getBaseDexterity() {
        return getBaseStats().get(0);
    }
    @Override
    public int getBaseStrength() {
        return getBaseStats().get(1);
    }
    @Override
    public int getBaseIntelligence() {
        return getBaseStats().get(2);
    }
    @Override
    public int getLvlDexterity() {  //Get total Dexterity at current level
        return getLevelStats().get(0) * getLevel();
    }
    @Override
    public int getLvlStrength() {   //Get total Strength at current level
        return getLevelStats().get(1) * getLevel();
    }
    @Override
    public int getLvlIntelligence() {   //Get total Intelligence at current level
        return getLevelStats().get(2) * getLevel();
    }
    //Get total (base + current level) stats for a character, return as a list [dexterity, strength, intelligence]
    @Override
    public ArrayList<Integer> getTotalStats() {
        ArrayList<Integer> total = new ArrayList<>();
        total.add(getBaseDexterity()+getLvlDexterity());
        total.add(getBaseStrength()+getLvlStrength());
        total.add(getBaseIntelligence()+getLvlIntelligence());
        return total;
    }
    // Check if armor type and level requirements are met
    public void equipArmor(String key, Armor armr) throws InvalidArmorException {
        for (int i = 0; i < getUsableArmor().size(); i++) {
            if(!armr.getArmorType().equals(getUsableArmor().get(i)) && i<getUsableArmor().size()-1){
                throw new InvalidArmorException("You cant use this armor");
            } else if (armr.getLvlReq()>getLevel()) {
                throw new InvalidArmorException("You cant use armor above your current level");
            } else {
                setItems(key, armr);
            }
        }
    }
    // Check if level and weapon type requirements are met
    public void equipWeapon(String key, Weapon weapon) throws InvalidWeaponException {
        for (int i = 0; i<getUsableWeapon().size(); i++){
            if(!weapon.getWeaponType().equals(getUsableWeapon().get(i)) && i<getUsableWeapon().size()-1){
                throw new InvalidWeaponException("You cant use this weapon");
            } else if (weapon.getLvlReq()>getLevel()) {
                throw new InvalidWeaponException("You cant use weapon above your current level");
            } else {
                setItems(key, weapon);
            }
        }
    }
}
