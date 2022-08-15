package classes;

import characters.Character;

public class Mage extends Character{
    private final String armor = "Cloth"; //what kind of armor can be used

    public Mage(String name) {
        super(name);
    }
    @Override
    public int getBaseDexterity() {
        return 1;
    }
    @Override
    public int getBaseStrength() {
        return 1;
    }
    @Override
    public int getBaseIntelligence() {
        return 8;
    }
    //Check character lvl and multiply with level up stats to get total--------
    //stats from level ups for current lvl
    @Override
    public int getLvlDexterity() {
        return getLevel();
    }
    @Override
    public int getLvlStrength() {
        return getLevel();
    }
    @Override
    public int getLvlIntelligence() {
        return getLevel()*5;
    }
    //--------------------------------------------------------------------------
    public String getArmour() {
        return armor;
    }
    @Override
    public String toString() {
        return "Mage{" +
                "name=" + getName()+
                ", level=" + getLevel()+
                ", baseDexterity=" + getBaseDexterity() +
                ", baseStrength=" + getBaseStrength() +
                ", baseIntelligence=" + getBaseIntelligence() +
                ", lvlDexterity=" + getLvlDexterity() +
                ", lvlStrength=" + getLvlStrength() +
                ", lvlIntelligence=" + getLvlIntelligence() +
                ", armour='" + armor + '\'' +
                '}';
    }
}
