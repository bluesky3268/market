package korit.market.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemReviewNo;

    private String title;

    private String content;

    private String img;

    private Date reviewRegDate;

    @ManyToOne
    private Member member;

    @ManyToOne
    private Item item;


}
