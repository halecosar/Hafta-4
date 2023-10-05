import java.sql.SQLOutput;
import java.util.Scanner;

public class Game {
    private Scanner scan = new Scanner(System.in); //neden private? sadece bu sınnıfta kullanacağım için.
    String playerName;

    public void start() {
        System.out.println("Macera Oyununa Hoşgeldin ! ");
        System.out.print("İsim giriniz :"); // oyuncudan isim aldıysak player sınıfını oluşturalım.
        playerName = scan.nextLine(); //kullanıcıdan isim aldıktan sonra bir player nesnesi üretelim.
        Player player = new Player(playerName); // constructor'a aldığım parametreyi girdim.
        System.out.println("Sayın " + player.getName() + " Adaya Hoşgeldiniz! "); // nesneden gelecek. Player oluşturuldu artık karakter sçilmeli.
        System.out.println("Lütfen Bir Karakter Seçiniz :");
        player.selectChar();

        Location location = null;
        while (true) {
           player.printInfo();

            System.out.println("****************Bölgeler******************** ");
            System.out.println("1- Güvenli Ev, burada güvendesin! canın yenilenecek. ");
            System.out.println("2- Eşya Dükkanı, buradan silah ve zırh satın alabilirsin. ");
            System.out.println("3- Mağara, zombilerle savaşarak yemek kazanabilirsin. ");
            System.out.println("4- Orman, vamirlerle savaşarak odun kazanabilirsin. ");
            System.out.println("5- Nehir, ayılarla savaşarak su kazanabailirsin. ");
            System.out.println("6- Maden, yılanlarla savaşarak eşya ya da para kazanabilirsin. ");


            System.out.println("0- Çıkış Yap. ");

            System.out.println("Lütfen gitmek istediğiniz bölgeyi seçiniz : ");
            int selectLoc = scan.nextInt();
            switch (selectLoc) {
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    location = new Cave(player);
                    break;
                case 4:
                    location = new Forest(player);
                    break;
                case 5:
                    location  = new River(player);
                    break;
                case 6:
                    location = new Coal(player);
                    break;
                default:
                    System.out.println("Lütfen Geçerli Bir Bölge Giriniz! ");
            }

            if(location == null){
                System.out.println("Oyun Bitti Görüşmek Üzere! ");
                break;

            }
            if(!location.onLocation()){
                System.out.println("Game Over!");
                break;
            }
        }




    }
}
