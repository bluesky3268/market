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

    private String userName;

    private String phoneNumber;

    @NotBlank(message = "이메일 주소를 입력해 주세요")
    @Email(message="올바른 이메일 주소를 입력해 주세요.")
    private String email;

    private String address;

}
