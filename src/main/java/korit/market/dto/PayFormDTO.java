package korit.market.dto;

import korit.market.entity.Member;
import korit.market.entity.PayForm;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PayFormDTO {

    private Member member;

    private String receiver;

    private String addr1;

    private String addr2;

    private String addr3;

    private String phone;

    private String email;

    private String memo;


    public PayForm toEntity() {
        return PayForm.builder()
                .member(member)
                .receiver(receiver)
                .addr1(addr1)
                .addr2(addr2)
                .addr3(addr3)
                .phone(phone)
                .email(email)
                .memo(memo)
                .build();
    }

}
