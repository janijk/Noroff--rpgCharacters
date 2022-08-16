package items.weapon;

import items.BaseItem;

public class Weapon extends BaseItem {
    private int damage;
    private double attackSpeed;
    private double dps;
    private String weaponType;

    public Weapon(String name, int lvlReq, String slot, int damage, double attackSpeed, String weaponType) {
        super(name, lvlReq, slot);
        this.damage = damage;                   //Weapons damage
        this.attackSpeed = attackSpeed;         //How many attacks per second
        this.dps = damage * attackSpeed;        //Damage per second = damage * attack speed
        this.weaponType = weaponType;           //What type of weapon is e.g., Axe, Staff, Bow
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
    public String getWeaponType() {
        return weaponType;
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
                ", type=" + weaponType +
                '}';
    }
}
