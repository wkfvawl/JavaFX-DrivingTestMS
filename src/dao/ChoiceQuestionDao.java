package dao;

import pojo.ChoiceQuestion;
import util.DBUtils;
import java.sql.*;
import java.util.ArrayList;

public class ChoiceQuestionDao {
    private static Connection connection = DBUtils.getConnection();

    public static boolean ChoiceItemInsert(ChoiceQuestion cq) {
        PreparedStatement preparedStatement;
        String sql = "insert into ChoiceQuestion(number,content,pic,optionA,optionB,optionC,optionD,answer) values(?,?,?,?,?,?,?,?)";
        try {
            if (cq != null) {
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, cq.getNumber());
                preparedStatement.setString(2, cq.getContent());
                preparedStatement.setString(3, cq.getPic());
                preparedStatement.setString(4, cq.getOptionA());
                preparedStatement.setString(5, cq.getOptionB());
                preparedStatement.setString(6, cq.getOptionC());
                preparedStatement.setString(7, cq.getOptionD());
                preparedStatement.setString(8, cq.getAnswer());
                //修改表中的内容executeUpdate返回值是一个整数
                return preparedStatement.executeUpdate() > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean ChoiceItemDelete(String number) throws SQLException {
        PreparedStatement preparedStatement;
        String sql = "delete from ChoiceQuestion where number = ?";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setString(1,number);
        int result = pst.executeUpdate();//返回值表示受到影响的行数
        if(result>0) {
           return true;
        }
        return false;
    }

    //单个具体查找，根据题目编号
    public static ChoiceQuestion ChoiceItemQuerySingle(String number) throws SQLException {
        String sql = "select * from ChoiceQuestion where number = ?";    //要执行的SQL
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setString(1,number);
        ResultSet rs = pst.executeQuery();//创建数据对象，注意预定义语句上允许带参数
        ChoiceQuestion cq = new ChoiceQuestion();
        while (rs.next()){
            cq.setNumber(rs.getString(1));
            cq.setContent(rs.getString(2));
            cq.setPic(rs.getString(3));
            cq.setOptionA(rs.getString(4));
            cq.setOptionB(rs.getString(5));
            cq.setOptionC(rs.getString(6));
            cq.setOptionD(rs.getString(7));
            cq.setAnswer(rs.getString(8));
            System.out.println(cq.toString());
            }
        return cq;//返回查找到的单选题目
    }



    public static ArrayList<ChoiceQuestion> ChoiceItemQuery() {
        String sql = "select * from ChoiceQuestion";    //要执行的SQL
        ArrayList<ChoiceQuestion> acq=new ArrayList();
        try {
                Statement stmt = connection.createStatement(); //创建Statement对象
                ResultSet rs = stmt.executeQuery(sql);//创建数据对象
                while (rs.next()){
                    ChoiceQuestion cq = new ChoiceQuestion();
                    cq.setNumber(rs.getString(1));
                    cq.setContent(rs.getString(2));
                    cq.setPic(rs.getString(3));
                    cq.setOptionA(rs.getString(4));
                    cq.setOptionB(rs.getString(5));
                    cq.setOptionC(rs.getString(6));
                    cq.setOptionD(rs.getString(7));
                    cq.setAnswer(rs.getString(8));
                    acq.add(cq);
                    System.out.println(cq.toString());
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return acq;//返回ArrayList<ChoiceQuestion>
    }


}
