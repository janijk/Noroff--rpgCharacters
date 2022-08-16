package items.armor;

import items.BaseItem;

public class Armor extends BaseItem {
    private final String armorType;
    private final int dexterity;
    private final int strength;
    private final int intelligence;

    public Armor(String name, int lvlReq, String slot, String armorType,
                    int dexterity, int strength, int intelligence) {
        super(name, lvlReq, slot);
        this.dexterity = dexterity;
        this.strength = strength;
        this.intelligence = intelligence;
        this.armorType = armorType;         //What type of armor is e.g., Cloth, Mail
    }
    public String getArmorType() {
        return armorType;
    }
    public int getDexterity() {
        return dexterity;
    }
    public int getStrength() {
        return strength;
    }
    public int getIntelligence() {
        return intelligence;
    }
    @Override
    public String toString() {
        return "Cloth{" +
                "name='" + getName() + '\'' +
                ", lvlReq=" + getLvlReq() +
                ", slot='" + getSlot() + '\'' +
                ",armorType='" + getArmorType() + '\'' +
                ",dexterity='" + getDexterity() + '\'' +
                ",strength='" + getStrength() + '\'' +
                ",intelligence='" + getIntelligence() + '\'' +
                '}';
    }
}
