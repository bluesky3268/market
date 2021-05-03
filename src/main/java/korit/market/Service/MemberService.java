package korit.market.Service;

import korit.market.Repository.MemberRepository;
import korit.market.domain.Member;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 로그인
     */
    public static boolean loginCheck(ModelAndView mv, HttpSession session) {
        return true;
    }

    /**
     * 로그아웃
     */
    public void logout(HttpSession session) {
        session.invalidate();
    }
    /**
     * 회원가입
     */
    public String join(Member member) {
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        Member findMember = memberRepository.findById(member.getId());
        if (findMember!=null) {
            throw new IllegalArgumentException("이미 존재하는 회원입니다.");
        }
    }

    /**
     * 회원정보 수정
     */

}
