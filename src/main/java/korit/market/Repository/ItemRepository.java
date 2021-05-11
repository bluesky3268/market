package korit.market.Repository;

import korit.market.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface ItemRepository extends JpaRepository<Item, Long> {

    Item findByItemNo(Long itemId);

}
