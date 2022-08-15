package characters;

import java.util.ArrayList;

public abstract class Character implements PrimaryStat {
    private String name;
    private int level;


    public Character(String name) {
        this.name = name;
        this.level = 1;
    }
    @Override
    public void plusOneLevel() {
        this.level++;
    }
    //Get total (base+level ups) stats for a character in a list [dexterity, strength, intelligence]
    @Override
    public ArrayList<Integer> getTotalStats() {
        ArrayList<Integer> total = new ArrayList<>();
        total.add(getLvlDexterity()+getLvlDexterity());
        total.add(getBaseStrength()+getLvlStrength());
        total.add(getBaseIntelligence()+getLvlIntelligence());
        return total;
    }
    public String getName() {
        return name;
    }
    public int getLevel() {
        return level;
    }

}
