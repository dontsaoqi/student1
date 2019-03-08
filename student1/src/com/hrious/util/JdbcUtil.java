package com.hrious.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * 数据库操作工具类
 * @author wgc
 *
 */
public class JdbcUtil {
	private static Logger logger = Logger.getLogger(JdbcUtil.class);
    private static String driver;
    private static String url;
    private static String user;
    private static String password;
    
    static {
        Properties prop = new Properties();
        try {
            // 两种加载资源文件的方法
            // prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("/db.properties"));
            prop.load(JdbcUtil.class.getResourceAsStream("/db.properties"));
            driver = prop.getProperty("driver");
            url = prop.getProperty("url");
            user = prop.getProperty("user");
            password = prop.getProperty("password");
            logger.debug("数据库资源配置文件加载成功");
            
            // 加载驱动程序
            Class.forName(driver);
        } catch (IOException e) {
        	logger.error("数据库资源文件加载失败" + e.getMessage());
        } catch (ClassNotFoundException e) {
        	logger.error("数据库驱动程序加载失败" + e.getMessage());
        }
    }
    
    private JdbcUtil() {}
    
    public static Connection getConn() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            logger.debug("数据库Connection对象获取成功");
        } catch (SQLException e) {
        	logger.error("数据库连接对象获取失败" + e.getMessage());
        }
        return conn;
    }
    
    public static PreparedStatement getPreparedStatement(Connection conn, String sql) {
        PreparedStatement ps = null;
        
        try {
            ps = conn.prepareStatement(sql);
            logger.debug("数据库PreparedStatement对象创建成功");
        } catch (SQLException e) {
        	logger.error("数据库PreparedStatement对象创建失败" + e.getMessage());
        }
        
        return ps;
    }
    
    public static int executeDML(Connection conn, String sql, Object... objs) {
        PreparedStatement ps = null;
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < objs.length; i++) {
                ps.setObject(i + 1, objs[i]);
            }
            int i = ps.executeUpdate();
            conn.commit();
            return i;
        } catch (SQLException e) {
            try {
            	logger.error("数据库" + sql + "执行失败,数据库回滚" + e.getMessage());
                conn.rollback();
            } catch (SQLException e1) {
            	logger.error("数据库回滚失败" + e1.getMessage());
            }
        }
        return -1;
    }
    
    public static void release(Connection conn, Statement stmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
            	logger.error("数据库ResultSet关闭失败" + e.getMessage());
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
            	logger.error("数据库Statement关闭失败" + e.getMessage());
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
            	logger.error("数据库Connection关闭失败" + e.getMessage());
            }
        }
    }
}
