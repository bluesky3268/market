package korit.market.controller;

import korit.market.Service.AdminService;
import korit.market.Service.ItemService;
import korit.market.dto.ItemAddDTO;
import korit.market.entity.Admin;
import korit.market.entity.Item;
import korit.market.entity.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;


@Controller
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

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

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "/admin/adminLogin";
    }

    @GetMapping("/adminMain")
    public String adminMainPage() {
        return "/admin/adminMain";
    }


    @GetMapping("/itemList")
    public String adminItemList(Model model) {
        List<Item> items = adminService.findItems();
        model.addAttribute("items", items);
        return "/admin/itemList";
    }

    @GetMapping("/memberList")
    public String adminMemberList(Model model) {
        List<Member> members = adminService.findMembers();
//        log.info(members);
        model.addAttribute("member", members);
        return "/admin/adminMemberList";
    }


    @GetMapping("/itemAdd")
    public String itemAdd() {
        return "/admin/itemAdd";
    }

    @PostMapping("/itemAdd")
    public String itemAdd(Item item){
        log.info("itemAdd_PostMapping : " + item);
        adminService.addItem(item);
        return "redirect:/admin/itemList";
    }

    @GetMapping("/item/{id}/edit")
    public String itemEdit(@PathVariable("id") Long id, Model model) {

        Item findItem = adminService.findItem(id);

//        ItemAddDTO form = new ItemAddDTO();
//        form.setItemNo(findItem.getItemNo());
//        form.setItemName(findItem.getItemName());
//        form.setItemPrice(findItem.getItemPrice());
//        form.setItemQuantity(findItem.getItemQuantity());
//        form.setItemInfo(findItem.getItemInfo());
//        form.setItemImg(findItem.getItemImg());

        model.addAttribute("item", findItem);
        return "admin/itemEdit";
    }

    @PostMapping("/item/{id}/edit")
    public String updateItem(@PathVariable("id") String id, @ModelAttribute Item item) {
        Long itemId = Long.parseLong(id);
        log.info("update item id = " + itemId);

        item.setItemNo(itemId);
        log.info("before update : " + item);

        adminService.addItem(item);

        return "redirect:/admin/itemList";
    }
}
