import java.sql.SQLOutput;

public  class SafeHouse extends NormalLocation{
    public SafeHouse(Player player) {
        super(player, "Güvenli Ev");

    }
   public boolean onLocation() {
        System.out.println("Güvenli Evdesiniz.");
        System.out.println("Canınız Yenilendi.");
        this.getPlayer().setHealth(this.getPlayer().getOriginalHealth());
        return true;
    }


}
