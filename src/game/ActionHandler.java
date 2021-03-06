package game;

import chars.players.Player;
import shop.Shop;
import shop.ShopBasic;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionHandler implements ActionListener{
	private JPanel contentPane;
	private Client client;
	private Player user;
	private JFrame frame;
    private Shop shop;

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

    public void getShop(Shop s) {
        shop = s;
    }

    public void actionPerformed(ActionEvent event) {
		String eventName = event.getActionCommand();
		System.out.println(eventName);
        if (eventName.equals("confirm")) {
            client.createUser();
        } else if (eventName.equals("Stats")) {
            user.getAllStats(contentPane, this);
			Calcs.display(frame, contentPane);
        } else if (eventName.equals("Return")) {
            client.quest();
        } else if (eventName.equals("Inventory")) {
            user.inventoryMenu(contentPane, frame, this);
        } else if (eventName.equals("class")) {
            client.infoSelectPlayer();
		} else if (eventName.equals("PInfo")) {
			client.checkUser();
		} else if (eventName.contains("Inf")) {
			client.infoPlayer(eventName.substring(3));
        } else if (eventName.equals("ReturnM")) {
            contentPane.removeAll();
			client.startGame();
        } else if (eventName.equals("ReturnI")) {
            client.infoSelectPlayer();
		} else if (eventName.equals("ReturnP")) {
			client.checkUser();
        } else if (eventName.equals("Attacks")) {
            user.getAllAttacks(contentPane, this);
            Calcs.display(frame, contentPane);
        } else if (eventName.contains("invmenu")) {
            user.itemMenu(Integer.parseInt(eventName.substring(0, 1)), frame, contentPane, this);
        } else if (eventName.contains("item")) {
            user.useItem(Integer.parseInt(eventName.substring(0, 1)), contentPane, frame, this);
        } else if (eventName.equals("Shop")) {
            new ShopBasic(this).displayShop(contentPane, frame, this, user.getMoney());
        } else if (eventName.contains("shoop")) {
            shop.displayItem(contentPane, frame, this, Integer.parseInt(eventName.substring(0, 1)));
        } else if (eventName.equals("ShopR")) {
            shop.displayShop(contentPane, frame, this, user.getMoney());
        } else if (eventName.contains("purchase")) {
            user.boughtItem(shop.getItem(Integer.parseInt(eventName.substring(0, 1))));
            shop.displayShop(contentPane, frame, this, user.getMoney());
        }
    }

}
