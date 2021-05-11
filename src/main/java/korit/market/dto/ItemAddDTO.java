package korit.market.dto;

import korit.market.entity.Item;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemAddDTO {

    private String itemName;

    private int itemPrice;

    private int itemQuantity;

    private String itemInfo;

    private String itemImg;

    public Item toEntity() {
        return Item.builder()
                .itemName(itemName)
                .itemPrice(itemPrice)
                .itemQuantity(itemQuantity)
                .itemInfo(itemInfo)
                .itemImg(itemImg)
                .itemRegDate(new Timestamp(System.currentTimeMillis()))
                .build();
    }

}
