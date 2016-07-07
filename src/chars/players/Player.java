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

    public static String[] getPlayerTypeNames(){
        String[] get = new String[getPlayerTypes().length];
        for(int i = 0; i < get.length; i++){
            get[i] = getPlayerTypes()[i].getType();
        }
        return get;
    }

    public void addToInventory(Item i){
        inventory.add(i);
    }

    public boolean invEmpty() {
        return inventory.isEmpty();
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

}
