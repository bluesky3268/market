package korit.market.controller;

import korit.market.Service.AdminService;
import korit.market.Service.ItemService;
import korit.market.dto.ItemAddDTO;
import korit.market.entity.Admin;
import korit.market.entity.Category;
import korit.market.entity.Item;
import korit.market.entity.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;


@Controller
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    /**
     * 관리자 메인페이지
     */

    @GetMapping("/adminMain")
    public String adminMainPage() {
        return "/admin/adminMain";
    }


    /**
     * 로그인
     */

    @GetMapping("/Login")
    public String admin_LoginForm(HttpSession session) {
        return "/admin/adminLogin";
    }

    @PostMapping("/Login")
    public String admin_Login(@RequestParam Map<String, String> params, HttpSession session) {

        String paramId = params.get("adminId");
        String paramPwd = params.get("adminPwd");
        Admin paramAdmin = new Admin(paramId, paramPwd);

        if (adminService.loginCheck(paramId, paramPwd) == true) {
            session.setAttribute("admin", paramAdmin);
            return "redirect:/admin/adminMain";
        } else {
            return "/admin/loginFail";
        }
    }

    /**
     * 로그아웃
     */

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "/admin/adminLogin";
    }


    /**
     * 회원 목록
     */
    @GetMapping("/memberList")
    public String adminMemberList(Model model) {
        List<Member> members = adminService.findMembers();
        log.info(members);
        model.addAttribute("member", members);
        return "/admin/adminMemberList";
    }
    /**
     * 주문 목록
     */


    /**
     * 상품 목록
     */
    @GetMapping("/itemList")
    public String adminItemList(Model model) {
        List<Item> items = adminService.findItems();
        log.info("itemList : " + items);
        model.addAttribute("items", items);
        return "/admin/itemList";
    }

    /**
     * 상품 등록
     */
    @GetMapping("/itemAdd")
    public String itemAdd(Model model) {
        List<Category> categories = adminService.findCategories();
        log.info("categories : " + categories);
        model.addAttribute("categories", categories);
        return "/admin/itemAdd";
    }

    @PostMapping("/itemAdd")
    public String itemAdd(@RequestParam("categoryName") String categoryName,
                          @RequestParam("file") MultipartFile file, Item item) {

        log.info("file : " + file.getOriginalFilename());

        item.setCategory(adminService.findCategoryByName(categoryName));
        adminService.addItem(file, item);

        return "redirect:/admin/itemList";
    }

    /**
     * 상품 수정
     */
    @GetMapping("/item/{id}/edit")
    public String itemEdit(@PathVariable("id") Long id, Model model) {

        Item findItem = adminService.findItem(id);

        List<Category> categories = adminService.findCategories();

        model.addAttribute("item", findItem);
        model.addAttribute("categories", categories);
        return "admin/itemEdit";
    }

    @PostMapping("/item/{id}/edit")
    public String updateItem(@PathVariable("id") String id, @RequestParam("categoryName") String categoryName,
                             @RequestParam("file") MultipartFile file, @ModelAttribute Item item) {
        Long itemNo = Long.parseLong(id);

        item.setItemNo(itemNo);
        item.setCategory(adminService.findCategoryByName(categoryName));

        adminService.addItem(file, item);

        return "redirect:/admin/itemList";
    }

    /**
     * 상품 삭제
     */

    @GetMapping("/item/{id}/delete")
    public String delete(@PathVariable("id") String id) {

        Long itemNo = Long.parseLong(id);
        log.info("itemNo : " + itemNo);

        Item item = adminService.findItem(itemNo);

        log.info("delete_item : " + item);
        adminService.deleteItem(item);

        return "redirect:/admin/itemList";
    }


    /**
     * 카테고리 등록
     */
    @GetMapping("/category/add")
    public String addCategory(Model model) {

        List<Category> categories = adminService.findCategories();
        model.addAttribute("categories", categories);

        return "/admin/categoryAdd";
    }

    @PostMapping("/category/add")
    public String addCategory(Category cat, RedirectAttributes redirectAttributes) {
        Long catId = cat.getCategoryId();

        boolean checkCatId = adminService.checkDuplicateCatId(catId); // true면 저장 가능
        log.info("check duplicate catId : " + checkCatId);
        if (checkCatId) {
            adminService.addCategory(cat);
            redirectAttributes.addAttribute("success", true);
            return "redirect:/admin/category/add";
        }else{
            redirectAttributes.addAttribute("fail", true);
            return "redirect:/admin/category/add";
        }
    }

    /**
     * 카테고리 삭제
     */
    @GetMapping("/{catId}/delete")
    public String deleteCategory(@PathVariable("catId") Long categoryId) {

        Category category = adminService.findCategory(categoryId);

        adminService.deleteCategory(category);

        return "redirect:/admin/category/add";
    }

    @GetMapping("/orderList")
    public String orderList() {
        return "/admin/orderList";
    }



}
