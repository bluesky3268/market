package korit.market.Repository;

import korit.market.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface AdminRepository extends JpaRepository<Admin, Long>, QuerydslPredicateExecutor {

    Admin findByAdminId(String adminId);

}
