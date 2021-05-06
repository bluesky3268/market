package korit.market.Repository;

import korit.market.entity.Admin;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.Optional;


@SpringBootTest
class AdminRepositoryTest {

    @Autowired
    private AdminRepository adminRepository;

    // admin 데이터 추가 test
    @Test
    public void insertAdmin() {
        Admin admin = Admin.builder()
                .adminId("admin")
                .adminPwd("1234")
                .build();
        adminRepository.save(admin);
    }

    @Test
    public void findById() {
        Optional<Admin> result = adminRepository.findById(1L);
        if (result.isPresent()) {
            Admin admin = result.get();
            System.out.println(admin);
        }
    }

    @Test
    public void loginCheck() {


    }



}