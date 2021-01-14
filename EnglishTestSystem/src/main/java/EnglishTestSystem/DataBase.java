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
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class DataBase {
    /**
     * Hàm lấy dữ liệu câu hỏi từ dataBase
     * @return list Question
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public static QuestionList openGetData() throws SQLException, ClassNotFoundException{        
        Choice ans;
        int l, k;
        String content;
        String sqlSelect = "SELECT * FROM multiplechoice";
        QuestionList list = new QuestionList();
       try(
               Connection conn = ConnectionUtils.openConnection();
               Statement st = conn.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
               ResultSet rs = st.executeQuery(sqlSelect);
               
               ){
           while(rs.next()){
               content = rs.getString(2);
               l = rs.getInt(3);
               k = rs.getInt(4);
               Choice[] c = new Choice[4];
               for(int j = 5,i = 0; i < 4; i++,j++){
                   
                   c[i] = new Choice(rs.getString(j));
               }
               ans = new Choice(rs.getString(9),rs.getString(10));
               Question mul = new MultipleChoice(content, l, k, c, ans);
               list.addQuestion(mul);
           }
       }
       
       /////////////////////////////////////////////////////////////////////////
       ////////////////////////////////////////////////////////////////////////
        String sqlSelect2 = "SELECT * FROM multiple_to WHERE id_incomplete =";
        String sqlSelect1 = "SELECT * FROM incomplete";
       int flag1 = 1;

       try(
               Connection conn = ConnectionUtils.openConnection();
               Statement st = conn.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
               ResultSet rs = st.executeQuery(sqlSelect1);
               ){
           while(rs.next()){
               content = rs.getString(2);
               l = rs.getInt(3);
               k = rs.getInt(4);
               MultipleChoice[] mul = new MultipleChoice[5];
               int flag2 = 0;
               try(
                    Statement stt = conn.createStatement(
                         ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                    ResultSet rss = stt.executeQuery(sqlSelect2 + flag1++);
                    ){
                while(rss.next()){
                    String cont = rss.getString(2);
                    Choice[] c = new Choice[4];
                        for(int j = 3,i = 0; i < 4; i++,j++){
                            c[i] = new Choice(rss.getString(j));
                        }
                    Choice answer = new Choice(rss.getString(7),rss.getString(8));
                    mul[flag2] = new MultipleChoice(cont, c, answer);
                    flag2++;
                    
                    }
                } 
               Question incomple = new Incomplete(content, l, k, mul);
               list.addQuestion(incomple);
               
           }
           }
       ////////////////////////////////////////////////////////////////////////
       ///////////////////////////////////////////////////////////////////////
       /**
        * lay du lieu Conversation
        */
            String sqlSelect4 = "SELECT * FROM multiple_to WHERE id_conversation =";
            String sqlSelect3 = "SELECT * FROM conversation";
            flag1 = 1;

            try(
                    Connection conn = ConnectionUtils.openConnection();
                    Statement st = conn.createStatement(
                         ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                    ResultSet rs = st.executeQuery(sqlSelect3);
                    ){
                while(rs.next()){
                    content = rs.getString(2);
                    l = rs.getInt(3);
                    k = rs.getInt(4);
                    MultipleChoice[] mul = new MultipleChoice[10];
                    int flag2 = 0;
                    try(
                         Statement stt = conn.createStatement(
                              ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                         ResultSet rss = stt.executeQuery(sqlSelect4 + flag1++);
                         ){
                     while(rss.next()){
                         String cont = rss.getString(2);
                         Choice[] c = new Choice[4];
                             for(int j = 3,i = 0; i < 4; i++,j++){
                                 c[i] = new Choice(rss.getString(j));
                             }
                         Choice answer = new Choice(rss.getString(7),rss.getString(8));
                         mul[flag2] = new MultipleChoice(cont, c, answer);
                         flag2++;

                         }
                     } 
                    Question conversation = new Conversation(content, l, k, mul);
                    list.addQuestion(conversation);

                }
         }
        return list;
    }
   /**
    * hàm lấy về danh sách học viên
    * @return list user
    * @throws SQLException
    * @throws ClassNotFoundException 
    */
    public static UserList openGetDataUserList() throws SQLException, ClassNotFoundException{ 
        String name, home, gender;
        Date dateOfBirth;
        Date dateStart;
        String stringPoint;
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
               List<Double> point =new ArrayList<>();
               stringPoint=rs.getString(7);
               if(stringPoint != null){
                    String[] arrayPoint =stringPoint.split(",");

                    for(String v: arrayPoint){

                        point.add(Double.parseDouble(v));
                    }
               }
               User u= new User(name,gender, home, dateOfBirth, dateStart, point);
               list.addUser(u);
           }
       }
        return list;
    }
    
    public static void openSetDataUser(User studier) throws SQLException, ClassNotFoundException{
        
        try (
            Connection con = ConnectionUtils.openConnection();
            Statement st = con.createStatement(
                    ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
        ){
            String sqlInsert = "INSERT INTO englishtest.user(name, home, gender, birth, start) "
                    + " VALUE('" + studier.getName() +"', '" + studier.getHomeTown() + 
                    "', '" + studier.getGender() + "', '" + studier.getDateOfBirth() + 
                    "', '" + studier.getDateStart() + "');";
            st.executeUpdate(sqlInsert);
            
        }
    
    }
   
    public static void openUpDateDataUser(User studier, int countDB) throws SQLException, ClassNotFoundException{
        try (
            Connection con = ConnectionUtils.openConnection();
            Statement st = con.createStatement(
                    ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
        ){
                String points = "";
                points = studier.getPoint().stream().map(s -> Double.toString(s) + ",").reduce(points, String::concat);
                
                String sqlUpdate = "UPDATE user SET name = '"+ studier.getName() +"',"
                        + "home = '" + studier.getHomeTown() + "', "
                        + "gender = '" + studier.getGender() + "', "
                        + "birth = '" + studier.getDateOfBirth() + "', "
                        + "start = '" + studier.getDateStart() + "', "
                        + "points = '" + points
                        + "' WHERE (id = '"+ countDB +"');";
                st.executeUpdate(sqlUpdate);
        }
    }
}
