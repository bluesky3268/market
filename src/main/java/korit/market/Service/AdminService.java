package korit.market.Service;

import korit.market.Repository.AdminRepository;
import korit.market.entity.Admin;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class AdminService {
    private final AdminRepository adminRepository;

    public boolean loginCheck(String paramId, String paramPwd) {

        Admin admin = adminRepository.findByAdminId(paramId);
        if (paramId.equals(admin.getAdminId()) && paramPwd.equals(admin.getAdminPwd())) {
            return true;
        }
        return false;
    }


}
