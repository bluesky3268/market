package korit.market.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MemberDTO {

    private String id;
    private String pwd;

    private String userName;

    private String phoneNumber;

    private String email;

    private String address;

}
