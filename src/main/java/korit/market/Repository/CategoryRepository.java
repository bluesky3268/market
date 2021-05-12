package korit.market.Repository;

import korit.market.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findByCategoryId(Long catId);

    Category findByCategoryName(String categoryName);

}
