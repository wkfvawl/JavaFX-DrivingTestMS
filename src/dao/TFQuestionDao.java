package dao;

import pojo.TrueFalseQuestion;
import util.DBUtils;
import java.sql.*;
import java.util.ArrayList;

public class TFQuestionDao {
    private static Connection connection = DBUtils.getConnection();
    public static boolean TFItemInsert(TrueFalseQuestion tfq) {
        System.out.println(tfq.toString());
        PreparedStatement preparedStatement;
        String sql = "insert into TFQuestion(number,content,pic,optionA,optionB,answer) values(?,?,?,?,?,?)";
        try {
            if (tfq != null) {
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, tfq.getNumber());
                preparedStatement.setString(2, tfq.getContent());
                preparedStatement.setString(3, tfq.getPic());
                preparedStatement.setString(4, tfq.getOptionT());
                preparedStatement.setString(5, tfq.getOptionF());
                preparedStatement.setString(6, tfq.getAnswer());
                //修改表中的内容executeUpdate返回值是一个整数
                return preparedStatement.executeUpdate() > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean TFItemDelete(String number) throws SQLException {
        PreparedStatement preparedStatement;
        String sql = "delete from TFQuestion where number = ?";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setString(1,number);
        int result = pst.executeUpdate();//返回值表示受到影响的行数
        if(result>0) {
           return true;
        }
        return false;
    }

    //单个具体查找，根据题目编号
    public static TrueFalseQuestion TFItemQuerySingle(String number) throws SQLException {
        String sql = "select * from TFQuestion where number = ?";    //要执行的SQL
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setString(1,number);
        ResultSet rs = pst.executeQuery();//创建数据对象，注意预定义语句上允许带参数
        TrueFalseQuestion tfq = new TrueFalseQuestion();
        while (rs.next()){
            tfq.setNumber(rs.getString(1));
            tfq.setContent(rs.getString(2));
            tfq.setPic(rs.getString(3));
            tfq.setOptionT(rs.getString(4));
            tfq.setOptionF(rs.getString(5));
            tfq.setAnswer(rs.getString(6));
            System.out.println(tfq.toString());
        }
        return tfq;//返回查找到的单选题目
    }



    public static ArrayList<TrueFalseQuestion> TFItemQuery() {
        String sql = "select * from TFQuestion";    //要执行的SQL
        ArrayList<TrueFalseQuestion> atfq=new ArrayList();
        try {
            Statement stmt = connection.createStatement(); //创建Statement对象
            ResultSet rs = stmt.executeQuery(sql);//创建数据对象
            while (rs.next()){
                TrueFalseQuestion tfq = new TrueFalseQuestion();
                tfq.setNumber(rs.getString(1));
                tfq.setContent(rs.getString(2));
                tfq.setPic(rs.getString(3));
                tfq.setOptionT(rs.getString(4));
                tfq.setOptionF(rs.getString(5));
                tfq.setAnswer(rs.getString(6));
                atfq.add(tfq);
                System.out.println(tfq.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return atfq;//返回ArrayList<TrueFalseQuestion>
    }
}
