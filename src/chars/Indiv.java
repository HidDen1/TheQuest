package chars;

import chars.attacks.Attack;
import game.ActionHandler;
import game.Calcs;
import items.Item;

import javax.swing.*;
import java.util.ArrayList;

public abstract class Indiv {
    static final String[] ATTRIBUTE_NAMES = {"Agility", "Strength", "Intelligence"}, STAT_NAMES = {"Attack", "Defense", "Evasion", "Speed"};
    static final int AGILITY_NUM = 0, STRENGTH_NUM = 1, INTELLIGENCE_NUM = 2, ATTACK_NUM = 0, DEFENSE_NUM = 1, EVASION_NUM = 2, SPEED_NUM = 3;
    public Stat health, mana;
    protected double attributes[] = new double[3], itemAttr[] = new double[3], itemStats[] = new double[4], baseStats[] = new double[4], realStats[] = new double[4];
    protected int gold, level, mainAtt;
	protected String name, id;
    protected Attack[] attacks = new Attack[5];
    protected ArrayList<Item> inventory = new ArrayList<>();
    protected boolean itemUsagePronouns;

    public int getMoney() {
        return gold;
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

    public boolean invEmpty() {
        return inventory.isEmpty();
    }

	public String getType(){ return id; }

	public Attack[] getAttacks(){ return attacks; }

    protected void calculateRealStats() {
        int attOrder[] = {mainAtt, mainAtt, 0, 0, 1, 2};
		double multi[] = {2, 0.5, 0.1, 0.65, 2, 3};
		for(int i = 0; i < 6; i++){
            if (i != 4 && i != 5)
                realStats[i] = baseStats[i] + attributes[attOrder[i]] * multi[i];
            else if (i == 4)
                health = new Stat(health.getBase(), health.getBase() + attributes[attOrder[i]] * multi[i]);
            else
                mana = new Stat(mana.getBase(), mana.getBase() + attributes[attOrder[i]] * multi[i]);
        }
	}

    public void addToInventory(Item i) {
        inventory.add(i);
    }

    public void getAllStats(JPanel contentPane, ActionHandler aH){
		String label[] = new String[10];
		
		contentPane.removeAll();
		Calcs.createLabels(new String[]{"Name: " + name, "Class: " + id, "Level: " + level}, contentPane);
		for(int i = 0; i < 6; i++){
			if(i < 3){
				label[i] = ATTRIBUTE_NAMES[i] + ": " + attributes[i];
			}
            if (i != 4 && i != 5)
                label[i + 3] = STAT_NAMES[i] + ": " + realStats[i];
            else if (i == 4)
                label[i + 3] = "Health: " + health.getNum() + "/" + health.getMax();
            else
                label[i + 3] = "Mana: " + mana.getNum() + "/" + mana.getMax();
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

    public void calculateRealAttackDamage() {
        for (Attack i : attacks) {
            i.setRealDamage(realStats[0]);
        }
    }

    public void useItem(int num, JPanel contentPane, JFrame frame, ActionHandler aH) {
        Item item = inventory.get(num);
        item.use();
        if (item.getAttr())
            itemAttr[item.getToEffect()] += item.getEffect();
        else if (item.getToEffect() < 0) {
            if (item.getToEffect() == -1)
                health.changeNum(health.getNum() + item.getEffect());
            else if (item.getToEffect() == -2)
                health.changeMax(health.getMax() + item.getEffect());
            else if (item.getToEffect() == -3)
                mana.changeNum(mana.getNum() + item.getEffect());
            else if (item.getToEffect() == -4)
                mana.changeMax(mana.getMax() + item.getEffect());
        } else
            itemStats[item.getToEffect()] += item.getEffect();
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