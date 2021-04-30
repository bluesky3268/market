package korit.market.Repository;

import korit.market.domain.Item;

import java.util.HashMap;
import java.util.Map;

public class ItemRepository {

    private Map<Long, Item> store = new HashMap<>();

    public void itemAdd(Item item) {
        store.put(item.getItemNo(), item);
    }

    public void itemUpdate(Long itemId, Item itemParam ){

    }


}
