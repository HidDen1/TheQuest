package items.consumables;

public class ConsumableHealthPotion extends Consumable {

    public ConsumableHealthPotion() {
        name = "Health Potion";
        tooltip = "Heals for 50";
        message = " been healed for 50 points";
        value = 20;
        toEffect = 4;
        attr = false;
        effect = 50;
    }

}