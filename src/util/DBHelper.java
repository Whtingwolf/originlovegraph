package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBHelper {
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/Photos?useUnicode=true&characterEncodeing=UTF";
    private static final String username = "root";
    private static final String  password = "asd6662580";

    private static Connection conn = null;

    static {
        try {
            Class.forName(driver);
        }catch (Exception e){
                e.printStackTrace();
        }
    }
    public static Connection getConnection(){
            if(conn == null){
                try {
                    conn = DriverManager.getConnection(URL, username, password);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            return conn;
    }
    public static void main(String []args){
        Connection connection = DBHelper.getConnection();
        if(connection!=null){
            System.out.println("数据库连接正常");
        }else {
            System.out.println("数据库连接异常");
        }
    }

}
