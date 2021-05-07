package korit.market.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MemberDTO {

    private String id;

    private String pwd;

    private String checkedPwd;

    private String userName;

    private String phoneNumber;

    private String email;

    private String address;

}
