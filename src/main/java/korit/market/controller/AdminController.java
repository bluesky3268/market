package korit.market.controller;

import korit.market.Service.AdminService;
import korit.market.Service.ItemService;
import korit.market.dto.ItemAddDTO;
import korit.market.entity.Admin;
import korit.market.entity.Item;
import korit.market.entity.Member;
import korit.market.entity.Orders;
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

    @GetMapping("/orderList")
    public String adminOrderList(Model model) {
        List<Orders> orders = adminService.findOrders();
        model.addAttribute("orders", orders);
        return "/admin/orderList";
    }


    @GetMapping("/itemAdd")
    public String itemAdd() {
        return "/admin/itemAdd";
    }

    @PostMapping("/itemAdd")
    public String itemAdd(ItemAddDTO itemDTO){
        log.info("itemAdd_PostMapping) : " + itemDTO);
        adminService.addItem(itemDTO);
        return "redirect:/admin/itemList";
    }

    @GetMapping("/item/{id}/edit")
    public String itemEdit(@PathVariable("id") String id, Model model) {

        Long itemId = Long.parseLong(id);
        Item findItem = adminService.findItem(itemId);
        log.info("itemEdit_findItem : " + findItem);

        model.addAttribute("item", findItem);
        return "admin/itemEdit";
    }
}
