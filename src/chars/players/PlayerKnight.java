package chars.players;

import chars.attacks.AttackSwordSlash;

public class PlayerKnight extends Player{
    public PlayerKnight(String name){
        super(name);
        id = "Knight";
        //Change later obviously
        attacks[0] = new AttackSwordSlash();
        attacks[1] = new AttackSwordSlash();
        attacks[2] = new AttackSwordSlash();
        attacks[3] = new AttackSwordSlash();
        this.calculateRealStats();
    }
}
