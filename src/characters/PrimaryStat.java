package characters;

import java.util.ArrayList;

public interface PrimaryStat {
    //Add a level to a character--------------------
    public void plusOneLevel();
    //Get characters base stats---------------------
    public int getBaseDexterity();
    public int getBaseStrength();
    public int getBaseIntelligence();
    //Check character lvl and multiply with level up stats to get total stats from level ups for current lvl----
    public int getLvlDexterity();
    public int getLvlStrength();
    public int getLvlIntelligence();
    //Get total stats (base+level*level increase)--------------
    public ArrayList<Integer> getTotalStats();
    public double calculateDamage();


}
