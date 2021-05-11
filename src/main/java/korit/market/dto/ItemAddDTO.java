package korit.market.dto;

import korit.market.entity.Item;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemAddDTO {

    private Long itemNo;

    private String itemName;

    private int itemPrice;

    private int itemQuantity;

    private String itemInfo;

    private String itemImg;

    private String itemRegDate =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis());



}
