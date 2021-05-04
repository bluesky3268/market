package korit.market.domain;

import lombok.Getter;

@Getter
public class Admin {
    private String adminId;
    private String adminPwd;

    public Admin(String adminId, String adminPwd) {
        this.adminId = adminId;
        this.adminPwd = adminPwd;
    }
}
