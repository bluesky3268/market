package korit.market;


import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * DB접속 테스트
 */
public class JDBCTests {
    static {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void conectionTest() {
        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/market?useUnicode=true&characterEncoding=utf8&allowPublicKeyRetrieval=true&useSSL=false", "marketuser", "1234");
            System.out.println("success");
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("fail");
        }
    }
}
