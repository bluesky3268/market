package korit.market.entity;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="payForm")

public class PayForm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="payForm_Id")
    private Long Id;

    //member를 참조하는 외래키
    private Long memberId;


    @Column
    private String receiver;

    @Column
    private String addr1; //zipcode

    @Column
    private String addr2; //기본 주소

    @Column
    private String addr3; // 상세주소

    @Column
    private String phone;

    @Column
    private String email;

    @Column
    private String memo;


}