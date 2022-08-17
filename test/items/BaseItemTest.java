package items;

import classes.Mage;
import exceptions.InvalidArmorException;
import exceptions.InvalidWeaponException;
import items.armor.Armor;
import items.weapon.Weapon;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaseItemTest {
    @Test
    public void getIntelligence_armorIsCreated_shouldReturnItsIntelligenceStat(){
        //Arrange
        Armor armor = new Armor("Chest armor",2,"Chest","Cloth",1,1,1);
        int expected = 1;
        //Act
        int actual = armor.getIntelligence();
        //Assert
        assertEquals(expected,actual);
    }
    @Test
    public void getStrength_armorIsCreated_shouldReturnItsStrengthStat(){
        //Arrange
        Armor armor = new Armor("Chest armor",2,"Chest","Cloth",1,1,1);
        int expected = 1;
        //Act
        int actual = armor.getStrength();
        //Assert
        assertEquals(expected,actual);
    }
    @Test
    public void getDexterity_armorIsCreated_shouldReturnItsDexterityStat(){
        //Arrange
        Armor armor = new Armor("Chest armor",2,"Chest","Cloth",1,1,1);
        int expected = 1;
        //Act
        int actual = armor.getDexterity();
        //Assert
        assertEquals(expected,actual);
    }
    @Test
    public void getArmorType_armorIsCreated_shouldReturnItsType(){
        //Arrange
        Armor armor = new Armor("Chest armor",2,"Chest","Cloth",1,1,1);
        String expected = "Cloth";
        //Act
        String actual = armor.getArmorType();
        //Assert
        assertEquals(expected,actual);
    }
    @Test
    public void getName_itemIsCreated_shouldReturnItsName(){
        //Arrange
        Weapon weapon = new Weapon("Stick",1,"Weapon",1,1,"Staff");
        String expected = "Stick";
        //Act
        String actual = weapon.getName();
        //Assert
        assertEquals(expected,actual);
    }
    @Test
    public void getLvlReq_itemIsCreated_shouldReturnItsRequiredLevel(){
        //Arrange
        Weapon weapon = new Weapon("Stick",1,"Weapon",1,1,"Staff");
        int expected = 1;
        //Act
        int actual = weapon.getLvlReq();
        //Assert
        assertEquals(expected,actual);
    }
    @Test
    public void getSlot_itemIsCreated_shouldReturnItsSlot(){
        //Arrange
        Weapon weapon = new Weapon("Stick",1,"Weapon",1,1,"Staff");
        String expected = "Weapon";
        //Act
        String actual = weapon.getSlot();
        //Assert
        assertEquals(expected,actual);
    }
    @Test
    public void getDamage_weaponIsCreated_shouldReturnItsDamage(){
        //Arrange
        Weapon weapon = new Weapon("Stick",1,"Weapon",1,1,"Staff");
        int expected = 1;
        //Act
        int actual = weapon.getDamage();
        //Assert
        assertEquals(expected,actual);
    }
    @Test
    public void getAttackSpeed_weaponIsCreated_shouldReturnItsAttackSpeed(){
        //Arrange
        Weapon weapon = new Weapon("Stick",1,"Weapon",1,1,"Staff");
        double expected = 1;
        //Act
        double actual = weapon.getAttackSpeed();
        //Assert
        assertEquals(expected,actual);
    }
    @Test
    public void getDps_weaponIsCreated_shouldReturnItsDps(){
        //Arrange
        Weapon weapon = new Weapon("Stick",1,"Weapon",1,1,"Staff");
        double expected = 1;
        //Act
        double actual = weapon.getDps();
        //Assert
        assertEquals(expected,actual);
    }
    @Test
    public void getWeaponType_weaponIsCreated_shouldReturnItsType(){
        //Arrange
        Weapon weapon = new Weapon("Stick",1,"Weapon",1,1,"Staff");
        String expected = "Staff";
        //Act
        String actual = weapon.getWeaponType();
        //Assert
        assertEquals(expected,actual);
    }
    @Test
    public void equipWeapon_equipWeaponOverCharactersLevel_throwInvalidWeaponException(){
        //Arrange
        Mage mage = new Mage("Name");
        Weapon weapon = new Weapon("Stick",2,"Weapon",1,1,"Staff");
        String expected = "You cant use weapon above your current level";
        //Act
        Exception e =assertThrows(Exception.class, ()->mage.equipWeapon(String.valueOf(weapon.getSlot()),weapon));
        String actual = e.getMessage();
        //Assert
        assertEquals(expected,actual);
    }
    @Test
    public void equipWeapon_equipWeaponWhichHasTypeClassCantUse_throwInvalidWeaponException(){
        //Arrange
        Mage mage = new Mage("Name");
        Weapon weapon = new Weapon("Stick",1,"Weapon",1,1,"Axe");
        String expected = "You cant use Axes";
        //Act
        Exception e =assertThrows(Exception.class, ()->mage.equipWeapon(String.valueOf(weapon.getSlot()),weapon));
        String actual = e.getMessage();
        //Assert
        assertEquals(expected,actual);
    }
    @Test
    public void equipWeapon_characterCanEquipWeaponIfRequirementsForLevelAndTypeAreMet_canEquipWeapon() throws InvalidWeaponException {
        //Arrange
        Mage mage = new Mage("Name");
        Weapon weapon = new Weapon("Stick",1,"Weapon",1,1,"Staff");
        mage.equipWeapon(String.valueOf(weapon.getSlot()),weapon);
        Weapon weaponTwo = (Weapon) mage.getItems().get("Weapon");
        boolean expected = true;
        //Act
        boolean actual = weapon == weaponTwo;
        //Assert
        assertEquals(expected,actual);
    }
    @Test
    public void equipArmor_equipArmorOverCharactersLevel_throwInvalidArmorException(){
        //Arrange
        Mage mage = new Mage("Name");
        Armor armor = new Armor("Chest armor",2,"Chest","Cloth",1,1,1);
        String expected = "You cant use armor above your current level";
        //Act
        Exception e =assertThrows(Exception.class, ()->mage.equipArmor(String.valueOf(armor.getSlot()),armor));
        String actual = e.getMessage();
        //Assert
        assertEquals(expected,actual);
    }
    @Test
    public void equipArmor_equipArmorWhichHasTypeClassCantUse_throwInvalidArmorException(){
        //Arrange
        Mage mage = new Mage("Name");
        Armor armor = new Armor("Chest armor",1,"Chest","Mail",1,1,1);
        String expected = "You cant use Mail armor";
        //Act
        Exception e =assertThrows(Exception.class, ()->mage.equipArmor(String.valueOf(armor.getSlot()),armor));
        String actual = e.getMessage();
        //Assert
        assertEquals(expected,actual);
    }
    @Test
    public void equipArmor_characterCanEquipArmorIfRequirementsForLevelAndTypeAreMet_canEquipArmor() throws InvalidArmorException {
        //Arrange
        Mage mage = new Mage("Name");
        Armor armor = new Armor("Chest armor",1,"Chest","Cloth",1,1,1);
        mage.equipArmor(String.valueOf(armor.getSlot()),armor);
        Armor armorTwo = (Armor) mage.getItems().get("Chest");
        boolean expected = true;
        //Act
        boolean actual = armor == armorTwo;
        //Assert
        assertEquals(expected,actual);
    }
    @Test
    public void calculateDamage_noWeaponEquipped_ShouldReturnCorrectDpsAmount(){
        //Arrange
        Mage mage = new Mage("Name");
        double expected = 1 * (1 + 8 / 100.0);  //1 * (1% for every primary stat)
        //Act
        double actual = mage.calculateDamage();
        //Assert
        assertEquals(expected,actual);
    }
    @Test
    public void calculateDamage_WeaponEquipped_ShouldReturnCorrectDpsAmount() throws InvalidWeaponException {
        //Arrange
        Mage mage = new Mage("Name");
        Weapon weapon = new Weapon("Stick",1,"Weapon",5,1.5,"Staff");
        mage.equipWeapon(String.valueOf(weapon.getSlot()),weapon);
        double expected = 5 * 1.5 * (1 + 8 / 100.0);    //weapon damage * weapon attack speed * (1% for every primary stat)
        //Act
        double actual = mage.calculateDamage();
        //Assert
        assertEquals(expected,actual);
    }
    @Test
    public void calculateDamage_WeaponAndArmorEquipped_ShouldReturnCorrectDpsAmount() throws InvalidWeaponException, InvalidArmorException {
        //Arrange
        Mage mage = new Mage("Name");
        Weapon weapon = new Weapon("Stick",1,"Weapon",5,1.5,"Staff");
        Armor armor = new Armor("Chest armor",1,"Chest","Cloth",1,1,1);
        mage.equipWeapon(String.valueOf(weapon.getSlot()),weapon);
        mage.equipArmor(String.valueOf(armor.getSlot()),armor);
        double expected = 5 * 1.5 * (1 + (8 + 1) / 100.0);    //weapon damage * weapon attack speed * (1% for every primary stat)
        //Act
        double actual = mage.calculateDamage();
        //Assert
        assertEquals(expected,actual);
    }

}