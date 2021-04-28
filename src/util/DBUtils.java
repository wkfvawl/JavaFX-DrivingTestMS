package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//数据库工具类
public class DBUtils {
    private static Connection connection;
    private static String dirverName = "org.apache.derby.jdbc.EmbeddedDriver";
    private static String uri = "jdbc:derby:MyDB/DrivingTest;create=true";
    //这里将Derby数据库创建到本项目的目录下
    //加载数据 库驱动
    public DBUtils() {
        super();
        try {
            Class.forName(dirverName);
        } catch (Exception e) {
            System.out.print("数据库驱动加载异常" + e);
        }
    }

    //获取数据库连接对象
    public static Connection getConnection() {
        try {
            if (connection == null) {
                connection = DriverManager.getConnection(uri);//Derby数据库建立连接
            }
        } catch (SQLException e) {
            System.out.println("连接数据库异常" + e);
        }
        return connection;
    }
}