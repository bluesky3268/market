package korit.market.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Builder
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    @Id
    private Long category_id;

}
