import java.util.Random;

public class Mob{

    private int hpAmount, damage;
    private final String mobName;
    Random random = new Random();

    Mob(String mobName){
        this.mobName = mobName;
        this.hpAmount = 100;
    }

    public int getHpAmount() {
        return hpAmount;
    }

    public void setHpAmount(int hpAmount) {
        this.hpAmount = hpAmount;
    }
}
