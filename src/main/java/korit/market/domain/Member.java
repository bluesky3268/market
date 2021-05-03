package korit.market.domain;

import lombok.Getter;

@Getter
public class Member {

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
    private String id;
    private String pwd;
    private String userName;
    private String phoneNumber;
    private String email;
    private String address1;
    private String address2;
    private String address3;

    public Member(String id, String pwd, String userName, String phoneNumber, String email, String address1, String address2, String address3) {
        this.id = id;
        this.pwd = pwd;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address1 = address1;
        this.address2 = address2;
        this.address3 = address3;
    }
}

