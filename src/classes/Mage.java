package classes;

import characters.Character;
import java.util.ArrayList;
import java.util.Arrays;

public class Mage extends Character{

    public Mage(String name) {
        super(
                name,
                "Intelligence",                //Primary damage dealing stat
                new ArrayList<>(Arrays.asList("Cloth")),    //Usable armor
                new ArrayList<>(Arrays.asList("Staff", "Wand")), //Usable weapons
                new ArrayList<>(Arrays.asList(1,1,8)),  //Base stats (Dexterity,Strength,Intelligence)
                new ArrayList<>(Arrays.asList(1,1,5))   //Stats increase per level (Dexterity,Strength,Intelligence)
        );
    }
    @Override
    public String toString() {
        return "Mage{" +
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
