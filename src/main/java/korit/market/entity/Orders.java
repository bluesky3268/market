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

/**
ordersNo bigint not null auto_increment primary key,
cartNo bigint not null,
userId varchar(16) not null,
receiver varchar(30) not null,
itemsNo bigint not null,
itemsName varchar(50) not null,
itemsPrice int not null,
cartStock int not null,
odAddr1 varchar(20) not null,
odAddr2 varchar(50) not null,
odAddr3 varchar(50) not null,
buyDate timestamp not null,
index idx_orders_buyDate(buyDate),
index idx_orders_ordersNo(ordersNo),
foreign key(userId) references user(userId),
foreign key(itemsNo) references items(itemsNo),
foreign key(itemsName) references items(itemsName),
foreign key(itemsPrice) references items(itemsPrice),
foreign key(cartStock) references cart(cartStock)
*/


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderNo;

    private Long cartNo;

    @Column(length = 50, nullable = false)
    private String itemName;

    private Integer itemPrice;

    private Integer cartStock;  // 주문 수량

    @Column
    private String address;     // 주소

    // 참조값

    @ManyToOne
    private Member member;

    @ManyToOne
    private Item item;

    @ManyToOne
    private Cart cart;

    }
