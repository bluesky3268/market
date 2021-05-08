package korit.market.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MemberDTO {


    private String member_id;

    private String pwd;

    private String pwd_confirm;

    private String name;

    private String mobile;

    private String email;

    private String address;

    private String detailAddress;

    private String extraAddress;

}
