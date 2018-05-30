package dao;

import entiy.Photos;
import util.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Photosdao {
    //获得所有的商品信息
    public ArrayList<Photos> getAllpotos(){
        Connection connection =null;
        PreparedStatement stmt = null;
        ResultSet rs =null;
        ArrayList<Photos> list = new ArrayList <Photos>();
        try{
            connection = DBHelper.getConnection();
            String sql = "select *from pictures;"; //sql语句
            stmt = connection.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()){
                Photos picutre = new Photos();
                picutre.setId(rs.getInt("id"));
                picutre.setAuthorname(rs.getString("authorname"));
                picutre.setType(rs.getString("typename"));
                picutre.setPicturepath(rs.getString("picturepath"));
                list.add(picutre);
            }
        }catch (Exception e){
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
    //根据照片编号获得照片资料
    public Photos getPhotoById(int id){
        Connection connection =null;
        PreparedStatement stmt = null;
        ResultSet rs =null;
        ArrayList<Photos> list = new ArrayList <Photos>();
        Photos picture =null;
        try{
            connection = DBHelper.getConnection();
            String sql = "select *from pictures WHERE id ="+id+";"; //sql语句
            stmt = connection.prepareStatement(sql);
            rs = stmt.executeQuery();
            if (rs.next()){
                picture = new Photos();
                picture.setId(rs.getInt("id"));
                picture.setAuthorname(rs.getString("authorname"));
                picture.setType(rs.getString("typename"));
                picture.setPicturepath(rs.getString("picturepath"));
            }

        }catch (Exception e){
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
            return picture;
        }
    }
    public ArrayList<Photos> getPhotosByName(String authorname){
        if("".equals(authorname)){
            return null;
        }
        Connection connection =null;
        PreparedStatement stmt = null;
        ResultSet rs =null;
        ArrayList<Photos> list = new ArrayList <Photos>();
        try{
            connection = DBHelper.getConnection();
            String sql = "select *from pictures WHERE authorname = '"+authorname+"'"; //sql语句
            stmt = connection.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()){
                Photos picutre = new Photos();
                picutre.setId(rs.getInt("id"));
                picutre.setAuthorname(rs.getString("authorname"));
                picutre.setType(rs.getString("typename"));
                picutre.setPicturepath(rs.getString("picturepath"));
                list.add(picutre);
            }
        }catch (Exception e){
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

}
