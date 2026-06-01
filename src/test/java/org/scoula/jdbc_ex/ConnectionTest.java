package org.scoula.jdbc_ex;

import org.junit.jupiter.api.Test;
import org.scoula.jdbc_ex.common.JDBCUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class ConnectionTest {


    // 메서드 단위로 기능을 테스트 해볼수 있음(junit라이브러리 사용함
    @Test
    public void testConnection() throws ClassNotFoundException, SQLException {
        //JDBC 단계별 테스트
        //1. jdbc 드라이버 세팅, jdbc커넥터
        Class.forName("com.mysql.cj.jdbc.Driver"); //외부파일 연결
        System.out.println("1. jdbc 드라이버 세팅 성공");

        //2. db 연결
        //db연결시 필요한 3가지 : url(ip + port + db명) + username + pw
        String url = "jdbc:mysql://127.0.0.1:3306/jdbc_ex";
        String id = "scoula";
        String password = "1234";
        Connection con = DriverManager.getConnection(url, id, password);
        System.out.println("2. db 연결 성공 >> " + con);

        //자원해제 해줘야함
        con.close();
    }
    @Test
    public void testConnection2(){
        Connection con = JDBCUtil.getConnection();
        JDBCUtil.close();
    }
}