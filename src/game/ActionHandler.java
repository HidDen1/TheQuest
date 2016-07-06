package game;

import chars.players.Player;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionHandler implements ActionListener{
	private JPanel contentPane;
	private Client client;
	private Player user;
	private JFrame frame;

	void getContentPane(JPanel cPane) {
		contentPane = cPane;
	}

	void getClient(Client c) {
		client = c;
	}

	void getPlayer(Player p) {
		user = p;
	}

	void getFrame(JFrame f) {
		frame = f;
	}
	
	public void actionPerformed(ActionEvent event) {
		String eventName = event.getActionCommand();
		System.out.println(eventName);
		if(eventName.equals("confirm")){
			client.createUser();
		} else if(eventName.equals("Stats")){
			user.getAllStats(contentPane, this);
			Calcs.display(frame, contentPane);
		} else if(eventName.equals("Return")){
			client.quest();
		} else if(eventName.equals("Inventory")){
			//TODO Heyo redo this
			//Calcs.display(frame, contentPane);
		} else if(eventName.equals("class")){
			client.infoSelectPlayer();
        } else if (eventName.contains("0")) {
            client.infoPlayer(eventName.substring(1));
		} else if(eventName.equals("ReturnM")){
			contentPane.removeAll();
			client.startGame();
		} else if(eventName.equals("ReturnI")){
            client.infoSelectPlayer();
        } else if (eventName.equals("PInfo")) {
            client.checkUser();
        } else if (eventName.equals("ReturnP")) {
            client.checkUser();
        } else if (eventName.equals("Attacks")) {
            user.getAllAttacks(contentPane, this);
            Calcs.display(frame, contentPane);
        }
    }

}
