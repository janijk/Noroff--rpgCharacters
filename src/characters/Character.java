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
    private String classPrimaryStat;
    private static Map<String, BaseItem> items;  //Items character has currently equipped
    private ArrayList<String> usableArmor;      //Details of armor character can use
    private ArrayList<String> usableWeapon;     //Details of weapons character can use
    private ArrayList<Integer> baseStats;       //Characters base stats (Dexterity,Strength,Intelligence)
    private ArrayList<Integer> levelStats;      //Characters stat increase per level (Dexterity,Strength,Intelligence)

    public Character(String name, String classPrimaryStat, ArrayList<String> usableArmor,
                     ArrayList<String> usableWeapon, ArrayList<Integer> baseStats, ArrayList<Integer> levelStats) {
        this.items = new HashMap<>();
        this.name = name;
        this.level = 1;
        this.classPrimaryStat = classPrimaryStat;
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

    public String getClassPrimaryStat() {return classPrimaryStat;}

    public static Map<String, BaseItem> getItems() {
        return items;
    }
    public static BaseItem getItems(String key) {
        return items.get(key);
    }
    // Equip a item for your character. Is called through equipArmor() and equipWeapon()
    // Key is items slot and value is item
    private static void setItems(String key, BaseItem item) {
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
        return getLevelStats().get(0) * (getLevel()-1);
    }
    @Override
    public int getLvlStrength() {   //Get total Strength at current level
        return getLevelStats().get(1) * (getLevel()-1);
    }
    @Override
    public int getLvlIntelligence() {   //Get total Intelligence at current level
        return getLevelStats().get(2) * (getLevel()-1);
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
    // Check if armor type and level requirements are met when equipping a armor
    // Key is armor slot and value is armor
    public void equipArmor(String key, Armor armr) throws InvalidArmorException {
        boolean cantUse = true;
        for (String str: getUsableArmor()){
            if (str.equals(armr.getArmorType())){
                cantUse = false;
            }
        }
            if(cantUse){
                throw new InvalidArmorException("You cant use " + armr.getArmorType()+" armor");
            } else if (armr.getLvlReq()>getLevel()) {
                throw new InvalidArmorException("You cant use armor above your current level");
            } else {
                setItems(key, armr);
            }
    }
    // Check if level and weapon type requirements are met when equipping a weapon
    // Key is weapons slot and value is weapon
    public void equipWeapon(String key, Weapon weapon) throws InvalidWeaponException {
            boolean cantUse = true;
            for (String str: getUsableWeapon()){
                if (str.equals(weapon.getWeaponType())){
                    cantUse = false;
                }
            }
            if(cantUse){
                throw new InvalidWeaponException("You cant use "+weapon.getWeaponType()+"s");
            } else if (weapon.getLvlReq()>getLevel()) {
                throw new InvalidWeaponException("You cant use weapon above your current level");
            } else {
                setItems(key, weapon);
            }
    }
    // Calculate character damage by calculating sum of primary stats,
    // combined with armor stats and multiplied with weapon dps
    @Override
    public double calculateDamage() {
        Map<String, BaseItem> itemsCurrentlyEquipped = getItems();
        String characterPrimaryStat = getClassPrimaryStat();
        int dexterity = getTotalStats().get(0);     // Characters total dexterity
        int strength = getTotalStats().get(1);      // Characters total strength
        int intelligence = getTotalStats().get(2);  // Characters total intelligence
        double weaponDps = 1;                       // Weapon dps, if no weapon then 1
        // Loop through armors equipped and add their stats to previously declared dexterity,strength,intelligence
        for (String item : itemsCurrentlyEquipped.keySet()){
            if (itemsCurrentlyEquipped.get(item).getSlot() != "Weapon"){
                Armor armor = (Armor) itemsCurrentlyEquipped.get(item);
                dexterity += armor.getDexterity();
                strength += armor.getStrength();
                intelligence += armor.getIntelligence();
            } else if (itemsCurrentlyEquipped.get(item).getSlot() == "Weapon") {
                Weapon weapon = (Weapon) itemsCurrentlyEquipped.get(item);
                weaponDps = weapon.getDps();
            }
        }
        // Calculate character dps from primary stat and weapon dps
        if (characterPrimaryStat == "Dexterity"){
            return weaponDps * (1+dexterity/100.0);
        } else if (characterPrimaryStat == "Strength") {
            return weaponDps * (1+strength/100.0);
        }else {
            return weaponDps * (1+intelligence/100.0);
        }
    }
    public StringBuilder displayCharacterStatistics(){
        Map<String, BaseItem> itemsCurrentlyEquipped = getItems();
        String characterPrimaryStat = getClassPrimaryStat();
        int dexterity = getTotalStats().get(0);     // Characters total dexterity
        int strength = getTotalStats().get(1);      // Characters total strength
        int intelligence = getTotalStats().get(2);  // Characters total intelligence
        double weaponDps = 1;                       // Weapon dps, if no weapon then 1
        double characterDps;
        // Loop through armors equipped and add their stats to previously declared dexterity,strength,intelligence
        for (String item : itemsCurrentlyEquipped.keySet()){
            if (itemsCurrentlyEquipped.get(item).getSlot() != "Weapon"){
                Armor armor = (Armor) itemsCurrentlyEquipped.get(item);
                dexterity += armor.getDexterity();
                strength += armor.getStrength();
                intelligence += armor.getIntelligence();
            } else if (itemsCurrentlyEquipped.get(item).getSlot() == "Weapon") {
                Weapon weapon = (Weapon) itemsCurrentlyEquipped.get(item);
                weaponDps = weapon.getDps();
            }
        }
        // Calculate character dps from primary stat and weapon dps
        if (characterPrimaryStat == "Dexterity"){
            characterDps = weaponDps * (1+dexterity/100.0);
        } else if (characterPrimaryStat == "Strength") {
            characterDps = weaponDps * (1+strength/100.0);
        }else {
            characterDps = weaponDps * (1+intelligence/100.0);
        }
        // Create a sheet containing characters statistics with string builder
        StringBuilder builder = new StringBuilder();
        builder.append("[----- STATISTICS -----]\n");
        builder.append("Name:           ");
        builder.append(getName()+"\n");
        builder.append("Level:          ");
        builder.append(getLevel()+"\n");
        builder.append("Dexterity:      ");
        builder.append(dexterity+"\n");
        builder.append("Strength:       ");
        builder.append(strength+"\n");
        builder.append("Intelligence:   ");
        builder.append(intelligence+"\n");
        builder.append("DPS:            ");
        builder.append(characterDps+"\n");
        builder.append("[----------------------]\n");
        return builder;
    }
}