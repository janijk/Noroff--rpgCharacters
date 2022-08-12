import classes.Mage;

public class RPGCharacterApplication {
    public static void main(String[] args) {
        Mage jani = new Mage("Jani");
        System.out.println(jani);
        jani.plusOneLevel();
        jani.plusOneLevel();
        System.out.println(jani);


    }
}
