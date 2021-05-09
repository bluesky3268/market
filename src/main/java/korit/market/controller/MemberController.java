package korit.market.controller;

import korit.market.Service.MemberService;
import korit.market.dto.MemberDTO;
import korit.market.entity.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/")
public class MemberController {

    private final MemberService memberService;

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


    /**
     * 회원가입 폼
     */
    @GetMapping("/join")
    public String join() {
        return "join"; }

    /**
     * 회원가입
     */

    @PostMapping("/join")
    public String join(MemberDTO member) {

//        duplicateCheckId(member.getMember_id());
        memberService.saveMember(member);

        log.info(member);

        return "redirect:/";
    }

    /**
     * 아이디 중복 확인
     */
//    @GetMapping("/join/{id}/exist")
//    public ResponseEntity<Boolean> duplicateCheckId(@PathVariable String id) {
//        return ResponseEntity.ok(memberService.duplicateCheckMemberId(id));
//    }

}
