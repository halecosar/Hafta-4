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
    }
}
