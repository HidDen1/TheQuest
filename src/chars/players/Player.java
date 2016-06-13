package chars.players;

import chars.Indiv;

public class Player extends Indiv {

	public Player(String name){
		this.name = name;
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
	
}
