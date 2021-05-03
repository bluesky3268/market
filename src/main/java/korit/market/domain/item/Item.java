package korit.market.domain.item;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class Item {

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

    private Long itemNo;
    private String itemName;
    private Integer categoryCode;
    private Integer itemPrice;
    private Integer itemQuantity;
    private String itemInfo;
    private String itemImg;
    private Date itemDate;

    public Item(String itemName, Integer categoryCode, Integer itemPrice, Integer itemQuantity, String itemInfo, String itemImg, Date itemDate) {
        this.itemName = itemName;
        this.categoryCode = categoryCode;
        this.itemPrice = itemPrice;
        this.itemQuantity = itemQuantity;
        this.itemInfo = itemInfo;
        this.itemImg = itemImg;
        this.itemDate = itemDate;
    }

}
