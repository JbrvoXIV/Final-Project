import javax.swing.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) {
        UI ui = new UI();
        Player player = new Player();
        Mob[] enemy = new Mob[20];
        AtomicInteger level = new AtomicInteger(0);

        enemy[0] = new Mob("Skeleton");
        enemy[1] = new Mob("Spider");
        enemy[2] = new Mob("Kobold");
        enemy[3] = new Mob("Zombie");
        enemy[4] = new Mob("Prince Bones");
        enemy[5] = new Mob("Elite Skeleton");
        enemy[6] = new Mob("Elite Spider");
        enemy[7] = new Mob("Elite Kobold");
        enemy[8] = new Mob("Elite Zombie");
        enemy[9] = new Mob("Arachnid Queen");
        enemy[10] = new Mob("General Skeleton");
        enemy[11] = new Mob("General Spider");
        enemy[12] = new Mob("General Kobold");
        enemy[13] = new Mob("General Zombie");
        enemy[14] = new Mob("Wolf Emperor");
        enemy[15] = new Mob("Monarch Skeleton");
        enemy[16] = new Mob("Monarch Spider");
        enemy[17] = new Mob("Monarch Kobold");
        enemy[18] = new Mob("Monarch Zombie");
        enemy[19] = new Mob("Undead King");

        ui.dungeonText.setText("A " + enemy[0].getMobName() + " has appeared!");

        // ATTACK
        ui.choiceAttack.addActionListener(e -> {
            int playerDmg = player.dealDamage();
            int enemyDmg = enemy[level.get()].dealDamage();
            enemy[level.get()].setHpAmount(enemy[level.get()].getHpAmount() - playerDmg);
            player.setHpAmount(player.getHpAmount() - enemyDmg);
            ui.dungeonText.setText("You've dealt " + playerDmg + " to " + enemy[level.get()].getMobName() + "!\n" +
                    enemy[level.get()].getMobName() + " deals " + enemyDmg + " back!");
            ui.hpNumLabel.setText(String.valueOf(player.getHpAmount()));
            ui.enemyHPNumLabel.setText(String.valueOf(enemy[level.get()].getHpAmount()));

            if (player.getHpAmount() <= 0) {
                ui.endGameLoss();
            } else if(enemy[level.get()].getHpAmount() <= 0){
                level.incrementAndGet();
                if(level.get() == enemy.length){
                    ui.endGameWin();
                } else{
                    if(level.get() == 4 || level.get() == 9 || level.get() == 14){
                        ui.dungeonText.setText("A  mini boss has appeared!\n" + enemy[level.get()].getMobName() +
                                " enters the dungeon!");
                    } else if(level.get() == 19){
                        ui.dungeonText.setText("The final boss, " + enemy[19].getMobName() + ", has appeared!");
                    } else{
                        ui.dungeonText.setText("You've defeated " + enemy[level.get()-1].getMobName() + "!\n\n");
                        ui.dungeonText.append("A " + enemy[level.get()].getMobName() + " has appeared!");
                        if(level.get() == 5 || level.get() == 10 || level.get() == 15){
                            player.increaseStats();
                            ui.hpNumLabel.setText(String.valueOf(player.getHpAmount()));
                            ui.potionNumLabel.setText(String.valueOf(player.getPotionAmount()));
                            ui.dungeonText.append("\n\nYour stats have increased!");
                        }
                    }
                    ui.levelNumLabel.setText(String.valueOf(level.get() + 1));
                    ui.enemyHPNumLabel.setText(String.valueOf(enemy[level.get()].getHpAmount()));
                }
            }
        });

        // POTION
        ui.choicePotion.addActionListener(e -> {
            if (player.getPotionAmount() == 0) {
                ui.dungeonText.setText("You have no more potions!!!");
            } else {
                player.drinkPotion();
                player.setPotionAmount(player.getPotionAmount() - 1);
                ui.dungeonText.setText("You recover 30 HP!");
                ui.potionNumLabel.setText(String.valueOf(player.getPotionAmount()));
                ui.hpNumLabel.setText(String.valueOf(player.getHpAmount()));
            }
        });

        // FLEE
        ui.choiceFlee.addActionListener(e -> {
            int fleeChoice = JOptionPane.showConfirmDialog(null, "Are you sure you wish to flee?",
                    "WARNING", JOptionPane.YES_NO_OPTION);
            if (fleeChoice == 0) {
                System.exit(0);
            }
        });
    }
}

