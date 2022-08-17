package characters;

import classes.Mage;
import classes.Ranger;
import classes.Rogue;
import classes.Warrior;
import exceptions.InvalidArmorException;
import items.BaseItem;
import items.armor.Armor;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CharacterTest {
    @Test
    public void getName_characterIsCreatedGetItsName_returnName(){
        //Arrange
        Mage mage = new Mage("Name");
        String expected = "Name";
        //Act
        String actual = mage.getName();
        //Assert
        assertEquals(expected,actual);
    }
    @Test
    public void getLevel_characterIsCreatedGetItsCurrentLevel_returnCurrentLevel(){
        //Arrange
        Mage mage = new Mage("Name");
        int expected = 1;
        //Act
        int actual = mage.getLevel();
        //Assert
        assertEquals(expected,actual);
    }
    @Test
    public void getClassPrimaryStat_characterIsCreatedGetItsPrimaryDamageDealingStat_returnDamageDealingStat(){
        //Arrange
        Mage mage = new Mage("Name");
        String expected = "Intelligence";
        //Act
        String actual = mage.getClassPrimaryStat();
        //Assert
        assertEquals(expected,actual);
    }
    @Test
    public void getBaseStats_characterIsCreatedGetItsBaseStats_returnListOfBaseStats(){
        //Arrange
        Mage mage = new Mage("Name");
        List<Integer> expected = new ArrayList<>(Arrays.asList(1,1,8));
        //Act
        List<Integer> actual = mage.getBaseStats();
        //Assert
        assertEquals(expected,actual);
    }
    @Test
    public void getLevelStats_characterIsCreatedGetItsLevelIncreaseStats_returnListOfLevelIncreaseStats(){
        //Arrange
        Mage mage = new Mage("Name");
        List<Integer> expected = new ArrayList<>(Arrays.asList(1,1,5));
        //Act
        List<Integer> actual = mage.getLevelStats();
        //Assert
        assertEquals(expected,actual);
    }
    @Test
    public void getUsableArmor_characterIsCreatedGetInfoAboutArmorItCanUse_returnListOfArmorsItCanUse(){
        //Arrange
        Mage mage = new Mage("Name");
        List<String> expected = new ArrayList<>(Arrays.asList("Cloth"));
        //Act
        List<String> actual = mage.getUsableArmor();
        //Assert
        assertEquals(expected,actual);
    }
    @Test
    public void getUsableWeapon_characterIsCreatedGetInfoAboutWeaponItCanUse_returnListOfWeaponsItCanUse(){
        //Arrange
        Mage mage = new Mage("Name");
        List<String> expected = new ArrayList<>(Arrays.asList("Staff", "Wand"));
        //Act
        List<String> actual = mage.getUsableWeapon();
        //Assert
        assertEquals(expected,actual);
    }
    @Test
    public void getTotalStats_getCharactersTotalStatsAsAListWhenAtHigherLevelThanOne_GetListOfTotalStatsAtCurrentLevel(){
        //Arrange
        Mage mage = new Mage("Name");
        mage.plusOneLevel();
        List<Integer> expected = new ArrayList<>(Arrays.asList(2,2,13));
        //Act
        List<Integer> actual = mage.getTotalStats();
        //Assert
        assertEquals(expected,actual);
    }
    @Test
    public void character_isCalledFromMageThroughSuperConstructor_characterIsAtLevelOne() {
        //Arrange
        Mage mage = new Mage("Name");
        int expected = 1;
        //Act
        int actual = mage.getLevel();
        //Assert
        assertEquals(expected,actual);
    }
    @Test
    public void plusOneLevel_oneLevelIsAddedToCharactersCurrentLevel_characterIsAtLevelTwo() {
        //Arrange
        Mage mage = new Mage("Name");
        mage.plusOneLevel();
        int expected = 2;
        //Act
        int actual = mage.getLevel();
        //Assert
        assertEquals(expected,actual);
    }
    @Test
    public void mage_characterHasCorrectBaseStatsInCreation_characterHasCorrectStats(){
        //Arrange
        Mage mage = new Mage("Name");
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(1,1,8)); //(Dexterity,Strength,Intelligence)
        //Act
        ArrayList<Integer> actual = mage.getBaseStats();
        //Assert
        assertEquals(expected,actual);
    }
    @Test
    public void rogue_characterHasCorrectBaseStatsInCreation_characterHasCorrectStats(){
        //Arrange
        Rogue rogue = new Rogue("Name");
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(6,2,1)); //(Dexterity,Strength,Intelligence)
        //Act
        ArrayList<Integer> actual = rogue.getBaseStats();
        //Assert
        assertEquals(expected,actual);
    }
    @Test
    public void ranger_characterHasCorrectBaseStatsInCreation_characterHasCorrectStats(){
        //Arrange
        Ranger ranger = new Ranger("Name");
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(7,1,1)); //(Dexterity,Strength,Intelligence)
        //Act
        ArrayList<Integer> actual = ranger.getBaseStats();
        //Assert
        assertEquals(expected,actual);
    }
    @Test
    public void warrior_characterHasCorrectBaseStatsInCreation_characterHasCorrectStats(){
        //Arrange
        Warrior warrior = new Warrior("Name");
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(2,5,1)); //(Dexterity,Strength,Intelligence)
        //Act
        ArrayList<Integer> actual = warrior.getBaseStats();
        //Assert
        assertEquals(expected,actual);
    }
    @Test
    public void mage_characterHasCorrectStatsAfterLevelUp_characterHasCorrectStats(){
        //Arrange
        Mage mage = new Mage("Name");
        mage.plusOneLevel();
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(2,2,13)); //(Dexterity,Strength,Intelligence)
        //Act
        ArrayList<Integer> actual = mage.getTotalStats();
        //Assert
        assertEquals(expected,actual);
    }
    @Test
    public void rogue_characterHasCorrectStatsAfterLevelUp_characterHasCorrectStats(){
        //Arrange
        Rogue rogue = new Rogue("Name");
        rogue.plusOneLevel();
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(10,3,2)); //(Dexterity,Strength,Intelligence)
        //Act
        ArrayList<Integer> actual = rogue.getTotalStats();
        //Assert
        assertEquals(expected,actual);
    }
    @Test
    public void ranger_characterHasCorrectStatsAfterLevelUp_characterHasCorrectStats(){
        //Arrange
        Ranger ranger = new Ranger("Name");
        ranger.plusOneLevel();
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(12,2,2)); //(Dexterity,Strength,Intelligence)
        //Act
        ArrayList<Integer> actual = ranger.getTotalStats();
        //Assert
        assertEquals(expected,actual);
    }
    @Test
    public void warrior_characterHasCorrectStatsAfterLevelUp_characterHasCorrectStats(){
        //Arrange
        Warrior warrior = new Warrior("Name");
        warrior.plusOneLevel();
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(4,8,2)); //(Dexterity,Strength,Intelligence)
        //Act
        ArrayList<Integer> actual = warrior.getTotalStats();
        //Assert
        assertEquals(expected,actual);
    }
}