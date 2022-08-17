package classes;

import characters.Character;

import java.util.ArrayList;
import java.util.Arrays;

public class Warrior extends Character {
    public Warrior(String name) {
        super(
                name,
                "Strength",                //Primary damage dealing stat
                new ArrayList<>(Arrays.asList("Mail", "Plate")),    //Usable armor
                new ArrayList<>(Arrays.asList("Axe","Hammer", "Sword")), //Usable weapons
                new ArrayList<>(Arrays.asList(2,5,1)),  //Base stats (Dexterity,Strength,Intelligence)
                new ArrayList<>(Arrays.asList(2,3,1))   //Stats increase per level (Dexterity,Strength,Intelligence)
        );
    }
    @Override
    public String toString() {
        return "Warrior{" +
                "name=" + getName()+
                ", level=" + getLevel()+
                ", baseDexterity=" + getBaseDexterity() +
                ", baseStrength=" + getBaseStrength() +
                ", baseIntelligence=" + getBaseIntelligence() +
                ", lvlDexterity=" + getLvlDexterity() +
                ", lvlStrength=" + getLvlStrength() +
                ", lvlIntelligence=" + getLvlIntelligence() +
                ", armour='"+ getUsableArmor() +  '\'' +
                ", weapon='"+ getUsableWeapon() +  '\'' +
                ", equipped='" + getItems() + '\'' +
                '}';
    }
}
