package korit.market.entity;

import lombok.*;

import javax.persistence.*;

/**
 * userId      varchar(16)    not null primary key,
 * userPwd    varchar(16)   not null,
 * userName    varchar(30)    not null,
 * userPhon    varchar(20)    not null,
 * userEmail  varchar(50)    not null,
 * userAddr1   varchar(20)    null,
 * userAddr2   varchar(50)    null,
 * userAddr3   varchar(50)    null,
 */

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberNo;

    private String memberId;

    private String memberPwd;

    private String memberName;

    private String phoneNumber;

    private String email;

    private String address1;

    private String address2;

    private String address3;


}

