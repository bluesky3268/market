package korit.market.controller;

import korit.market.Service.ItemService;
import korit.market.Service.MemberService;
import korit.market.dto.MemberDTO;
import korit.market.dto.MemberLoginDTO;
import korit.market.entity.Item;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Log4j2
public class MainController {

    private final MemberService memberService;
    private final ItemService itemService;

    @RequestMapping("/")
    public String mainPage(Model model) {
        List<Item> brandNews = itemService.brandNew();
        model.addAttribute("brandNew", brandNews);

        List<Item> tents = itemService.findItemsByCatNo(100L);
        model.addAttribute("tents", tents);

        List<Item> tarps = itemService.findItemsByCatNo(200L);
        model.addAttribute("tarps", tarps);

        List<Item> tables = itemService.findItemsByCatNo(300L);
        model.addAttribute("tables", tables);

        List<Item> chairs = itemService.findItemsByCatNo(400L);
        model.addAttribute("chairs", chairs);




        return "index";
    }

    /**
     * 로그인 폼
     */

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * 로그인 처리
     */
    @PostMapping("/login")
    public String login(MemberLoginDTO member, HttpSession session) {
        if (memberService.login(member) == true) {
            String login_id = member.getMember_id();

            session.setAttribute("id", login_id);

            return "redirect:/";
        }
        return "redirect:/login";
    }


    /**
     * 로그아웃
     */
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }



    /**
     * 회원가입 폼
     */

    @GetMapping("/join")
    public String join() {
        return "join";
    }

    /**
     * 회원가입
     */

    @PostMapping("/join")
    public String join(MemberDTO member, RedirectAttributes redirectAttributes, Model model) {

        log.info(member);
        model.addAttribute("member", member);

        // 아이디 중복확인(true == 중복되는 아이디 존재함)
        if (memberService.duplicateCheckMemberId(member.getMember_id())) {
            log.info("아이디 중복");
            redirectAttributes.addAttribute("status", true);
            return "redirect:/join";
        }else{
            if(!member.getPwd().equals(member.getPwd_confirm())){
                log.info("입력한 비밀번호가 같지 않음");
                redirectAttributes.addAttribute("pwdStatus", true);
                return "redirect:/join";
            }

        }
        // false일 경우 데이터 베이스에 저장
        memberService.saveMember(member);
        log.info("회원가입 성공!");
        return "redirect:/login";
    }



}
