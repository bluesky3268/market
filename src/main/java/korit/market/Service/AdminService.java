package korit.market.Service;

import korit.market.domain.Admin;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class AdminService {


    public static boolean loginCheck(Admin admin) {
        final String id = "admin";
        final String pwd = "admin";
        if(admin.getAdminId().equals(id) && admin.getAdminPwd().equals(pwd)){
            return true;
        }
        return false;
    }


}
