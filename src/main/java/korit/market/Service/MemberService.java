package korit.market.Service;

import korit.market.Repository.MemberRepository;
import korit.market.dto.MemberDTO;
import korit.market.entity.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Service
@Log4j2
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    /**
     * 로그인
     */



    /**
     * 로그아웃
     */




    /**
     * 회원가입
     */

    public Member saveMember(MemberDTO memberDTO) {

        Member member = Member.builder()
                .memberId(memberDTO.getMember_id())
                .memberPwd(memberDTO.getPwd())
                .memberName(memberDTO.getName())
                .phoneNumber(memberDTO.getMobile())
                .email(memberDTO.getEmail())
                .address1(memberDTO.getAddress())
                .address2(memberDTO.getDetailAddress())
                .address3(memberDTO.getExtraAddress())
                .build();

        memberRepository.save(member);

        return member;

    }

    /**
     * 회원 아이디 중복확인
     */
    public boolean duplicateCheckMemberId(String memberId) {
        return memberRepository.existsByMemberId(memberId);
    }



    /**
     * 회원정보 수정
     */
    public Member updateMember(String memberId) {
        Member findMember = memberRepository.findByMemberId(memberId);
        return findMember;
    }

}
