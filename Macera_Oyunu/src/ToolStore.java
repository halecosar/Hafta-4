import com.sun.security.jgss.GSSUtil;

import java.sql.SQLOutput;

public class ToolStore extends NormalLocation {
    public ToolStore(Player player) {
        super(player, "Mağaza");


    }

    boolean onLocation() {
        System.out.println("Mağazaya Hoş Geldiniz!");
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
                return true;

        }


        return true;
    }

    public void printWeapon() {
        System.out.println("----------Silahlar-----------");
        for (Weapon w : Weapon.weapons()) {
            System.out.println(w.getId() + w.getName() + "Para: " + w.getPrice() + "Hasar : " + w.getDamage());
        }


    }

    public void buyWeapon() {
        System.out.println("Bir silah seçiniz :");
        int selectWeapon = scan.nextInt();
        while (selectWeapon < 0 || selectWeapon > Weapon.weapons().length) {
            System.out.println("Lütfen Tekrar Seçim Yapınız !");
            selectWeapon = scan.nextInt();
        }
        Weapon selectedWeapon = Weapon.getWeaponObjByID(selectWeapon);
        if (selectedWeapon != null) {
            if (selectedWeapon.getPrice() > this.getPlayer().getMoney()) {
                System.out.println("Yetersiz Bakiye");
            }
            //satın lma buada gerçekleşecek.
            else {
                System.out.println(selectedWeapon.getName() + "silahını satın aldınız");
            }
            int balance = getPlayer().getMoney() - selectedWeapon.getPrice();
            this.getPlayer().setMoney(balance);
            System.out.println("Kalan Paranız : " + this.getPlayer().getMoney());
            System.out.println("Önceki Silahınız : " + this.getPlayer().getInventory().getWeapon().getName());
            getPlayer().getInventory().setWeapon(selectedWeapon);
            System.out.println("Yeni Silahınız : " + this.getPlayer().getInventory().getWeapon().getName());

        }
    }

    public void printArmor() {
        System.out.println("****Zırhlar****");
        for (Armor a : Armor.armors()) {
            System.out.println(a.getId() + "-" + a.getArmorName() + "Para: " + a.getPrice() + "Zırh Değeri : " + a.getBlock());
        }


    }

    public void buyArmor() {
        System.out.println("Bir zırh seçiniz :");
        int selectArmor = scan.nextInt();
        while (selectArmor < 0 || selectArmor > Armor.armors().length) {
            System.out.println("Lütfen Tekrar Seçim Yapınız !");
            selectArmor = scan.nextInt();

        }
    }
}
