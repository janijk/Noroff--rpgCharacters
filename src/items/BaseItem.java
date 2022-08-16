package items;

import characters.PrimaryStat;

public abstract class BaseItem {
    private String name;      //Name of the item
    private int lvlReq;       //Level required to equip
    private String slot;      //Which slot item goes into

    public BaseItem(String name, int lvlReq, String slot) {
        this.name = name;
        this.lvlReq = lvlReq;
        this.slot = slot;
    }
    public String getName() {
        return name;
    }
    public int getLvlReq() {
        return lvlReq;
    }
    public String getSlot() {
        return slot;
    }
    @Override
    public String toString() {
        return "BaseItem{" +
                "name='" + name + '\'' +
                ", lvlReq=" + lvlReq +
                ", slot='" + slot + '\'' +
                '}';
    }
}
