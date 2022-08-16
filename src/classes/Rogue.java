package classes;

import characters.Character;

import java.util.ArrayList;
import java.util.Arrays;

public class Rogue extends Character {
    public Rogue(String name) {
        super(
                name,
                "Dexterity",                //Primary damage dealing stat
                new ArrayList<>(Arrays.asList("Leather", "Mail")),    //Usable armor
                new ArrayList<>(Arrays.asList("Dagger", "Sword")), //Usable weapons
                new ArrayList<>(Arrays.asList(6,2,1)),  //Base stats (Dexterity,Strength,Intelligence)
                new ArrayList<>(Arrays.asList(4,1,1))   //Stats increase per level (Dexterity,Strength,Intelligence)
        );
    }
    @Override
    public String toString() {
        return "Rogue{" +
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
