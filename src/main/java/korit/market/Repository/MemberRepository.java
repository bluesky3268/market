package korit.market.Repository;


import korit.market.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EntityManager;


public interface MemberRepository extends JpaRepository<Member, Long> {

    Member findByMemberId(String memberId);

    boolean existsByMemberId(String memberId);

//    boolean existsByEmail(String Email);

}
