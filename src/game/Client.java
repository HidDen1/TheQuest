package game;

import chars.players.Player;
import chars.players.PlayerKnight;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
/*
 * TODO: Rewrite items
 * Rewrite Inventory
 * Rewrite Shop
 * Rewrite and Fwrite armor
 * Add equipable items 
 */
public class Client {
	private JFrame frame = new JFrame("The Quest");
	private JPanel contentPane = new JPanel();
	private ActionHandler aH = new ActionHandler();
	private Player user;
	
	private Client(){
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		aH.getContentPane(contentPane);
		aH.getFrame(frame);
		aH.getClient(this);
		startGame();
	}

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> startGUI());
    }

    private static void startGUI() {
        JFrame.setDefaultLookAndFeelDecorated(false);
        @SuppressWarnings("unused")
        Client beginning = new Client();
    }

	void infoSelectPlayer(){
		contentPane.removeAll();
        contentPane.setLayout(new GridLayout(0, 2, 10, 10));
		Calcs.createButton(Player.getPlayerTypeNames(), Calcs.createNumLock(Player.getPlayerTypeNames(), 0), aH, contentPane);
		Calcs.createButton(new String[]{"Return"}, new String[]{"ReturnM"}, aH, contentPane);
		Calcs.display(frame, contentPane);
	}
	
	void infoPlayer(String name){
		int index = Arrays.binarySearch(Player.getPlayerTypeNames(), name);
        contentPane.removeAll();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        contentPane.add(new Label(name));
        for (int i = 0; i < 5; i++) {
            contentPane.add(new Label(Player.getPlayerTypes()[index].getAttacks()[i].getName() + ": " + Player.getPlayerTypes()[index].getAttacks()[i].getToolTip()));
		}
        Calcs.createButton(new String[]{"Return"}, new String[]{"ReturnI"}, aH, contentPane);
        Calcs.display(frame, contentPane);
	}

	@SuppressWarnings("unchecked")
    void createUser(){
		final Component getChoice[] = contentPane.getComponents();
        switch(((JComboBox<String>)getChoice[1]).getSelectedIndex()){
            case 0:
                user = new PlayerKnight(((JTextField) getChoice[0]).getText());
                break;
        }
		aH.getPlayer(user);
		this.quest();
	}
	
	void quest(){
        final String[] text = {"Go on a quest[Redacted]", "Player info", "Go to the shop[Redacted]",
                "Check your inventory[Redacted]", "Enemy Info[Redacted]"};
        final String[] cmd = {"Quest", "PInfo", "Shop", "Inventory", "Enemy"};

		contentPane.removeAll();
		contentPane.setLayout(new GridLayout(0, 2, 10, 10));
		Calcs.createButton(text, cmd, aH, contentPane);
		Calcs.display(frame, contentPane);
	}

    //Move murder counts of enemies into stats
    void checkUser() {
        final String[] text = {"Your Attacks", "Your Stats", "Return"};
        final String[] cmd = {"Attacks", "Stats", "Return"};

        contentPane.removeAll();
        contentPane.setLayout(new GridLayout(0, 2, 10, 10));
        Calcs.createButton(text, cmd, aH, contentPane);
        Calcs.display(frame, contentPane);
    }

    void startGame(){
        contentPane.setLayout(new GridLayout(0, 4, 10, 5));
		contentPane.add(new JTextField("Enter your name", 15));
		contentPane.add(new JComboBox<>(Player.getPlayerTypeNames()));
		Calcs.createButton(new String[]{"Confirm", "Class info"}, new String[]{"confirm", "class"}, aH, contentPane);
		Calcs.display(frame, contentPane);
	}
}
