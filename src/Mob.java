import java.util.Random;

public class Mob{

    private int hpAmount;
    private final int damage;
    private static int damageMultiplier = 0, hpMultiplier = 0;
    private final String mobName;
    Random random = new Random();

    public Mob(String mobName){
        this.mobName = mobName;
        hpAmount = hpMultiplier + 100;
        damage = damageMultiplier;
        damageMultiplier += 1;
        hpMultiplier += 5;
    }

    public int getHpAmount() {
        return hpAmount;
    }

    public String getMobName() {
        return mobName;
    }

    public void setHpAmount(int hpAmount) {
        this.hpAmount = hpAmount;
    }

    public int dealDamage() {
        return this.damage + (random.nextInt(4) + 2);
    }
}
