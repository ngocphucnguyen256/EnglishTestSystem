/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EnglishTestSystem;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.sql.*;

/**
 *
 * @author Admin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
       Scanner s= new Scanner(System.in);
       QuestionList list = new QuestionList();
       list = GetData.openGetData();
        System.out.println(list);
       


    }
    
}
