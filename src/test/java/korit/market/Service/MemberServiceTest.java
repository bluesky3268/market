package korit.market.Service;

import korit.market.Repository.MemberRepository;
import korit.market.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class MemberServiceTest {

    MemberRepository memberRepository;
    @Test
    public void join() {
        Member member1 = new Member("market", "market", "market", "01011112222", "aaa@aaa.com", "aaa", "bbb", "ccc");
        memberRepository.save(member1);

        Assertions.assertThat(member1.getId()).isEqualTo("market");
    }


}