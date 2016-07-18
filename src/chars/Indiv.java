package chars;

import chars.attacks.Attack;
import game.ActionHandler;
import game.Calcs;
import items.Item;

import javax.swing.*;
import java.util.ArrayList;

public abstract class Indiv {
    static final String[] ATTRIBUTE_NAMES = {"Agility", "Strength", "Intelligence"}, STAT_NAMES = {"Attack", "Defense", "Evasion", "Speed", "Health", "Mana"};
    protected double attributes[] = new double[3], itemAttr[] = new double[3], itemStats[] = new double[6], baseStats[] = new double[6], realStats[] = new double[6];
    protected int gold, level, mainAtt;
	protected String name, id;
    protected Attack[] attacks = new Attack[5];
    protected ArrayList<Item> inventory = new ArrayList<>();
    protected boolean itemUsagePronouns;

	public double getAttributes(int get){
		return(attributes[get]);
	}
	
	public double getBaseStats(int get){
		return(baseStats[get]);
	}
	
	public double getRealStats(int get){
		return(realStats[get]);
	}

    public boolean invEmpty() {
        return inventory.isEmpty();
    }

	public String getType(){ return id; }

	public Attack[] getAttacks(){ return attacks; }

    //TODO Will need changed with update to stats
    protected void calculateRealStats() {
        int attOrder[] = {mainAtt, mainAtt, 0, 0, 1, 2};
		double multi[] = {2, 0.5, 0.1, 0.65, 2, 3};
		for(int i = 0; i < 6; i++){
			realStats[i] = baseStats[i] + attributes[attOrder[i]] * multi[i];
		}
	}

    //TODO Will need changed with update to stats
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
        button.setActionCommand("ReturnP");
        contentPane.add(button);
	}

    public void getAllAttacks(JPanel contentPane, ActionHandler aH) {

        contentPane.removeAll();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        calculateRealAttackDamage();
        for (Attack i : attacks) {
            if (i.getBaseDamage() == 0) {
                contentPane.add(new JLabel(i.getName() + ": " + i.getToolTip() + " Damage: " + i.getRealDamage()));
            } else {
                contentPane.add(new JLabel(i.getName() + ": " + i.getToolTip() + " Damage: " + i.getBaseDamage() + " + (" + (i.getRealDamage() - i.getBaseDamage()) + ") Cost: " + i.getCost()));
            }
        }
        JButton button = new JButton("Return");
        button.addActionListener(aH);
        button.setActionCommand("ReturnP");
        contentPane.add(button);
    }

    //TODO Will need changed with update to stats
    public void calculateRealAttackDamage() {
        for (Attack i : attacks) {
            i.setRealDamage(realStats[0]);
        }
    }

    //TODO Will need changed w/ update to stats
    public void useItem(int num, JPanel contentPane, JFrame frame, ActionHandler aH) {
        Item item = inventory.get(num);
        item.use();
        if (item.getAttr()) {
            itemAttr[item.getToEffect()] += item.getEffect();
        } else {
            itemStats[item.getToEffect()] += item.getEffect();
        }
        String s = item.getMessage();
        if (itemUsagePronouns) {
            s = "You have " + s;
        } else {
            s = "Your enemy has " + s;
        }
        contentPane.removeAll();
        JLabel label = new JLabel(s);
        JButton button = new JButton("Okay");
        button.addActionListener(aH);
        cleanUpItems();
        //Check battle status when added l8r
        if (invEmpty()) {
            button.setActionCommand("Return");
        } else {
            button.setActionCommand("Inventory");
        }
        contentPane.add(label);
        contentPane.add(button);
        Calcs.display(frame, contentPane);
    }

    public void cleanUpItems() {
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).used()) {
                inventory.remove(i);
            }
        }
    }
}