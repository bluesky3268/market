package korit.market.dto;

import korit.market.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberLoginDTO {
   
    private String member_id;

    private String pwd;

    public Member toEntity() {
        return Member.builder().memberId(member_id).memberPwd(pwd).build();

    }

}
