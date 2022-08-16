package items;

import characters.PrimaryStat;

public abstract class BaseItem {
    private String name;
    private int lvlReq;
    private String slot;

    public BaseItem(String name, int lvlReq, String slot) {
        this.name = name;       //Name of the item
        this.lvlReq = lvlReq;   //Level required to equip
        this.slot = slot;       //Which slot item goes into
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
