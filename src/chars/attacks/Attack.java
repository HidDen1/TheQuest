package chars.attacks;

public abstract class Attack {
    String name, toolTip;
    int cost;
    double base, real;

    public String getName(){ return name; }
    public String getToolTip(){ return toolTip; }

    public double getRealDamage() {
        return real;
    }

    public void setRealDamage(double attribute) {
        real = base + attribute;
    }

    public double getBaseDamage() {
        return base;
    }

    public int getCost() {
        return cost;
    }

}