package items;

public abstract class Item {
    String name, tooltip;
    int id;

    public String getName() {
        return (name);
    }

    public String getTooltip() {
        return (tooltip);
    }

    public int getID() {
        return (id);
    }
}
