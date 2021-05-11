package korit.market.entity;

import lombok.*;

import javax.persistence.*;

/**
 cartNo bigint not null auto_increment primary key,
 userId varchar(16) not null,
 itemsNo bigint not null,
 itemsName varchar(50) not null,
 itemsPrice int not null,
 cartStock int not null,
 index idx_cart_cartStock(cartStock),
 foreign key(userId) references user(userId),
 foreign key(itemsNo) references items(itemsNo),
 foreign key(itemsName) references items(itemsName),
 foreign key(itemsPrice) references items(itemsPrice)
 */

@Entity
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartNo;

    private Long itemNo;

    @Column(length = 50, nullable = false)
    private String itemName;

    private Integer itemPrice;

    private Integer cartStock;  // 주문 수량

    // 참조값

    @ManyToOne
    private Orders order;

    @ManyToOne
    private Item item;

}
