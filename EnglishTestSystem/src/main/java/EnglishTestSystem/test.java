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

/**
 *
 * @author Admin
 */
public class test {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        int l, k;
        String content;
        QuestionList lists = new QuestionList();
        
       /**
        * lấy dữ liệu từ incomple;
        */
       String sqlSelect4 = "SELECT * FROM multiple_to WHERE id_conversation =";
       String sqlSelect3 = "SELECT * FROM conversation";
       int flag1 = 1;

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
               lists.addQuestion(conversation);
               
           }
    }
        System.out.println(lists);
}
}
