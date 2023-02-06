import org.junit.Test;
import java.util.*;
class Hero {
    private String name;
    private int hitPoints;

    public Hero(String name) {
        this.name = name;
        this.hitPoints = 100;
    }

    public String getName() {
        return name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public String toString() {
        return "Hero{name='" + name + "', hitPoints=" + hitPoints + "}";
    }

    public void attack(Hero opponent) {
        Random rn = new Random();
        double dmg = rn.nextDouble(0.00, 0.99);
        if (dmg < 0.5) {
            opponent.hitPoints -= 10;
        } else {
            hitPoints -= 10;
        }
    }

    public void senzuBean() {
        hitPoints = 100;
    }

    private void fightUntilTheDeathHelper(Hero opponent) {
        while ((hitPoints > 0) && (opponent.hitPoints > 0)) {
            attack(opponent);
        }
    }

    private void dFightUntilTheDeathHelper(Hero opponent) {
        while ((hitPoints > 0) || (opponent.hitPoints > 0)) {
            attack(opponent);
            System.out.println(name + ":" + hitPoints + " " + opponent.name + ":" + opponent.hitPoints);
        }
    }

    public String fightUntilTheDeath(Hero opponent) {
        senzuBean();
        opponent.senzuBean();
        fightUntilTheDeathHelper(opponent);
        return name + ":" + hitPoints + " " + opponent.name + ":" + opponent.hitPoints;
    }

    private int[] nFightsToTheDeathHelper(Hero opponent, int n) {
        int wins = 0, oWins = 0;
        for (int i = 0; i < n; i++) {
            fightUntilTheDeath(opponent);
            if (hitPoints > opponent.hitPoints) {
                wins++;
            } else oWins++;
        }
        int[] v = {wins, oWins};
        return v;
    }

    public String nFightsToTheDeath(Hero opponent, int n) {
        int[] scores = nFightsToTheDeathHelper(opponent, n);
        String f = name + ": " + scores[0] + " wins" + "\n" + opponent.name + ": " + scores[1] +" wins"+ "\n";
        System.out.println(f);
        if (scores[0] > scores[1]) {
            f += name + " wins!";
        } else if (scores[1] > scores[0]) {
            f += opponent.name + " wins!";
        } else f += "OMG! It was actually a draw!";
        return f;
    }

    public void dramaticFightToTheDeath(Hero opponent) {
        senzuBean();
        opponent.senzuBean();
        dFightUntilTheDeathHelper(opponent);
        if (hitPoints > opponent.hitPoints) {
            System.out.println(name + " wins!");
        } else if (opponent.hitPoints > hitPoints) {
            System.out.println(opponent.name + " wins!");
        }
    }
}