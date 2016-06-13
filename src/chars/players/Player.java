package chars.players;

import chars.Indiv;
import items.Item;

public class Player extends Indiv {

	public Player(String name){
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
	
}
