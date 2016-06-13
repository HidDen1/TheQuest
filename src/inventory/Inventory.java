package inventory;

import game.ActionHandler;
import game.Calcs;

import javax.swing.JPanel;

public class Inventory {
	//ArrayLists for consumables, armor, weapons, and equipment
	public Inventory(){
		
	}
	
	public void menu(ActionHandler aH, JPanel contentPane){
		final String NAMES[] = {"Consumables", "Armor", "Weapons", "Equipment", "Return"};
		contentPane.removeAll();
		Calcs.createButton(NAMES, NAMES, aH, contentPane);
		}
}

