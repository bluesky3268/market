package korit.market.domain;

import java.util.Date;

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

    public Long getItemNo() {
        return itemNo;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(Integer categoryCode) {
        this.categoryCode = categoryCode;
    }

    public Integer getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Integer itemPrice) {
        this.itemPrice = itemPrice;
    }

    public Integer getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(Integer itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public String getItemInfo() {
        return itemInfo;
    }

    public void setItemInfo(String itemInfo) {
        this.itemInfo = itemInfo;
    }

    public String getItemImg() {
        return itemImg;
    }

    public void setItemImg(String itemImg) {
        this.itemImg = itemImg;
    }

    public Date getItemDate() {
        return itemDate;
    }

    public void setItemDate(Date itemDate) {
        this.itemDate = itemDate;
    }
}
