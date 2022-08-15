package items.weapon;

import items.BaseItem;

public class Staff extends BaseItem {
    private int damage;
    private double attackSpeed;
    private double dps;

    public Staff(String name, int lvlReq, String slot, int damage, double attackSpeed) {
        super(name, lvlReq, slot);
        this.damage = damage;                   //Weapons damage
        this.attackSpeed = attackSpeed;         //How many attack per second
        this.dps = damage * attackSpeed;        //Damage per second = damage * attack speed
    }

    public int getDamage() {
        return damage;
    }

    public double getAttackSpeed() {
        return attackSpeed;
    }

    public double getDps() {
        return dps;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "name='" + getName() + '\'' +
                ", lvlReq=" + getLvlReq() +
                ", slot='" + getSlot() + '\'' +
                ", damage=" + damage +
                ", attackSpeed=" + attackSpeed +
                ", dps=" + dps +
                '}';
    }
}
