package korit.market.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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

    @Column
    private String addr1;     // 주소(우편번호_zipcode)

    @Column
    private String addr2;     // 주소(기본주소)

    @Column
    private String addr3;     // 주소(상세주소_주문자가 작성)

    // buyDate (생성예정)

    // 참조값

    @OneToOne
    private Member memberId;

    @ManyToOne
    private Item item;

    @OneToOne
    private Cart cartStock;     // 주문 수량

    }
