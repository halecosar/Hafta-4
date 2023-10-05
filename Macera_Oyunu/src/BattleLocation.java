import java.util.Random;

public abstract class BattleLocation extends Location {
    Obstacle obstacle;
    private String award;
    private int maxObstacle;
    private String name;


    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public BattleLocation(Player player, String name, Obstacle obstacle, String award, int maxObstacle) {
        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;
        this.name = name;
    }

    @Override
    public boolean onLocation() {
        int obsNumber = randomObstacleNumber();
        System.out.println("Şu an buradasınız. " + this.name);
        System.out.println("Dikkatli ol burada " + this.getObstacle().getName() == " Snake " ? randomObstacleNumberForSnake() : obsNumber + " tane " + this.getObstacle().getName() + " yaşıyor.");
        System.out.println(" <S>avaş veya <K>aç ");
        String selectCase = scan.nextLine();
        selectCase = selectCase.toUpperCase();
        if (selectCase.equals("S") && combat(obsNumber)) {
            System.out.println(" Tüm düşmanları yendiniz! ");

            if (this.name == "Mağara") {
                this.getPlayer().getInventory().SetAward(1);
                System.out.println(" Tüm düşmanları yendiniz!, yemek kazandınız. ");
            }
            if (this.name == "Orman") {
                this.getPlayer().getInventory().SetAward(2);
                System.out.println(" Tüm düşmanları yendiniz!, odun kazandınız. ");
            }
            if (this.name == "Nehir") {
                this.getPlayer().getInventory().SetAward(3);
                System.out.println(" Tüm düşmanları yendiniz!, su kazandınız. ");
            }


            return true;


        }


        if (this.getPlayer().getHealth() <= 0) {
            System.out.println(" Öldünüz ");
            return false;
        }
        return true;
    }

    // kaç canavarla savaşacaksam o kadar döngü yazacağız.
    public boolean combat(int obsNumber) {
        this.getObstacle().setHealth(this.getObstacle().getOriginalHealth());
        for (int i = 1; i <= obsNumber; i++) {
            playerStats();
            obstacleStats(i);

            while (this.getPlayer().getHealth() > 0 && this.getObstacle().getHealth() > 0) {
                System.out.println(" <V>ur veya <K>aç ");
                String selectCombat = scan.nextLine().toUpperCase();

                if (selectCombat.equals("V")) {

                    Random random = new Random();
                    int caseRand = random.nextInt(1, 2);

                    if (caseRand == 1) {
                        System.out.println(" Siz Vurdunuz! ");
                        this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getTotalDamage());
                        afterHit();

                        if (this.getObstacle().getHealth() > 0) {
                            System.out.println();
                            System.out.println(" Canavar Vurdu! ");
                            int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                            if (obstacleDamage < 0) {
                                obstacleDamage = 0;
                            }

                            this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                            afterHit();


                        }


                    } else {

                        System.out.println(" Canavar Vurdu! ");
                        int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                        if (obstacleDamage < 0) {
                            obstacleDamage = 0;
                        }

                        this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                        afterHit();

                        if (this.getPlayer().getHealth() > 0) {
                            System.out.println();

                            System.out.println("Siz Vurdunuz! ");
                            this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getTotalDamage());
                            afterHit();
                        }

                    }


                    if (this.getObstacle().getHealth() <= 0) {
                        System.out.println(" Düşmanı Yendiniz! ");
                        if (getObstacle().getName() == " Yılan ") {

                            earnSomething();
                        } else {
                            System.out.println(this.getObstacle().getAward() + " Para Kazandınız ! ");
                            this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getAward());
                            System.out.println(" Güncel Paranız :" + this.getPlayer().getMoney());

                        }

                    }

                } else {
                    return false;

                }
            }
            i=i+1;
        }


        return true;
    }

    public void afterHit() {
        System.out.println(" Canınız :" + this.getPlayer().getHealth());
        System.out.println("  Canavarın canı " + this.getObstacle().getHealth());
        System.out.println();
    }

    public int randomObstacleNumber() {
        Random rnd = new Random();
        return rnd.nextInt(3) + 1;

    }

    public int randomObstacleNumberForSnake() {
        Random rnd = new Random();
        return rnd.nextInt(0, 5);

    }

    public void playerStats() {
        System.out.println("Oyuncu Değerleri ");
        System.out.println("--------------------------");
        System.out.println(" Sağlık : " + this.getPlayer().getHealth());
        System.out.println(" Silah :" + this.getPlayer().getInventory().getWeapon().getName());
        System.out.println(" Zırh :" + this.getPlayer().getInventory().getArmor().getArmorName());
        System.out.println(" Bloklama :" + this.getPlayer().getInventory().getArmor().getBlock());

        System.out.println(" Hasar : " + this.getPlayer().getTotalDamage());
        System.out.println(" Para : " + this.getPlayer().getMoney());


    }

    public void obstacleStats(int i) {
        System.out.println(i + "." + this.getObstacle().getName() + " Değerleri ");
        System.out.println("---------------------------------------------");
        System.out.println(" Sağlık : " + this.getObstacle().getHealth());
        System.out.println(" Hasar : " + this.getObstacle().getDamage());
        System.out.println(" Ödülü : " + this.getObstacle().getAward());

    }

    public void earnSomething() {
        Random random = new Random();
        int randomEarn = random.nextInt(1, 100);
        if (randomEarn <= 15) {
            Random random1 = new Random();
            int randomEarn1 = random.nextInt(1, 100);
            if (randomEarn1 <= 20) {
                System.out.println("Tüfek Kazandınız! ");
                getPlayer().getInventory().setWeapon(Weapon.getWeaponObjByID(3));
            } else if (randomEarn1 <= 50 && randomEarn1 > 20) {
                System.out.println("Kılıç Kazandınız! ");
                getPlayer().getInventory().setWeapon(Weapon.getWeaponObjByID(2));

            } else {
                System.out.println("Tabanca Kazandınız! ");
                getPlayer().getInventory().setWeapon(Weapon.getWeaponObjByID(1));
            }


        } else if (randomEarn > 15 && randomEarn < 30) {
            Random random2 = new Random();
            int randomEarn2 = random.nextInt(1, 100);
            if (randomEarn2 <= 20) {
                System.out.println(" Ağır Zırh Kazandınız! ");
                getPlayer().getInventory().setArmor(Armor.getArmorObjByID(3));
            } else if (randomEarn2 > 20 && randomEarn2 <= 50) {
                System.out.println("Orta Zırh Kazandınız! ");
                getPlayer().getInventory().setArmor(Armor.getArmorObjByID(2));

            } else {
                System.out.println(" Hafif Zırh Kazandınız! ");
                getPlayer().getInventory().setArmor(Armor.getArmorObjByID(1));

            }
        } else if (randomEarn > 30 && randomEarn <= 55) {
            Random random2 = new Random();
            int randomEarn2 = random.nextInt(1, 100);
            if (randomEarn2 <= 20) {
                System.out.println(" 10 Para Kazandınız! ");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + 10);
            } else if (randomEarn2 > 20 && randomEarn2 <= 50) {
                System.out.println("5 Para Kazandınız! ");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + 5);
            } else {
                System.out.println(" 1 Para Kazandınız! ");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + 1);
            }
            System.out.println("Güncel Paranız :" + this.getPlayer().getMoney());
        } else
            System.out.println("Hiçbir şey kazanamadınız. ");


    }

}
