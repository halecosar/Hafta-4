public class Inventory {
    private Weapon weapon;
    private Armor armor;
    private int[] awards = new int[3];

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Inventory() {
         this.weapon = new Weapon("Yumruk ", -1, 0, 0);
         this.armor = new Armor(-1, "Paçavra ", 0, 0);
    }

    public void SetAward(int id) {
        if (awards[0] == 0 && id == 1) {
            awards[0] = id;
        }
        if (awards[1] == 0 && id == 2) {
            awards[1] = id;
        }
        if (awards[2] == 0 && id == 3) {
            awards[2] = 3;
        }
    }

    public int[] getAward() {
        return awards;
    }
}

