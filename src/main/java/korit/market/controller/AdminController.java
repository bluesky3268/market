package korit.market.controller;

import korit.market.Service.AdminService;
import korit.market.entity.Admin;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;


@Controller
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;


    @GetMapping( "/Login")
    public String admin_LoginForm() {

        return "/admin/adminLogin";
    }

    @PostMapping("/Login")
    public String admin_Login(@RequestParam Map<String, String> params, HttpSession session)  {
        String paramId = params.get("adminId");
        String paramPwd = params.get("adminPwd");

        Admin paramAdmin = new Admin(1L, paramId, paramPwd);

        if(adminService.loginCheck(paramId, paramPwd) == true) {
            session.setAttribute("admin", paramAdmin);
            return "/admin/itemAdd";
        }else {
            return "/admin/loginFail";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "/admin/adminLogin";
    }

}
