package items;

import game.ActionHandler;

import javax.swing.*;

public abstract class Item {
    String name, tooltip;
    int value;
    boolean attr;
    double effect;

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

    public abstract boolean used();
}
