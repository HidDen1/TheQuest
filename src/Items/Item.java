package items;

import game.ActionHandler;
import items.consumables.ConsumableHealthPotion;

import javax.swing.*;

public abstract class Item {
    static final int HEALTH_CODE = -1, MAX_HEALTH_CODE = -2, MANA_CODE = -3, MAX_MANA_CODE = -4;
    protected String name, tooltip, message;
    protected int value, toEffect;
    protected boolean attr, use;
    protected double effect;

    public static Item[] getItems() {
        return new Item[]{new ConsumableHealthPotion()};
    }

    public static Item[] getItems(int[] i) {
        Item[] items = getItems(), toReturn = new Item[i.length];
        int count = 0;
        for (int j : i) {
            toReturn[count] = items[j];
            count++;
        }
        return toReturn;
    }

    public static Item[] getConsumables() {
        return new Item[]{new ConsumableHealthPotion()};
    }

    public static Item[] getConsumables(int[] i) {
        Item[] items = getConsumables(), toReturn = new Item[i.length];
        int count = 0;
        for (int j : i) {
            toReturn[count] = items[j];
            count++;
        }
        return toReturn;
    }

    public String getName() {
        return (name);
    }

    public String getTooltip() {
        return (tooltip);
    }

    public int getValue() {
        return value;
    }

    public abstract void menu(int place, JFrame frame, JPanel contentPane, ActionHandler aH);

    public boolean getAttr() {
        return attr;
    }

    public int getToEffect() {
        return toEffect;
    }

    public double getEffect() {
        return effect;
    }

    public String getMessage() {
        return message;
    }

    public abstract boolean used();

    public abstract void use();
}
