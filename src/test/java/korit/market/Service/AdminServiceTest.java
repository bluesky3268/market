package korit.market.Service;

import korit.market.Repository.CategoryRepository;
import korit.market.Repository.ItemRepository;
import korit.market.Repository.MemberRepository;
import korit.market.entity.Category;
import korit.market.entity.Item;
import korit.market.entity.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Iterator;
import java.util.List;

@SpringBootTest
class AdminServiceTest {

    @Autowired
    ItemRepository itemRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    MemberRepository memberRepository;

    @Test
    public void findByItemNo() {
        Long itemNo = 6L;
        Item item = itemRepository.findByItemNo(itemNo);

        Assertions.assertThat(item.getItemName()).isEqualTo("상품샘플2");
    }

    @Test
    public void findMembers() {
        List<Member> members = memberRepository.findAll();

        Assertions.assertThat(members.size()).isEqualTo(2);
    }

    @Test
    public void findCategories() {
        List<Category> categories = categoryRepository.findAll();

        Assertions.assertThat(categories.size()).isEqualTo(4);
    }

    @Test
    public void findCategoryById() {
        Long id = 10L;
        Category category = categoryRepository.findByCategoryId(id);

        Assertions.assertThat(category.getCategoryName()).isEqualTo("텐트");

    }

    @Test
    public void findCategoryByName() {
        String name = "텐트";
        Category category = categoryRepository.findByCategoryName(name);

        Assertions.assertThat(category.getCategoryId()).isEqualTo(10L);
    }

}