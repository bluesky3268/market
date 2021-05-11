package korit.market.dto;

import korit.market.entity.Item;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemAddDTO {

    private String itemName;

    private Integer itemPrice;

    private Integer itemQuantity;

    private String itemInfo;

    private String itemImg;

    public Item toEntity() {
        return Item.builder()
                .itemName(itemName)
                .itemPrice(itemPrice)
                .itemQuantity(itemQuantity)
                .itemInfo(itemInfo)
                .itemImg(itemImg)
                .build();
    }
}
