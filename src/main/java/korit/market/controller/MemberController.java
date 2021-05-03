package korit.market.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

//    @PostMapping("/login")
//    public String login(@RequestParam String userId, @RequestParam String pwd) {
//
//        return "index";
//    }

    @GetMapping("/join")
    public String join() {
        return "join";
    }

}
