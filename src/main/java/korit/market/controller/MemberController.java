package korit.market.controller;

import korit.market.Service.MemberService;
import korit.market.dto.MemberDTO;
import korit.market.dto.MemberLoginDTO;
import korit.market.entity.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@Log4j2
public class MemberController {

    private final MemberService memberService;

    @RequestMapping("/")
    public String basic() {
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
    public String join(MemberDTO member, RedirectAttributes redirectAttributes) {

        log.info(member);

        // 아이디 중복확인(true == 중복되는 아이디 존재함)
        if (memberService.duplicateCheckMemberId(member.getMember_id())) {
            log.info("아이디 중복");
            redirectAttributes.addAttribute("status", true);
            return "redirect:/join";
        }
        // false일 경우 데이터 베이스에 저장
        memberService.saveMember(member);
        log.info("회원가입 성공!");
        return "redirect:/login";
    }

    /**
     * 아이디 중복 확인
     */
//    @GetMapping("/join/{id}/exist")
//    public ResponseEntity<Boolean> duplicateCheckId(@PathVariable String id) {
//        return ResponseEntity.ok(memberService.duplicateCheckMemberId(id));
//    }

}
