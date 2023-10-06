
import java.sql.Array;
import java.util.List;
import java.util.Scanner;

public class Player {
    private int damage;
    private int health;
    private int originalHealth;
    private int[] arrayAward = new int[3];

    public int getOriginalHealth() {
        return originalHealth;
    }

    public void setOriginalHealth(int originalHealth) {
        this.originalHealth = originalHealth;
    }

    private int money;
    String name;
    String charName;
    private Inventory inventory;
    private Scanner scan = new Scanner(System.in);


    public int getTotalDamage() {
        return damage + getInventory().getWeapon().getDamage();
    }

    public int getDamage() {

        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {

        if (health < 0) {
            health = 0;
        }
        this.health = health;
    }

    public int getMoney() {
        if (money < 0) {
            money = 0;
        }
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Player(String name) { // oyuncunun adını alacağız dışarıdan, diğerleri zaten seçilecek oyun içinden.
        this.name = name;
        this.inventory = new Inventory(); // player oluştuğu zaman otomatik bir inventory oluşsun. Varsayılan olarak yumruk gelecek.
    }

    public void selectChar() {
        System.out.println();
        System.out.println("Karakterler :");
        System.out.println("-----------------------------------------------------------------------");
        GameChar[] charList = {new Samurai(), new Archer(), new Knight()}; // new demesem ne olurdu?
        for (GameChar gameChar : charList) {
            System.out.println("ID : " + gameChar.getId() + "\n" + " - Karakter : " + gameChar.getName() + "\n" +
                            " - Hasar : " + gameChar.getDamage() + "\n" + " - Sağlık : " + gameChar.getHealth() + "\n" +
                             " - Para : " + gameChar.getMoney());


        }
        System.out.println("===========================================");
        System.out.println();
        System.out.println("Lütfen bir karakter giriniz : ");
        int selectChar = scan.nextInt();
        switch (selectChar) {
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());
        }

        System.out.println("Karakter : " + this.getCharName() + " , Hasar : " + this.getDamage() +
                " , Sağlık : " + getHealth() + " , Para : " + this.getMoney());

    }

    public void initPlayer(GameChar gameChar) {
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        this.setCharName(gameChar.getName());
        this.setOriginalHealth(gameChar.getHealth());
    }

    public void printInfo() {
        System.out.println("Silahınız : " + this.getInventory().getWeapon().getName() + " , Zırhınız : " + this.getInventory().getArmor().getArmorName() + " , Bloklama :" + this.getInventory().getArmor().getBlock() + " , Hasarınız: " + this.getTotalDamage() +
                " , Sağlığınız : " + getHealth() + " , Paranız  : " + this.getMoney());


    }

}