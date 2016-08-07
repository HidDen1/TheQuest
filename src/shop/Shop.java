package shop;

import game.ActionHandler;
import game.Calcs;
import items.Item;

import javax.swing.*;
import java.util.ArrayList;

public abstract class Shop {
    private ArrayList<Item> items = new ArrayList<>();
    private String shopName;

    public Shop(ActionHandler aH) {
        aH.getShop(this);
    }

    public void displayShop(JPanel contentPane, JFrame frame, ActionHandler aH) {
        contentPane.removeAll();
        JLabel label = new JLabel("Hello traveller and welcome to the " + shopName);
        contentPane.add(label);
        for (int i = 0; i < items.size(); i++) {
            JButton button = new JButton(items.get(i).getName());
            button.addActionListener(aH);
            button.setToolTipText(items.get(i).getTooltip());
            button.setActionCommand(i + "shop");
            contentPane.add(button);
        }
        JButton button = new JButton("Leave");
        button.addActionListener(aH);
        button.setActionCommand("to be decided");
        contentPane.add(button);
        Calcs.display(frame, contentPane);
    }
}
