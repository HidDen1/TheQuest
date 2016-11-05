package chars;

import items.Item;

public abstract class Slot {
    String name;
    Item equip;

    public Slot(String name) {
        this.name = name;
    }

    public void equip(Item i) {
        equip = i;
    }

    public void removeEquipped() {
        equip = null;
    }

    public boolean isEquipped() {
        if (equip == null)
            return false;
        else
            return true;
    }

    public String toString() {
        return name + ": " + equip.getName() /* Some other stuff that says This attribute: effect num */;
    }
}
