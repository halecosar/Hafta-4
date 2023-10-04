public class Inventory {
private Weapon weapon;
private Armor armor;

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public Inventory(Armor armor) {
      this.armor = new Armor(-1,"Paçavra",0,0);
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Inventory() {
        Weapon weapon = new Weapon ("Yumruk",-1,0,0);

    }
}

