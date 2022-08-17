package classes;

import characters.Character;

import java.util.ArrayList;
import java.util.Arrays;

public class Ranger extends Character {
    public Ranger(String name) {
        super(
                name,
                "Dexterity",                //Primary damage dealing stat
                new ArrayList<>(Arrays.asList("Leather", "Mail")),    //Armor type this class can use
                new ArrayList<>(Arrays.asList("Bow")), //Weapons this class can use
                new ArrayList<>(Arrays.asList(7,1,1)),  //Base stats (Dexterity,Strength,Intelligence)
                new ArrayList<>(Arrays.asList(5,1,1))   //Stats increase per level (Dexterity,Strength,Intelligence)
        );
    }
    @Override
    public String toString() {
        return "Ranger{" +
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
