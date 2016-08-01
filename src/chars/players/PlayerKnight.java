package chars.players;

import chars.Stat;
import chars.attacks.Attack;
import chars.attacks.AttackNormal;
import chars.attacks.AttackSwordSlash;

public class PlayerKnight extends Player{
    public PlayerKnight(String name){
        super(name);
        id = "Knight";
        //Change later obviously
        mainAtt = 1;
        attacks = new Attack[]{new AttackNormal(), new AttackSwordSlash(), new AttackSwordSlash(), new AttackSwordSlash(), new AttackSwordSlash()};
        attributes = new double[]{3, 5, 3};
        baseStats = new double[]{10, 17.5, 4.7, 8.05};
        health = new Stat(90);
        mana = new Stat(41);
        itemUsagePronouns = true;
        this.calculateRealStats();
    }

}
