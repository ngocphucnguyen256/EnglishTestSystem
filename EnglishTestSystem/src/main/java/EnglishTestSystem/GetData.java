/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EnglishTestSystem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author Admin
 */
public class GetData {
    public static QuestionList openGetData() throws SQLException, ClassNotFoundException{        
        Choice ans;
        int l, k;
        String cont;
        String sqlSelect = "SELECT * FROM multiplechoice";
        QuestionList list = new QuestionList();
       try(
               Connection conn = ConnectionUtils.openConnection();
               Statement st = conn.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
               ResultSet rs = st.executeQuery(sqlSelect);
               
               ){
           while(rs.next()){
               cont = rs.getString(2);
               l = rs.getInt(3);
               k = rs.getInt(4);
               Choice[] c = new Choice[4];
               for(int j = 5,i = 0; i < 4; i++,j++){
                   
                   c[i] = new Choice(rs.getString(j));
               }
               ans = new Choice(rs.getString(9),rs.getString(10));
               Question mul = new MultipleChoice(cont, l, k, c, ans);
               list.addQuestion(mul);
           }
       }
        return list;
    }
   
    public static UserList openGetDataUserList() throws SQLException, ClassNotFoundException{ 
        String name, home, gender;
        GregorianCalendar dateOfBirth = new GregorianCalendar();
        GregorianCalendar dateStart = new GregorianCalendar();
        Double aPoint;
        String sqlSelect = "SELECT * FROM user";
        UserList list = new UserList();
       try(
               Connection conn = ConnectionUtils.openConnection();
               Statement st = conn.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
               ResultSet rs = st.executeQuery(sqlSelect);
               
               ){
           while(rs.next()){
               name = rs.getString(2);
               home = rs.getString(3);
               gender = rs.getString(4);
               dateOfBirth= rs.getDate(5);
               dateStart= rs.getDate(6);
               List<Double> points = new ArrayList<>();
               points = rs.getArray(points);
               aPoint= rs.getDouble(10);
               User u= new User(name, home, gender, dateOfBirth, dateStart, points, aPoint);
               list.addUser(u);
           }
       }
        return list;
    }
   
}
