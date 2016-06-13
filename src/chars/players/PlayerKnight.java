package chars.players;

import chars.attacks.Attack;
import chars.attacks.AttackSwordSlash;

public class PlayerKnight extends Player{
    public PlayerKnight(String name){
        super(name);
        id = "Knight";
        //Change later obviously
        attacks = new Attack[]{new AttackSwordSlash(), new AttackSwordSlash(), new AttackSwordSlash(), new AttackSwordSlash()};
        mainAtt = 1;
        attributes = new double[]{3, 5, 3};
        baseStats = new double[]{10, 17.5, 4.7, 8.05, 90, 41};
        this.calculateRealStats();
    }
}
