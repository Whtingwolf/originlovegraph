package dao;
import entiy.Deal;
import util.DBHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class DealDisplay {
    public ArrayList<Deal> getAllDeals(){
        Connection connection =null;
        PreparedStatement stmt = null;
        ResultSet rs =null;
        ArrayList<Deal> list = new ArrayList <Deal>();
        try{
            connection = DBHelper.getConnection();
            String sql = "select * from deals;"; //sql语句
            stmt = connection.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()){
                Deal deal = new Deal();
                deal.setId(rs.getInt("id"));
                deal.setOriginator(rs.getString("originator"));
                if(rs.getString("accpter")!=null) {
                    deal.setAccpter(rs.getString("accpter"));
                }
                deal.setTypename(rs.getString("typename"));
                int i=0;
                if(rs.getInt("picture1")!=0){
                    i++;
                }
                if(rs.getInt("picture2")!=0){
                    i++;
                }
                if(rs.getInt("picture3")!=0){
                    i++;
                }
                deal.init(i);
                for(int j=0;j<deal.getPicutres().length;j++){
                    deal.getPicutres()[j] = rs.getInt("picture"+(j+1));
                }
                deal.setPrice(rs.getInt("price"));
                deal.setDescription(rs.getString("description"));
                list.add(deal);
            }
        }catch (Exception e){
            System.out.println("添加表的时候出错");
            e.printStackTrace();
        }finally {
            //释放结果集
            try {
                if (rs != null) {
                    rs.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            //释放状态集
            try {
                if(stmt!=null) {
                    stmt.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            return list;
        }
    }
    public boolean finishDeals(String accpter,int id){
        Connection connection =null;
        PreparedStatement stmt = null;
        ResultSet rs =null;
        ArrayList<Deal> list = new ArrayList <Deal>();
        try{
            connection = DBHelper.getConnection();
            String sql = "select * from deals WHERE id ="+id+";"; //sql语句
            stmt = connection.prepareStatement(sql);
            rs = stmt.executeQuery();
            if(rs.next()){
                if("false".equals(rs.getString("isFinish"))) {
                    sql = "UPDATE deals set accpter = '" + accpter + "',isFinish = 'true' WHERE id = " + id + ";";
                    stmt = connection.prepareStatement(sql);
                    stmt.executeUpdate();
                    return true;
                }else {
                    return false;
                }
            }else {
                return  false;
            }
        }catch (Exception e){
            System.out.println("添加表的时候出错");
            e.printStackTrace();
        }finally {
            //释放结果集
            try {
                if (rs != null) {
                    rs.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            //释放状态集
            try {
                if(stmt!=null) {
                    stmt.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return false;
    }
    public ArrayList<Deal> getDealsByUser(String username){
        Connection connection =null;
        PreparedStatement stmt = null;
        ResultSet rs =null;
        ArrayList<Deal> list = new ArrayList <Deal>();
        try{
            connection = DBHelper.getConnection();
            String sql = "select * from deals WHERE originator='"+username+"'OR  accpter = '"+username+"';"; //sql语句
            stmt = connection.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()){
                Deal deal = new Deal();
                deal.setId(rs.getInt("id"));
                deal.setOriginator(rs.getString("originator"));
                if(rs.getString("accpter")!=null) {
                    deal.setAccpter(rs.getString("accpter"));
                }
                deal.setTypename(rs.getString("typename"));
                int i=0;
                if(rs.getInt("picture1")!=0){
                    i++;
                }
                if(rs.getInt("picture2")!=0){
                    i++;
                }
                if(rs.getInt("picture3")!=0){
                    i++;
                }
                deal.init(i);
                for(int j=0;j<deal.getPicutres().length;j++){
                    deal.getPicutres()[j] = rs.getInt("picture"+(j+1));
                }
                deal.setPrice(rs.getInt("price"));
                deal.setDescription(rs.getString("description"));
                list.add(deal);
            }
        }catch (Exception e){
            System.out.println("添加表的时候出错");
            e.printStackTrace();
        }finally {
            //释放结果集
            try {
                if (rs != null) {
                    rs.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            //释放状态集
            try {
                if(stmt!=null) {
                    stmt.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            return list;
        }
    }

    public ArrayList<Deal> getDealsNotFinished(){
        Connection connection =null;
        PreparedStatement stmt = null;
        ResultSet rs =null;
        ArrayList<Deal> list = new ArrayList <Deal>();
        try{
            connection = DBHelper.getConnection();
            String sql = "select * from deals;"; //sql语句
            stmt = connection.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()){
                if("false".equals(rs.getString("isFinish"))) {
                    Deal deal = new Deal();
                    deal.setId(rs.getInt("id"));
                    deal.setOriginator(rs.getString("originator"));
                    if (rs.getString("accpter") != null) {
                        deal.setAccpter(rs.getString("accpter"));
                    }
                    deal.setTypename(rs.getString("typename"));
                    int i = 0;
                    if (rs.getInt("picture1") != 0) {
                        i++;
                    }
                    if (rs.getInt("picture2") != 0) {
                        i++;
                    }
                    if (rs.getInt("picture3") != 0) {
                        i++;
                    }
                    deal.init(i);
                    for (int j = 0; j < deal.getPicutres().length; j++) {
                        deal.getPicutres()[j] = rs.getInt("picture" + (j + 1));
                    }
                    deal.setPrice(rs.getInt("price"));
                    deal.setDescription(rs.getString("description"));
                    list.add(deal);
                }
            }
        }catch (Exception e){
            System.out.println("添加表的时候出错");
            e.printStackTrace();
        }finally {
            //释放结果集
            try {
                if (rs != null) {
                    rs.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            //释放状态集
            try {
                if(stmt!=null) {
                    stmt.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            return list;
        }
    }
    public boolean createDeal(Deal deal) {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList <Deal> list = new ArrayList <Deal>();
        try {
            connection = DBHelper.getConnection();
            String sql_q = "insert INTO deals (originator,typename,price,description";
            String sql_h = "VALUES ('"+deal.getOriginator()+"','"+deal.getTypename()+"',"+deal.getPrice()+",'"+deal.getDescription()+"'";
            for (int i = 0; i < deal.getPicutres().length; i++) {
                sql_q = sql_q + "," + "picture" + (i + 1);
                sql_h = sql_h + "," + deal.getPicutres()[i]; //sql语句
            }
            sql_q = sql_q + ")";
            sql_h = sql_h + ");";
            String sql = sql_q + sql_h;
            stmt = connection.prepareStatement(sql);
            stmt.executeUpdate();
            return  true;
        } catch (Exception e) {
            System.out.println("添加表的时候出错");
            e.printStackTrace();
        } finally {
            //释放结果集
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            //释放状态集
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

}
