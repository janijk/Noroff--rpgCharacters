package items.armor;

import items.BaseItem;

public class Cloth extends BaseItem {
    private final String armorType = "Cloth";       //Type of armor, in this case Cloth
                                    //Armour has dexterity, strength and intelligence

    public Cloth(String name, int lvlReq, String slot) {
        super(name, lvlReq, slot);
    }

    public String getArmorType() {
        return armorType;
    }

    @Override
    public String toString() {
        return "Cloth{" +
                "name='" + getName() + '\'' +
                ", lvlReq=" + getLvlReq() +
                ", slot='" + getSlot() + '\'' +
                ",armorType='" + armorType + '\'' +
                '}';
    }
}
