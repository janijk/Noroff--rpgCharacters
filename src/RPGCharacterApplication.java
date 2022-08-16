import characters.Character;
import classes.Mage;
import exceptions.InvalidArmorException;
import exceptions.InvalidWeaponException;
import items.armor.Armor;
import items.weapon.Weapon;

public class RPGCharacterApplication {
    public static void main(String[] args) {
        Mage jani = new Mage("Jani");
        System.out.println(jani);
        jani.plusOneLevel();
        jani.plusOneLevel();
        //Create armors and weapon
        Weapon stick = new Weapon("Atiesh",3,"Weapon",50,2.2,"Staff");
        Armor helm = new Armor("Bandana", 2,"Head","Cloth",2,2,2);
        Armor robe = new Armor("Fiery vest", 2,"Chest", "Mail",1,1,1);
        Armor trousers = new Armor("Levis",3,"Legs", "Cloth",2,2,2);

        try {
            jani.equipArmor(String.valueOf(trousers.getSlot()),trousers);
            jani.equipArmor(String.valueOf(robe.getSlot()),robe);
            jani.equipArmor(String.valueOf(helm.getSlot()),helm);
        }catch (InvalidArmorException e){
            System.out.println(e);
        }
        try {
            jani.equipWeapon(String.valueOf(stick.getSlot()),stick);;
        }catch (InvalidWeaponException e){
            System.out.println(e);
        }
        //System.out.println("USABLE WPN: "+jani.getUsableWeapon().get(0));
        System.out.println("GET ITEMS: "+jani.getItems());
        System.out.println(jani.calculateDamage());
        System.out.println(jani.displayCharacterStatistics());

    }
}
