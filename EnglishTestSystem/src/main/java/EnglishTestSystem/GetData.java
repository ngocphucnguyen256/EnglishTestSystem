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
}
