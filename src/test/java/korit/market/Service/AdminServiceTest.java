package korit.market.Service;

import korit.market.Repository.ItemRepository;
import korit.market.entity.Item;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AdminServiceTest {

    @Autowired
    ItemRepository itemRepository;

    @Test
    public void findByItemNo() {
        Long itemNo = 6L;
        Item item = itemRepository.findByItemNo(itemNo);

        Assertions.assertThat(item.getItemName()).isEqualTo("상품샘플2");
    }


}