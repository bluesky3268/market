package korit.market.Service;

import korit.market.Repository.MemberRepository;
import korit.market.dto.MemberDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberServiceTest {

    @Autowired
    private MemberRepository memberRepository;


    @Test
    public void duplicateMemberIdCheck() {

        String memberId = "hyunbin";
        boolean result = memberRepository.existsByMemberId(memberId);

        Assertions.assertThat(result).isTrue();

    }

}