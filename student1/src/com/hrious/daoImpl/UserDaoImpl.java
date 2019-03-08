package com.hrious.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hrious.dao.UserDao;
import com.hrious.pojo.User;
import com.hrious.util.JdbcUtil;

public class UserDaoImpl implements UserDao {

    @Override
    public int insertUser(int unum, String uname, int uage) {
        String sql = "insert into t_user values(?,?,?)";
        Connection conn = JdbcUtil.getConn();
        int i = JdbcUtil.executeDML(conn, sql, unum, uname, uage);
        JdbcUtil.release(conn, null, null);
        return i;
    }

    @Override
    public int delUser(int unum) {
        String sql = "delete from t_user where unum=?";
        Connection conn = JdbcUtil.getConn();
        int i = JdbcUtil.executeDML(conn, sql, unum);
        JdbcUtil.release(conn, null, null);
        return i;
    }

    @Override
    public int updateUserName(int unum, String uname) {
        String sql = "update t_user set uname=? where unum=?";
        Connection conn = JdbcUtil.getConn();
        int i = JdbcUtil.executeDML(conn, sql, uname, unum);
        JdbcUtil.release(conn, null, null);
        return i;
    }

    @Override
    public List<User> selectAllUser() {
        String sql = "select * from t_user";
        Connection conn = JdbcUtil.getConn();
        PreparedStatement ps = JdbcUtil.getPreparedStatement(conn, sql);
        ResultSet rs = null;
        List<User> list = null;
        try {
            rs = ps.executeQuery();
            list = new ArrayList<User>();
            while (rs.next()) {
                User u = new User();
                u.setUnum(rs.getInt("unum"));
                u.setUname(rs.getString("uname"));
                u.setUage(rs.getInt("uage"));
                list.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

	@Override
	public User selectUser(int unum) {
		String sql = "select * from t_user where unum=?";
        Connection conn = JdbcUtil.getConn();
        PreparedStatement ps = JdbcUtil.getPreparedStatement(conn, sql);
        ResultSet rs = null;
        User u =null;
        try {
			ps.setInt(1, unum);
			rs = ps.executeQuery();
			u = new User();
			while (rs.next()) {
				u.setUnum(rs.getInt("unum"));
				u.setUname(rs.getString("uname"));
				u.setUage(rs.getInt("uage"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return u;
	}

}
