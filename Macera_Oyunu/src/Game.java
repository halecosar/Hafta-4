import java.util.Scanner;

public class Game {
    private Scanner scan = new Scanner(System.in); //neden private? sadece bu sınnıfta kullanacağım için.
    String playerName;

    public void start() {
        System.out.println("Macera Oyununa Hoşgeldin ! ");
        System.out.println("İsim giriniz :"); // oyuncudan isim aldıysak player sınıfını oluşturalım.
        playerName = scan.nextLine(); //kullanıcıdan isim aldıktan sonra bir player nesnesi üretelim.
        Player player = new Player(playerName); // constructor'a aldığım parametreyi girdim.
        System.out.println("Sayın " + player.getName() + " Adaya Hoşgeldiniz! "); // nesneden gelecek. Player oluşturuldu artık karakter sçilmeli.
        System.out.println("Lütfen bir karakter seçiniz :");
        player.selectChar();
        while (true) {

            Location location = null;
            System.out.println("Bölgeler");
            System.out.println("1- Güvenli Ev");
            System.out.println("2- Mağaza");
            System.out.println("Lütfen gitmek istediğiniz bölgeyi seçiniz : ");
            int selectLoc = scan.nextInt();
            switch (selectLoc) {
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                default:
                    location = new SafeHouse(player);
            }

            location.onLocation();
            if(!location.onLocation()){
                System.out.println("Game Over!");
                break;

            }
        }




    }
}
