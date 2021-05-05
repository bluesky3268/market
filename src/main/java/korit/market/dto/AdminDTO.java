package korit.market.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AdminDTO {

    private Long adminNo;
    private String adminId;
    private String adminPwd;


}
