package korit.market.Service;

import korit.market.Repository.CategoryRepository;
import korit.market.Repository.ItemRepository;
import korit.market.entity.Category;
import korit.market.entity.Item;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ItemServiceTest {

    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void 최근추가된상품() {

        Item item = itemRepository.findTopByOrderByItemNoDesc();

        Assertions.assertThat(item.getItemNo()).isEqualTo(4);

        System.out.println("item : " + item.getItemNo() + ", " + item.getItemName());

    }

    @Test
    public void 카테고리별_상품검색() {

        Category categoryId_result = categoryRepository.findByCategoryId(100L);

        List<Item> result = itemRepository.findAllByCategoryEquals(categoryId_result);

        Assertions.assertThat(result.size()).isEqualTo(4);

    }


    @Test
    public void 메인페이지_카테고리출력() {
        Long categoryId = 100L;
        Category categoryId_result = categoryRepository.findByCategoryId(categoryId);

        List<Item> items = itemRepository.findAllByCategoryEquals(categoryId_result);
        System.out.println("itemList : " + items);

        int size = items.size();
        System.out.println("size = " + size);

        int start = size - 1;
        int end = start - 3;


        for (int i = start; i >= end ; i--) {
            List<Item> addItem = new ArrayList<>();
            addItem.add(items.get(i));
            System.out.println(addItem);
        }

    }

}