package korit.market.controller;

import korit.market.Service.AdminService;
import korit.market.domain.Admin;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {

    @GetMapping("/adminLogin")
    public String admin_LoginForm() {
        return "/admin/adminLogin";
    }

    @PostMapping("/adminLogin")
    public String admin_Login(@RequestParam String adminId, @RequestParam String adminPwd) {
        Admin admin = new Admin(adminId, adminPwd);
        if(AdminService.loginCheck(admin)==true) {
            return "/admin/itemAdd";
        }
        return "redirect:/adminLogin";
    }
}
