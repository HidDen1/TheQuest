package items;

import game.ActionHandler;

import javax.swing.*;

public abstract class Item {
    protected String name, tooltip;
    protected int value, toEffect;
    protected boolean attr, use;
    protected double effect;

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

    public abstract boolean used();

    public abstract void use();
}
