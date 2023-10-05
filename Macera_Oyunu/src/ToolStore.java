import com.sun.security.jgss.GSSUtil;

import java.sql.SQLOutput;

public class ToolStore extends NormalLocation {
    public ToolStore(Player player) {
        super(player, "Mağaza");


    }

    boolean onLocation() {
        System.out.println("Mağazaya Hoş Geldiniz!");
        boolean showMenu = true;
        while (showMenu) {
            System.out.println("1- Silahlar :");
            System.out.println("2- Zırhlar :");
            System.out.println("3- Çıkış Yap :");
            System.out.println("Seçiminiz : ");
            int selectCase = scan.nextInt();
            while (selectCase < 0 || selectCase > 3) {
                System.out.println("Lütfen Tekrar Seçim Yapınız !");
                selectCase = scan.nextInt();
            }
            switch (selectCase) {
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("Bir daha bekleriz!");
                    showMenu = false;
                    break;


            }

        }
        return true;
    }

    public void printWeapon() {
        System.out.println("----------Silahlar-----------");
        for (Weapon w : Weapon.weapons()) {
            System.out.println(w.getId() + w.getName() + "Para: " + w.getPrice() + "Hasar : " + w.getDamage());
        }
        System.out.println(" 0- Çıkış Yap");


    }

    public void buyWeapon() {
        System.out.println("Bir silah seçiniz :");
        int selectWeapon = scan.nextInt();
        while (selectWeapon < 0
                || selectWeapon > Weapon.weapons().length) {
            System.out.println("Lütfen Tekrar Seçim Yapınız !");
            selectWeapon = scan.nextInt();
        }
        if (selectWeapon != 0) {
            Weapon selectedWeapon = Weapon.getWeaponObjByID(selectWeapon);
            if (selectedWeapon != null) {
                if (selectedWeapon.getPrice() > this.getPlayer().getMoney() || getPlayer().getMoney() <= 0) {
                    System.out.println("Yetersiz Bakiye");
                }
                //satın lma buada gerçekleşecek.
                else {
                    System.out.println(selectedWeapon.getName() + "silahını satın aldınız");

                    int balance = getPlayer().getMoney() - selectedWeapon.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Kalan Paranız : " + this.getPlayer().getMoney());
                    System.out.println("Önceki Silahınız : " + this.getPlayer().getInventory().getWeapon().getName());
                    getPlayer().getInventory().setWeapon(selectedWeapon);
                    System.out.println("Yeni Silahınız : " + this.getPlayer().getInventory().getWeapon().getName());
                }


            }
        }
    }

    public void printArmor() {
        System.out.println("*****************Zırhlar**********************");
        for (Armor a : Armor.armors()) {
            System.out.println(a.getId() + " - " + " (" + a.getArmorName() + "Zırh) " + " Para: " + "/ " + a.getPrice() + " Zırh Blok Değeri : " + a.getBlock());
        }
        System.out.println(" 0- Çıkış Yap");

    }

    public void buyArmor() {
        System.out.println("Bir zırh seçiniz :");
        int selectArmor = scan.nextInt();
        while (selectArmor < 0 || selectArmor > Armor.armors().length) {
            System.out.println("Lütfen Tekrar Seçim Yapınız !");
            selectArmor = scan.nextInt();

        }

        if (selectArmor != 0) {
            Armor selectedArmor = Armor.getArmorObjByID(selectArmor);
            if (selectedArmor != null) {
                if (selectedArmor.getPrice() > this.getPlayer().getMoney() || getPlayer().getMoney() <= 0) {
                    System.out.println("Yetersiz Bakiye.. ");
                }
                //satın alma burada gerçekleşecek.
                else {
                    System.out.println(selectedArmor.getArmorName() + "zırhını satın aldınız");

                    int balance = getPlayer().getMoney() - selectedArmor.getPrice();
                    this.getPlayer().setMoney(balance);

                    System.out.println("Kalan Bakiye : " + this.getPlayer().getMoney());
                    System.out.println("Önceki Zırhınız : " + this.getPlayer().getInventory().getArmor().getArmorName());
                    getPlayer().getInventory().setArmor(selectedArmor);
                    System.out.println("Yeni Zırhınız : " + this.getPlayer().getInventory().getArmor().getArmorName());
                }


            }
        }

    }
}