package korit.market.Service;

import korit.market.Repository.*;
import korit.market.entity.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Log4j2
@RequiredArgsConstructor
public class AdminService {

    private final AdminRepository adminRepository;
    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;
    private final CartRepository orderRepository;
    private final CategoryRepository categoryRepository;

    /**
     * 관리자 추가
     */

    /**
     * 관리자 로그인
     */
    public boolean loginCheck(String paramId, String paramPwd) {

        Admin admin = adminRepository.findByAdminId(paramId);
        if (paramId.equals(admin.getAdminId()) && paramPwd.equals(admin.getAdminPwd())) {
            return true;
        }
        return false;
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        List<Member> members = memberRepository.findAll();
        log.info(members);
        return members;
    }

    /**
     * 전체 상품 조회
     */
    public List<Item> findItems() {
        List<Item> items = itemRepository.findAll();
        log.info("item list : " + items);
        return items;
    }


    /**
     * 전체 주문 조회
     */
    public List<Orders> findOrders() {
        List<Orders> orders = orderRepository.findAll();
        return orders;
    }

    /**
     * 단일 상품 조회
     */
    public Item findItem(Long itemNo) {
        Item findItem = itemRepository.findByItemNo(itemNo);
        log.info("adminService_findItem : " + findItem);
        return findItem;
    }

    /**
     * 상품 등록
     */
    public void addItem(Item item) {
        log.info("beforeSave : " + item);

        itemRepository.save(item);

        log.info("afterSave : " + item);
    }

    /**
     * 카테고리 추가
     */
    public void addCategory(Category category) {
        Category savedCat = categoryRepository.save(category);
        log.info("save category success : " + savedCat);
    }

    public boolean checkDuplicateCatId(Long catId) {
        if(categoryRepository.findByCategoryId(catId) == null)
            return true;
        return false;
    }

    public Category findCategoryByName(String categoryName) {
        return categoryRepository.findByCategoryName(categoryName);
    }

    public List<Category> findCategories() {
        List<Category> categories = categoryRepository.findAll();
        log.info("finded categories : " + categories);
        return categories;
    }



}
