import classes.Mage;
import items.armor.Cloth;
import items.weapon.Staff;

public class RPGCharacterApplication {
    public static void main(String[] args) {
        Mage jani = new Mage("Jani");
        System.out.println(jani);
        jani.plusOneLevel();
        jani.plusOneLevel();
        System.out.println(jani);

        Staff stick = new Staff("Atiesh",4,"Weapon",50,2.2);
        System.out.println(stick);

        Cloth robe = new Cloth("Fiery vest", 2,"Chest");
        System.out.println(robe);

    }
}
