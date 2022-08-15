package characters;

import java.util.ArrayList;

public interface PrimaryStat {
    public void plusOneLevel();
    public int getBaseDexterity();
    public int getBaseStrength();
    public int getBaseIntelligence();
    public int getLvlDexterity();
    public int getLvlStrength();
    public int getLvlIntelligence();
    public ArrayList<Integer> getTotalStats();
}
