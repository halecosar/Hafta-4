import java.sql.SQLOutput;

public class ToolStore extends NormalLocation{
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
        while (selectCase <0 || selectCase>3){
            System.out.println("Lütfen Tekrar Seçim Yapınız !");
            selectCase = scan.nextInt();
        }
        switch (selectCase){
            case 1: printWeapon();
            break;
            case 2: printArmor();
            break;
            case 3:
                System.out.println("Bir daha bekleriz!");
                return true;

        }




        return true;
    }

    public void printWeapon(){
        System.out.println("----------Silahlar-----------");
        for(Weapon w : Weapon.weapons()){
            System.out.println(w.getId() + w.getName() + "Para: " + w.getPrice() + "Hasar : " +  w.getDamage());
        }
        System.out.println("Bir silah seçiniz :");
        int selectWeapon = scan.nextInt();
        while (selectWeapon <0 || selectWeapon> Weapon.weapons().length){
            System.out.println("Lütfen Tekrar Seçim Yapınız !");
            selectWeapon = scan.nextInt();
        }

        }


    public void printArmor(){
        System.out.println("Zırhlar");
    }
}
