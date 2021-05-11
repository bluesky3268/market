package korit.market.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

/**
 * itemsNo bigint not null auto_increment primary key,
 * itemsName varchar(50) not null,
 * cateCode varchar(30) not null,
 * itemsPrice int not null,
 * itemsStock int null,
 * itemsInfo varchar(500) not null,
 * itemsImg varchar(200) not null,
 * itemsDate timestamp default now()
 */

@Entity
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemNo;

    @Column(length = 50, nullable = false)
    private String itemName;

    private Integer itemPrice;

    private Integer itemQuantity;   // 재고 수량

    @Column(length = 500, nullable = false)
    private String itemInfo;

    @Column(length = 500, nullable = false)
    private String itemImg;

    private Date itemRegDate;

    @ManyToOne
    private Orders order;

    @ManyToOne
    private Category category;


}
