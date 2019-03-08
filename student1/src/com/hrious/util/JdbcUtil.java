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
 * ���ݿ����������
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
            // ���ּ�����Դ�ļ��ķ���
            // prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("/db.properties"));
            prop.load(JdbcUtil.class.getResourceAsStream("/db.properties"));
            driver = prop.getProperty("driver");
            url = prop.getProperty("url");
            user = prop.getProperty("user");
            password = prop.getProperty("password");
            logger.debug("���ݿ���Դ�����ļ����سɹ�");
            
            // ������������
            Class.forName(driver);
        } catch (IOException e) {
        	logger.error("���ݿ���Դ�ļ�����ʧ��" + e.getMessage());
        } catch (ClassNotFoundException e) {
        	logger.error("���ݿ������������ʧ��" + e.getMessage());
        }
    }
    
    private JdbcUtil() {}
    
    public static Connection getConn() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            logger.debug("���ݿ�Connection�����ȡ�ɹ�");
        } catch (SQLException e) {
        	logger.error("���ݿ����Ӷ����ȡʧ��" + e.getMessage());
        }
        return conn;
    }
    
    public static PreparedStatement getPreparedStatement(Connection conn, String sql) {
        PreparedStatement ps = null;
        
        try {
            ps = conn.prepareStatement(sql);
            logger.debug("���ݿ�PreparedStatement���󴴽��ɹ�");
        } catch (SQLException e) {
        	logger.error("���ݿ�PreparedStatement���󴴽�ʧ��" + e.getMessage());
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
            	logger.error("���ݿ�" + sql + "ִ��ʧ��,���ݿ�ع�" + e.getMessage());
                conn.rollback();
            } catch (SQLException e1) {
            	logger.error("���ݿ�ع�ʧ��" + e1.getMessage());
            }
        }
        return -1;
    }
    
    public static void release(Connection conn, Statement stmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
            	logger.error("���ݿ�ResultSet�ر�ʧ��" + e.getMessage());
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
            	logger.error("���ݿ�Statement�ر�ʧ��" + e.getMessage());
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
            	logger.error("���ݿ�Connection�ر�ʧ��" + e.getMessage());
            }
        }
    }
}
