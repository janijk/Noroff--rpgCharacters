package characters;

import stats.PrimaryStat;

public abstract class Character implements LevelUp {
    private String name;
    private int level;
    PrimaryStat primaryStat;


    public Character(String name) {
        this.name = name;
        this.level = 1;

    }

    @Override
    public void plusOneLevel() {
        this.level++;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

}
