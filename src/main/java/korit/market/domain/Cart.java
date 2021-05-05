package korit.market.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Cart {

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
            ) ENGINE = innoDB default charset=utf8;
    */

    private Long cartNo;
    private String userId;
    private Long itemsNo;
    private String itemsName;
    private Integer itemPrice;
    private Integer cartStock;

    public Cart(Long cartNo, String userId, Long itemsNo, String itemsName, Integer itemPrice, Integer cartStock) {
        this.cartNo = cartNo;
        this.userId = userId;
        this.itemsNo = itemsNo;
        this.itemPrice = itemPrice;
        this.cartStock = cartStock;
    }

}
