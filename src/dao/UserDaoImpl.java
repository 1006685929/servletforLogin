package dao;

import DButils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao{
    @Override
    public User login(String username, String password) {
        Connection conn = ConnectionUtil.getConnect();
        String sql = "select id,username,password from usertable where username=? and password=?";
        try {
            PreparedStatement pds = conn.prepareStatement(sql);
            pds.setString(1,username);
            pds.setString(2,password);

            ResultSet rs = pds.executeQuery();
            if (rs.next()){
                int id = rs.getInt(1);
                User u = new User();
                u.setId(id);
                u.setUsername(username);
                u.setPassword(password);
                return u;
            }else {
                System.out.println("登录失败");
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionUtil.close(conn);
        }
        return null;
    }

    @Override
    public boolean addUser(User user) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "insert into usertable(username,password)"
                +"values(?,?)";

        try {
            connection = ConnectionUtil.getConnect();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.execute("set Names utf8");
            preparedStatement.setString(1,user.getUsername());
            preparedStatement.setString(2,user.getPassword());
            preparedStatement.executeUpdate();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }finally {
            if (preparedStatement!=null){
                try {
                    preparedStatement.close();
                    preparedStatement=null;
                }catch (Exception e2){
                    e2.printStackTrace();
                }
            }if (connection!=null){
                try {
                    connection.close();
                    connection=null;
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }

    }

    @Override
    public boolean isExist(String username) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select * from usertable where username = ?";

        try {
            conn = ConnectionUtil.getConnect();
            stmt = conn.prepareStatement(sql);
            stmt.execute("set names utf8");
            stmt.setString(1,username);
            rs = stmt.executeQuery();

            if (rs.next()){
                System.out.println("此用户已存在");
                return true;
            }else {
                System.out.println("此用户不存在");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally {

        }

    }
}
