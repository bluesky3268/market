package korit.market.Repository;

import korit.market.entity.Admin;
import korit.market.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.EntityManager;
import java.util.List;

public interface AdminRepository extends JpaRepository<Admin, Long>, QuerydslPredicateExecutor {

    Admin findByAdminId(String adminId);

}
