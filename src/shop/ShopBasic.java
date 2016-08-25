package shop;

import game.ActionHandler;
import items.Item;

import java.util.Arrays;

public class ShopBasic extends Shop {

    public ShopBasic(ActionHandler aH) {
        super(aH);
        items.addAll(Arrays.asList(Item.getItems(new int[]{0})));
        shopName = "Basic Shop";
        leaveCode = "Return";
    }
}
