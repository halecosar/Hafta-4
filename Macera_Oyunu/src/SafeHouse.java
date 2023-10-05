import java.sql.SQLOutput;

public  class SafeHouse extends NormalLocation{
    public SafeHouse(Player player) {
        super(player, "Güvenli Ev");

    }
   public boolean onLocation() {
        System.out.println("Güvenli Evdesiniz.");
        int[] asd = getPlayer().getInventory().getAward();
        if(asd[0] == 1 && asd[1] == 2 && asd[2] == 3){
            System.out.println("Tüm canavarları öldürüp ödülleri topladığınız için oyunu kazandınız.");
            return false;
        }
        else{
            System.out.println("Canınız Yenilendi.");
            this.getPlayer().setHealth(this.getPlayer().getOriginalHealth());
            return true;
        }
    }


}
