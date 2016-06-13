package chars.attacks;

public class AttackSwordSlash extends Attack{
    public AttackSwordSlash(){
        name = "Sword Slash";
        toolTip = "You slash your mighty sword at the enemy. Type: Physical Cost: 8 BP";
        type = 0;
        typeString = ATTACK_TYPES[0];
        cost = 8;
        damage = 0000;
    }
}
