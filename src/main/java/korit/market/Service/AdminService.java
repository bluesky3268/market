package korit.market.Service;

import korit.market.Repository.AdminRepository;
import korit.market.Repository.MemberRepository;
import korit.market.entity.Admin;
import korit.market.entity.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Log4j2
@RequiredArgsConstructor
public class AdminService {

    private final AdminRepository adminRepository;
    private final MemberRepository memberRepository;

    public boolean loginCheck(String paramId, String paramPwd) {

        Admin admin = adminRepository.findByAdminId(paramId);
        if (paramId.equals(admin.getAdminId()) && paramPwd.equals(admin.getAdminPwd())) {
            return true;
        }
        return false;
    }

    // 전체 회원 조회
    public List<Member> findMembers() {
        List<Member> members = memberRepository.findAll();
        log.info(members);
        return members;
    }


}
