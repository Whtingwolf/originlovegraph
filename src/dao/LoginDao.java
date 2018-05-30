package dao;

import entiy.User;
import util.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {
    private static LoginDao instance = null;


    private LoginDao ( ) {
    }

    public static LoginDao getInstance ( ) {
        if (instance ==null){
            instance = new LoginDao();
            return instance;
        }else {
            return instance;
        }
    }


    public boolean userlogin (User user) {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            conn = DBHelper.getConnection();
            String sql = "select * from users";
            statement = conn.prepareStatement(sql);
            rs = statement.executeQuery();
            System.out.println("数据库连接创建");
            while (rs.next()) {
                if (rs.getString("username").equals(user.getUsername())) {
                    if (rs.getString("password").equals(user.getPassword())) {
                        System.out.print("密码匹配成功");
                        return true;
                    } else {
                        System.out.print("密码匹配失败");
                        return false;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("登录失败");
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

}
