import characters.Character;
import classes.Mage;
import classes.Ranger;
import classes.Rogue;
import classes.Warrior;
import exceptions.InvalidArmorException;
import exceptions.InvalidWeaponException;
import items.armor.Armor;
import items.weapon.Weapon;

import java.util.Scanner;

public class RPGCharacterApplication {
    /*
    Create character:       Character character = new Mage("Name");
    Create Weapon:          Weapon stick = new Weapon("Atiesh",1,"Weapon",1,1.1,"Staff");
    Create Armor:           Armor helm = new Armor("Bandana", 1,"Head","Cloth",1,1,1);
    Equip Armor:            character.equipArmor(String.valueOf(helm.getSlot()),helm);
    Equip Weapon:           character.equipWeapon(String.valueOf(stick.getSlot()),stick);
    Add one level:          character.plusOneLevel();
    Calculate dmg:          character.calculateDamage();
    Display all stats:      character.displayCharacterStatistics();
    */
    public static Character characterCreation(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(
                "Character creation:\nChoose class for your character:\n1.Mage, 2.Rogue, 3.Ranger, 4.Warrior, 5.Exit");
        int choice = scanner.nextInt();
        if (choice==5){
            return null;
        }
        scanner.nextLine();
        System.out.println("Choose name for your character:");
        String name = scanner.nextLine();
        if (choice==1){
            return new Mage(name);
        } else if (choice==2) {
            return new Rogue(name);
        } else if (choice==3) {
            return new Ranger(name);
        } else if (choice==4) {
           return new Warrior(name);
        }
        return null;
    }
    // Choose armor or weapon to create and equip
    public static Character equipItems(Character character) throws InvalidWeaponException, InvalidArmorException {
        Scanner scanner = new Scanner(System.in);
            System.out.println("Item Menu:");
            System.out.println("1.Create and equip new weapon\n2.Create and equip new armor\n3.Exit");
            int select = scanner.nextInt();
            switch (select){
                case 1:
                    Weapon weapon = createWeapon();
                    character.equipWeapon(weapon.getSlot(),weapon);
                    System.out.println(weapon.getName() + " Equipped!\n");
                    break;
                case 2:
                    Armor armor = createArmor();
                    character.equipArmor(armor.getSlot(),armor);
                    System.out.println(armor.getName() + " Equipped!\n");
                    break;
                case 3:
                    break;
            }
        return character;
    }
    public static Weapon createWeapon(){        // Create a weapon to equip
        String name,slot = "Weapon",type;
        int lvlReq, damage;
        double attackSpeed;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name your weapon:");
        name = scanner.nextLine();
        System.out.println("Choose type:\nAxe, Hammer, Sword, Staff, Wand, Bow, Dagger");
        type = scanner.nextLine();
        System.out.println("Level requirement:");
        lvlReq = scanner.nextInt();
        System.out.println("Damage:");
        damage = scanner.nextInt();
        System.out.println("Attack speed:");
        attackSpeed = scanner.nextDouble();
        scanner.nextLine();
        return new Weapon(name,lvlReq,slot,damage,attackSpeed,type);
    }
    public static Armor createArmor(){      // Create a piece of armor to equip
        String name,slot,type;
        int lvlReq, dexterity,strength,intelligence;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name your armor:");
        name = scanner.nextLine();
        System.out.println("Choose slot:\nHead, Chest, Legs");
        slot = scanner.nextLine();
        System.out.println("Choose type:\nCloth, Leather, Mail, Plate");
        type = scanner.nextLine();
        System.out.println("Level requirement:");
        lvlReq = scanner.nextInt();
        System.out.println("Dexterity:");
        dexterity = scanner.nextInt();
        System.out.println("Strength:");
        strength = scanner.nextInt();
        System.out.println("Intelligence:");
        intelligence = scanner.nextInt();
        return new Armor(name,lvlReq,slot,type,dexterity,strength,intelligence);
    }
    public static void main(String[] args) throws InvalidWeaponException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("<<<<Hello Gamer !>>>>");
        Character character = characterCreation();
        boolean goOn = true;
        do {
            System.out.println("Main Menu:");
            System.out.println("1.Create new character\n2.Equip items\n3.Level up\n4.Show stats\n5.Quit");
            int selection = scanner.nextInt();
            switch (selection){
                case 1:
                    character = characterCreation();
                    break;
                case 2:
                    try {
                        character = equipItems(character);
                    }catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                case 3:
                    character.plusOneLevel();
                    System.out.println("You reached level " + character.getLevel() + "!\n");
                    break;
                case 4:
                    System.out.println(character.displayCharacterStatistics());
                    break;
                case 5:
                    goOn=false;
                    System.out.println("You quit the game");
                    break;
            }

        }while (goOn);
    }
}
