package shop;

import game.ActionHandler;
import game.Calcs;
import items.Item;

import javax.swing.*;
import java.util.ArrayList;

public abstract class Shop {
    private ArrayList<Item> items = new ArrayList<>();
    private String shopName, leaveCode;

    public Shop(ActionHandler aH) {
        aH.getShop(this);
    }

    public void displayShop(JPanel contentPane, JFrame frame, ActionHandler aH, int money) {
        contentPane.removeAll();
        JLabel label = new JLabel("Hello traveller and welcome to the " + shopName);
        contentPane.add(label);
        for (int i = 0; i < items.size(); i++) {
            JButton button = new JButton(items.get(i).getName());
            button.addActionListener(aH);
            if (money < items.get(i).getValue()) {
                button.setEnabled(false);
                button.setToolTipText("This costs " + items.get(i).getValue() + " and you have only " + money + "!");
            } else {
                button.setToolTipText(items.get(i).getTooltip());
            }
            button.setActionCommand(i + "shop");
            contentPane.add(button);
        }
        JButton button = new JButton("Leave");
        button.addActionListener(aH);
        button.setActionCommand(leaveCode);
        contentPane.add(button);
        Calcs.display(frame, contentPane);
    }


    public void displayItem(JPanel contentPane, JFrame frame, ActionHandler aH, int placement) {
        contentPane.removeAll();
    }
}
