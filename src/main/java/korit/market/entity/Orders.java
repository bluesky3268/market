package korit.market.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Builder
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderNo;

    private String address;

    // 참조값

    @ManyToOne
    private Member member;

    @ManyToOne
    private Item item;

    }
