package items.equipables;

import game.ActionHandler;
import game.Calcs;
import items.Item;

import javax.swing.*;

public abstract class Equipable extends Item {
    //Make this so it knows what "slot" it can go into, make sure it knows if it is equipped
    @Override
    public void menu(int place, JFrame frame, JPanel contentPane, ActionHandler aH) {
        //TODO use or return
        contentPane.removeAll();
        contentPane.add(new JLabel("Are you sure you want to use equip your " + getName() + "?"));
        contentPane.add(new JLabel());
        JButton button = new JButton("Yes"), button2 = new JButton("No");
        button.addActionListener(aH);
        button2.addActionListener(aH);
        //button.setActionCommand(place + "item"); to change
        //button2.setActionCommand("Inventory"); to change
        contentPane.add(button);
        contentPane.add(button2);
        Calcs.display(frame, contentPane);
    }
}
