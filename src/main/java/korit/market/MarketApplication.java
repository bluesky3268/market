package korit.market;

import korit.market.Service.AdminService;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.File;

@SpringBootApplication
public class MarketApplication {

	public static void main(String[] args) {

		//실행 전 이미지 파일을 저장할 폴더 만들기
		new File(AdminService.uploadDir).mkdir();

		SpringApplication.run(MarketApplication.class, args);
	}



}
