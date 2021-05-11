package korit.market.Repository;

import korit.market.entity.Admin;
import korit.market.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Long> {

    public List<Item> findByItemName(String keyword);

    Item findByItemNo(Long itemId);
}
