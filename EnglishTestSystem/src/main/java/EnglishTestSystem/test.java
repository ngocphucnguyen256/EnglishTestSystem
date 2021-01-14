/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EnglishTestSystem;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class test {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Scanner s = new Scanner(System.in);
        Date date;
        int d = 1,m = 1 - 1,y = 2001 - 1900;
        date = new Date(y, m, d);
        System.out.println(date);
        
}
}
