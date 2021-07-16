public class Player {

    private int hpAmount, potionAmount, levelAmount;

    Player(){
        this.hpAmount = 100;
        this.potionAmount = 3;
        this.levelAmount = 1;
    }

    public int getHpAmount() {
        return hpAmount;
    }

    public int getPotionAmount() {
        return potionAmount;
    }

    public int getLevelAmount() {
        return levelAmount;
    }

    public void setHpAmount(int hpAmount) {
        this.hpAmount = hpAmount;
    }

    public void setPotionAmount(int potionAmount) {
        this.potionAmount = potionAmount;
    }

    public void setLevelAmount(int levelAmount) {
        this.levelAmount = levelAmount;
    }
}
