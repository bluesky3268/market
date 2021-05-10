package korit.market.dto;

import korit.market.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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


    public Member toEntity() {
        return Member.builder()
                .memberId(member_id)
                .memberPwd(pwd)
                .memberName(name)
                .phoneNumber(mobile)
                .email(email)
                .address1(address)
                .address2(detailAddress)
                .address3(extraAddress)
                .build();
    }

}
