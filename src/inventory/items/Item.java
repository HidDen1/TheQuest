package inventory.items;

public abstract class Item {
	boolean usability;
	String name, tooltip;
	int id;

	public boolean isUsable(){
		return(usability);
	}
	
	public String getName(){
		return(name);
	}
	
	public String getTooltip(){
		return(tooltip);
	}
	
	public int getID(){
		return(id);
	}
}
