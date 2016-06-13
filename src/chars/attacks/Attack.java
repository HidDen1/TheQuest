package chars.attacks;

public abstract class Attack {
    protected String name, toolTip, typeString;
    protected int type, cost;
    protected double damage;
    public String[] ATTACK_TYPES = {"Physical", "Magical"};

    public String getName(){ return name; }
    public String getToolTip(){ return toolTip; }
    public String getTypeString(){ return  typeString; }
    public int getType(){ return type; }
    public double getDamage(){ return damage; }

}
