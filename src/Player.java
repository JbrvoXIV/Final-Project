import java.util.Random;
public class Player {

    private int hpAmount, potionAmount, damageModifier, hpModifier, potionModifier;
    Random random = new Random();

    Player(){
        this.hpAmount = 150;
        this.potionAmount = 3;
        this.damageModifier = 0;
        this.hpModifier = 50;
        potionModifier = 1;
    }

    public int getHpAmount() {
        return this.hpAmount;
    }

    public int getPotionAmount() {
        return this.potionAmount;
    }

    public void setHpAmount(int hpAmount) {
        this.hpAmount = hpAmount;
    }

    public void setPotionAmount(int potionAmount) {
        this.potionAmount = potionAmount;
    }

    public void increaseStats() {
        this.damageModifier += 10;
        this.hpAmount = 150 + this.hpModifier;
        this.hpModifier += 50;
        this.potionAmount = 3 + this.potionModifier;
        this.potionModifier += 1;
    }

    public int dealDamage(){
        return this.damageModifier + (random.nextInt(16) + 7);
    }

    public void drinkPotion(){
        if(this.potionAmount > 0){
            this.hpAmount += 30;
        }
    }
}
