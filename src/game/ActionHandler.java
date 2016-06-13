package game;

import chars.players.Player;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ActionHandler implements ActionListener{
	private JPanel contentPane;
	private Client client;
	private Player user;
	private JFrame frame;
	
	public void getContentPane(JPanel cPane){
		contentPane = cPane;
	}
	
	public void getClient(Client c){
		client = c;
	}
	
	public void getPlayer(Player p){
		user = p;
	}
	
	public void getFrame(JFrame f){
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
		} else if(eventName.indexOf("0") != -1){
			client.infoPlayer(eventName.substring(1));
		} else if(eventName.equals("ReturnM")){
			contentPane.removeAll();
			client.startGame();
		} else if(eventName.equals("ReturnI")){
            client.infoSelectPlayer();
		}
	}

}
