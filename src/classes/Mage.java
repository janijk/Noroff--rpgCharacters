package classes;

import characters.Character;

public class Mage extends Character{
    private final int baseDexterity = 1;  //base dexterity
    private final int baseStrength = 1;  //base strength
    private final int baseIntelligence = 8;  //base intelligence
    private int lvlDexterity = 0;  //total dexterity gained on level ups
    private int lvlStrength = 0;  //total strength gained on level ups
    private int lvlIntelligence = 0;  //total intelligence gained on level ups
    private final String armour = "Cloth"; //what kind of armour can be used

    public Mage(String name) {
        super(name);
    }

    //Called on level up to add level and level-up-attributes to existing amounts
    @Override
    public void plusOneLevel() {
        this.lvlDexterity ++;
        this.lvlStrength ++;
        this.lvlIntelligence += 5;
        super.plusOneLevel();
    }

    public int getBaseDexterity() {
        return baseDexterity;
    }

    public int getBaseStrength() {
        return baseStrength;
    }

    public int getBaseIntelligence() {
        return baseIntelligence;
    }

    public int getLvlDexterity() {
        return lvlDexterity;
    }

    public int getLvlStrength() {
        return lvlStrength;
    }

    public int getLvlIntelligence() {
        return lvlIntelligence;
    }

    public String getArmour() {
        return armour;
    }

    @Override
    public String toString() {
        return "Mage{" +
                "level=" + getLevel()+
                ", baseDexterity=" + baseDexterity +
                ", baseStrength=" + baseStrength +
                ", baseIntelligence=" + baseIntelligence +
                ", lvlDexterity=" + lvlDexterity +
                ", lvlStrength=" + lvlStrength +
                ", lvlIntelligence=" + lvlIntelligence +
                ", armour='" + armour + '\'' +
                '}';
    }
}
