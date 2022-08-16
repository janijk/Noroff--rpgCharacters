package characters;

import exceptions.InvalidArmorException;
import exceptions.InvalidWeaponException;
import items.armor.Armor;
import items.weapon.Weapon;

public interface Equip {
    public void equipArmor(String key, Armor armor) throws InvalidArmorException;
    public void equipWeapon(String key, Weapon weapon) throws InvalidWeaponException;

}
