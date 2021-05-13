package korit.market.Repository;

import korit.market.entity.Item;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ItemRepository extends JpaRepository<Item, Long> {

    Item findByItemNo(Long itemNo);

    Item findTopByOrderByItemNoDesc();
    List<Item> findAllByItemNoGreaterThan(Long number);
}
