import java.util.Random;

public abstract class BattleLocation extends Location {
    Obstacle obstacle;
    private String award;
    private int maxObstacle;


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
    }

    @Override
    public boolean onLocation() {
        int obsNumber = randomObstacleNumber();
        System.out.println("Şu an buradasınız." + this.getName());
        System.out.println("Dikkatli ol burada" + obsNumber + " tane " + this.getObstacle().getName() + " yaşıyor.");
        System.out.println("<S>aaş veya <K>aç ");
        String selectCase = scan.nextLine();
        selectCase = selectCase.toUpperCase();
        if (selectCase.equals("S")) {

        }
        return true;
    }

    // kaç canavarla savaşacaksam o kadar döngü yazacağız.
    public boolean combat(int obsNumber) {
        for(int i=1; i<obsNumber; i++ ){
          playerStats();
          obstacleStats();
          while(this.getPlayer().getHealth()> 0 && this.getObstacle().getHealth() >0){
              System.out.println(" <V>ur veya <K>aç");
              String selectCombat =scan.nextLine().toUpperCase();
              if (selectCombat.equals("V")) {
                  System.out.println("Siz Vurdunuz ");
                  this.getObstacle().setHealth(this.getObstacle().getHealth()-this.getPlayer().getTotalDamage());
                  afterHit();
                  if (this.getObstacle().getHealth() >0){
                      System.out.println();
                      System.out.println("Canavar Vurdu ");
                      int obstacleDamage = this.getObstacle().getDamage()- this.getPlayer().getInventory().getArmor().getBlock();
                      if(obstacleDamage<0){
                          obstacleDamage=0;
                      }

                      this.getPlayer().setHealth(this.getPlayer().getHealth());



                  }

              }


          }
        }


        return false;
    }
    public void afterHit(){
        System.out.println("Canınız :"+ this.getPlayer().getHealth());
        System.out.println(this.getObstacle().getHealth() + " canı ");
        System.out.println();
    }

    public int randomObstacleNumber() {
        Random rnd = new Random();
        return rnd.nextInt(3) + 1;

    }
    public void playerStats(){
        System.out.println("Oyuncu Değerleri");
        System.out.println("--------------------------");
        System.out.println("Sağlık : " +this.getPlayer().getHealth());
        System.out.println("Silah :" + this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Zırh :" + this.getPlayer().getInventory().getArmor().getArmorName());
        System.out.println("Bloklama :" + this.getPlayer().getInventory().getArmor().getBlock());

        System.out.println("Hasar : " +this.getPlayer().getTotalDamage());
        System.out.println("Para : " +this.getPlayer().getMoney());


    }
    public void obstacleStats(){
        System.out.println(this.getObstacle().getName() + " Değerleri ");
        System.out.println("---------------------------------------------");
        System.out.println("Sağlık : " +this.getObstacle().getHealth());
        System.out.println("Hasar : " +this.getObstacle().getDamage());
        System.out.println("Ödülü : " +this.getObstacle().getAward());

    }

}
