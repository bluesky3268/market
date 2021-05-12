package korit.market.Repository;


import korit.market.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CartRepository extends JpaRepository<Orders, Long>, JpaSpecificationExecutor<Orders> {

}
