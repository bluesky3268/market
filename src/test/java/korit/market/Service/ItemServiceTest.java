package korit.market.Service;

import korit.market.Repository.ItemRepository;
import korit.market.entity.Item;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ItemServiceTest {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void 최근추가된상품() {

        Item item = itemRepository.findTopByOrderByItemNoDesc();

        Assertions.assertThat(item.getItemNo()).isEqualTo(4);

        System.out.println("item : " + item.getItemNo() + ", " + item.getItemName());

    }


}