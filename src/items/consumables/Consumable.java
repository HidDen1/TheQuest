package items.consumables;

import game.ActionHandler;
import items.Item;

import javax.swing.*;

public class Consumable extends Item {
    @Override
    public void menu(int place, JFrame frame, JPanel contentPane, ActionHandler aH) {
        //TODO use or return
        contentPane.removeAll();
        contentPane.add(new JLabel("Are you sure you want to use your " + getName() + "?"));
        contentPane.add(new JLabel());
        JButton button = new JButton("Yes"), button2 = new JButton("No");
        button.addActionListener(aH);
        button2.addActionListener(aH);
        button.setActionCommand(place + "item");
        button2.setActionCommand("ReturnInv");
        contentPane.add(button);
        contentPane.add(button2);
    }

    @Override
    public boolean used() {
        //change l8r
        return false;
    }
}
