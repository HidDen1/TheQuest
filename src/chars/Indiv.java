package chars;

import chars.attacks.Attack;
import game.ActionHandler;
import game.Calcs;
import inventory.Inventory;

import javax.swing.*;

public abstract class Indiv {
	protected double attributes[] = new double[3], baseStats[] = new double[6], realStats[] = new double[6];
	protected int numID, gold, level;
	protected String name, id;
	static final String[] ATTRIBUTE_NAMES = {"Agility", "Strength", "Intelligence"}, STAT_NAMES = {"Attack", "Defense", "Evasion", "Speed", "Health", "Mana"};
    protected Attack[] attacks = new Attack[4];
	Inventory inventory = new Inventory();
	
	public Inventory getInventory(){
		return(inventory);
	}
	
	public double getAttributes(int get){
		return(attributes[get]);
	}
	
	public double getBaseStats(int get){
		return(baseStats[get]);
	}
	
	public double getRealStats(int get){
		return(realStats[get]);
	}

	public String getType(){ return id; }

	public Attack[] getAttacks(){ return attacks; }
	
	protected void calculateRealStats(){ //Change so specific attributes give the damage for diff classes
		int attOrder[] = {1, 0, 0, 0, 1, 2};
		double multi[] = {2, 0.25, 0.1, 0.65, 2, 3};
		for(int i = 0; i < 6; i++){
			realStats[i] = baseStats[i] + attributes[attOrder[i]] * multi[i];
		}
	}
	
	public void getAllStats(JPanel contentPane, ActionHandler aH){
		String label[] = new String[10];
		
		contentPane.removeAll();
		Calcs.createLabels(new String[]{"Name: " + name, "Class: " + id, "Level: " + level}, contentPane);
		for(int i = 0; i < 6; i++){
			if(i < 3){
				label[i] = ATTRIBUTE_NAMES[i] + ": " + attributes[i];
			}
			label[i + 3] = STAT_NAMES[i] + ": " + realStats[i];
		}
		for(int i = 0; i < 9; i++){
			JLabel line = new JLabel(label[i]);
			contentPane.add(line);
		}
		contentPane.add(new JLabel("Gold: " + gold));
		JButton button = new JButton("Return");
		button.addActionListener(aH);
		button.setActionCommand("Return");
		contentPane.add(button);
	}
}