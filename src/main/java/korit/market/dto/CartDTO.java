package korit.market.dto;

import korit.market.entity.Cart;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartDTO {

    private Long cartNo;

    private Long itemNo;

    private Integer cartStock;

    private String itemName;

    private  Integer itemPrice;

    public Cart toEntity() {
        return Cart.builder()
                .cartNo(cartNo)
                .itemNo(itemNo)
                .cartStock(cartStock)
                .itemName(itemName)
                .itemPrice(itemPrice)
                .build();
    }

}
