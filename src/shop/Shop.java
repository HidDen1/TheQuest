package shop;

import game.ActionHandler;
import game.Calcs;
import items.Item;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public abstract class Shop {
    protected ArrayList<Item> items = new ArrayList<>();
    protected String shopName, leaveCode;

    public Shop(ActionHandler aH) {
        aH.getShop(this);
    }

    public Item getItem(int i) {
        return items.get(i);
    }

    public void displayShop(JPanel contentPane, JFrame frame, ActionHandler aH, int money) {
        contentPane.removeAll();
        contentPane.setLayout(new GridLayout(0, 1, 10, 10));
        JLabel label = new JLabel("\"Hello traveller and welcome to the " + shopName + ".\" You have " + money + " gold.");
        contentPane.add(label);
        for (int i = 0; i < items.size(); i++) {
            JButton button = new JButton(items.get(i).getName() + " (Cost: " + items.get(i).getValue() + "G)");
            button.addActionListener(aH);
            if (money < items.get(i).getValue()) {
                button.setEnabled(false);
                button.setToolTipText("This costs " + items.get(i).getValue() + " and you have only " + money + "!");
            } else {
                button.setToolTipText(items.get(i).getTooltip());
            }
            button.setActionCommand(i + "shoop");
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
        JLabel label = new JLabel("Are you sure you want to purchase the " + items.get(placement).getName() + " for " + items.get(placement).getValue() + " gold?");
        contentPane.add(label);
        JButton button = new JButton("Yes");
        JButton button1 = new JButton("No");
        button.addActionListener(aH);
        button1.addActionListener(aH);
        button.setActionCommand(placement + "purchase");
        button1.setActionCommand("ShopR");
        contentPane.add(button);
        contentPane.add(button1);
        Calcs.display(frame, contentPane);
    }
}
