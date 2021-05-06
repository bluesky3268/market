package korit.market.controller;

import korit.market.entity.Member;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class MemberController {


    public String basic() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute Member member, HttpSession session) {

        return "redirect:/";
    }

    @GetMapping("/join")
    public String join() {

        return "join";
    }

    @PostMapping("/join")
    public String join(@ModelAttribute Member member) {
        return "redirect:/";
    }

}
