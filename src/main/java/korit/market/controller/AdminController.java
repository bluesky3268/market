package korit.market.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/admin")
public class AdminController {


    @GetMapping("/Login")
    public String admin_LoginForm() {
        return "/admin/adminLogin";
    }

    @PostMapping("/Login")
    public String admin_Login(@RequestParam String adminId, @RequestParam String adminPwd) {
//
//        List savedAdmin = adminService.findAll();
//
//        savedAdmin.contains(adminId);

//        adminService.

        return "redirect:/admin/itemAdd";
    }
}
