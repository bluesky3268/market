package korit.market.Service;

import korit.market.Repository.*;
import korit.market.entity.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;
import java.util.UUID;


@Service
@Log4j2
@RequiredArgsConstructor
public class AdminService {

    private final AdminRepository adminRepository;
    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;
    private final OrderRepository orderRepository;
    private final CategoryRepository categoryRepository;

    // 이미지 파일 업로드 디렉토리 지정
    public static String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/img";

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

    public Category findCategory(Long categoryNo) {
        Category category = categoryRepository.findByCategoryId(categoryNo);
        log.info("adminService_findCategory : " + category);
        return category;
    }

    /**
     * 상품 등록
     */

    public void addItem(MultipartFile file, Item item) {
        log.info("beforeSave : " + item);


        StringBuilder fileNames = new StringBuilder();
        String fileName = UUID.randomUUID().toString() + "." + file.getOriginalFilename().substring(file.getOriginalFilename().indexOf(".")+1);
        Path path = Paths.get(uploadDir, fileName);


//        try {
//            Files.write(path, file.getBytes());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        item.setItemImg(fileName);
        itemRepository.save(item);

        log.info("afterSave : " + item);
    }

    /**
     * 상품 삭제
     */
    public void deleteItem(Item item) {
        itemRepository.delete(item);
        log.info("delete_success : " + item);
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
            return true; // 중복 아이디 없음 -> 저장가능
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

    /**
     * 카테고리 삭제
     */
    public void deleteCategory(Category category) {
        categoryRepository.delete(category);
        log.info("delete_category_success : " + category);
    }


}
