package org.scoula.jdbc_ex.common;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtil {
    //tdd 먼저 테스트 나중에 구현

    //crud 할때 jdbc1-2단계 항상 필요
    //1-2단계 전용 응집도 높게 클래스를 하나 만듬
    static Connection con = null;
    static {
        Properties properties = new Properties();
        try {
            properties.load(JDBCUtil.class.getResourceAsStream("/application.properties"));
            String driver = properties.getProperty("driver");
            String url = properties.getProperty("url");
            String id = properties.getProperty("id");
            String password = properties.getProperty("password");
            Class.forName(driver);
            con = DriverManager.getConnection(url, id, password);
        } catch (IOException | SQLException e) {
            System.out.println("예외처리함.");
        } catch (ClassNotFoundException e){
            System.out.println("예외처리함.");
        }
    }
    //메서드를 new로 객체생성하지말고
    //바로 호출해서 사용하고 싶으면
    //메서드 리턴앞에 static을 붙여라
    //아무때나 호출해서 사용 가능

    public static Connection getConnection(){
        //static메서드 안에서 사용하는 필드는 반드시 static이여야 함
        return con;
    }
    public static void close(){
        if(con != null){
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("예외처리함.");
            }
            con = null;
        }
    }
}
