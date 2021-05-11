package korit.market.Service;

import korit.market.Repository.AdminRepository;
import korit.market.Repository.ItemRepository;
import korit.market.Repository.MemberRepository;
import korit.market.Repository.OrderRepository;
import korit.market.dto.ItemAddDTO;
import korit.market.dto.MemberDTO;
import korit.market.entity.Admin;
import korit.market.entity.Item;
import korit.market.entity.Member;
import korit.market.entity.Orders;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@Log4j2
@RequiredArgsConstructor
public class AdminService {

    private final AdminRepository adminRepository;
    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;
    private final OrderRepository orderRepository;

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
        log.info(items);
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
     * 상품 등록
     */
    public void addItem(ItemAddDTO item) {
        log.info("adminService_itemDTO : " + item);
        itemRepository.save(item.toEntity());
    }

    /**
     * 단일 상품 조회
     */
    public Item findItem(Long itemNo) {
        Item findItem = itemRepository.findByItemNo(itemNo);
        log.info("adminService_findItem : " + findItem);
        return findItem;
    }


}
