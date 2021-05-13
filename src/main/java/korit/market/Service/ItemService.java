package korit.market.Service;

import korit.market.Repository.ItemRepository;
import korit.market.entity.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    /**
     * 메인페이지 - 신상품 가져오기
     */
    public List<Item> brandNew() {
//         가장 최근 추가된 상품의 번호 찾기
        Item item = itemRepository.findTopByOrderByItemNoDesc();
        Long itemId = item.getItemNo();
        Long needItemId = itemId-4;
        List<Item> brandNewList = itemRepository.findAllByItemNoGreaterThan(needItemId);
        return brandNewList;
    }
    

    /**
     * 장바구니 담기
     */

    /**
     * 결제하기
     */

    /**
     * 주문상세내역(주문확인서) 보기
     */

    /**
     *  주문내역 보기
     */


/*    @Autowired
    ItemRepository itemRepository;

    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    public List<Item> findItems() {
        return itemRepository.findAll();
    }

    public Item findOne(Long itemNo) {
        return itemRepository.findOne(itemNo);
    }*/

}
