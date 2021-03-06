package chars.players;

import chars.Indiv;
import game.ActionHandler;
import game.Calcs;
import items.Item;

import javax.swing.*;

public abstract class Player extends Indiv {

    Player(String name) {
        this.name = name;
        level = 1;
        gold = 50;
	}

    public static Player[] getPlayerTypes(){
        return new Player[]{new PlayerKnight("")};
    }

    public static Player[] getPlayerTypes(int[] i) {
        Player[] players = getPlayerTypes(), toReturn = new Player[i.length];
        int count = 0;
        for (int j : i) {
            toReturn[count] = players[j];
            count++;
        }
        return toReturn;
    }

    public static String[] getPlayerTypeNames(){
        String[] get = new String[getPlayerTypes().length];
        for(int i = 0; i < get.length; i++){
            get[i] = getPlayerTypes()[i].getType();
        }
        return get;
    }

    public void boughtItem(Item i) {
        gold -= i.getValue();
        inventory.add(i);
        //TODO: Add a message here for user
    }

    public void inventoryMenu(JPanel contentPane, JFrame frame, ActionHandler aH) {
        contentPane.removeAll();
        int count = 0;
        for (Item i : inventory) {
            JButton button = new JButton(i.getName());
            button.setToolTipText(i.getTooltip());
            button.addActionListener(aH);
            button.setActionCommand(count + "invmenu");
            contentPane.add(button);
            count++;
        }
        JButton button = new JButton("Back");
        button.addActionListener(aH);
        button.setActionCommand("Return");
        contentPane.add(button);
        Calcs.display(frame, contentPane);
    }

    public void itemMenu(int num, JFrame frame, JPanel contentPane, ActionHandler aH) {
        inventory.get(num).menu(num, frame, contentPane, aH);
    }

}
