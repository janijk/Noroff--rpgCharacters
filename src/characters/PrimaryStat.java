package characters;

import java.util.ArrayList;

public interface PrimaryStat {
    //Add a level to a character
    public void plusOneLevel();
    //Get characters base stats
    public int getBaseDexterity();
    public int getBaseStrength();
    public int getBaseIntelligence();
    //Check character level and multiply it with level up stats to get total stats from level ups for current level
    public int getLvlDexterity();
    public int getLvlStrength();
    public int getLvlIntelligence();
    //Get total stats (baseStats + level * statsPerEachLevel)
    public ArrayList<Integer> getTotalStats();
    //Calculate characters dps
    public double calculateDamage();


}
