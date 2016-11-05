package items.consumables;

import items.Item;

public class ConsumableHealthPotion extends Consumable {

    public ConsumableHealthPotion() {
        name = "Health Potion";
        tooltip = "Heals for 50";
        message = " been healed for 50 points";
        value = 20;
        toEffect = Item.HEALTH_CODE;
        attr = false;
        effect = 50;
    }

}