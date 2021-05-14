package korit.market.Service;

import korit.market.Repository.CategoryRepository;
import korit.market.Repository.ItemRepository;
import korit.market.entity.Category;
import korit.market.entity.Item;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;
    private final CategoryRepository categoryRepository;

    /**
     * 메인페이지 - 신상품 가져오기
     */
    public List<Item> brandNew() {

//         가장 최근 추가된 상품의 번호 찾기
        Item item = itemRepository.findTopByOrderByItemNoDesc();
        Long itemNo = item.getItemNo();
        if(itemNo > 4) {
            Long i = itemNo - 4;
            List<Item> brandNewList = itemRepository.findAllByItemNoGreaterThan(i);
            return brandNewList;
        }else{
            List<Item> brandNewList = itemRepository.findAll();
            return brandNewList;
        }

    }

    /** 상품 리스트(카테고리별로) 찾기 */
    public List<Item> findItemsByCatNo(Long categoryId) {

        Category categoryId_result = categoryRepository.findByCategoryId(categoryId);

        List<Item> items = itemRepository.findAllByCategoryEquals(categoryId_result);

        log.info("item list : " + items);
        return items;
    }

    /** 메인페이지 최근 추가된 상품4개 리스트 가져오기 */
    public List<Item> findItems(Long categoryId) {

        Category categoryId_result = categoryRepository.findByCategoryId(categoryId);

        List<Item> items = itemRepository.findAllByCategoryEquals(categoryId_result);

        int size = items.size();
        System.out.println("size = " + size);

        int start = size - 1;
        int end = start - 3;

        List<Item> addItem = new ArrayList<>();

        if(start >= 4) {
            for (int i = start; i >= end; i--) {
                addItem.add(items.get(i));
                log.info("addItem : " + addItem);
            }
            return addItem;
        }
        return items;
    }


    /** 단일 상품 찾기 */
    public Item findItem(Long itemNo) {
        Item findItem = itemRepository.findByItemNo(itemNo);
        log.info("adminService_findItem : " + findItem);
        return findItem;
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
