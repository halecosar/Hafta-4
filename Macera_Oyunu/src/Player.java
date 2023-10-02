import java.util.Scanner;

public class Player {
    private int damage;
    private int health;
    private int money;
    String name;
    String charName;
    private Scanner scan = new Scanner(System.in);

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
        this.health = health;
    }

    public int getMoney() {
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

    public Player(String name) { // oyuncunun adını alacağız dışarıdan, diğerleri zaten seçilecek oyun içinden.
        this.name = name;
    }

    public void selectChar() {
        System.out.println("Karakterler :");
        GameChar[] charList = {new Samurai(), new Archer(), new Knight()}; // new demesem ne olurdu?
        for (GameChar gameChar : charList) {
            System.out.println("ID : " + gameChar.getId() + " Karakter : " + gameChar.getName() +
                    " Hasar : " + gameChar.getDamage() +
                    " Sağlık : " + gameChar.getHealth() +
                    " Para : " + gameChar.getMoney());
        }
        System.out.println("**************************************");
        System.out.println("Lütfen bir karakter giriniz :");
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
                ", Sağlık : " + getHealth() + "Para : " + this.getMoney());

    }

    public void initPlayer(GameChar gameChar) {
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        this.setCharName(gameChar.getName());
    }
}