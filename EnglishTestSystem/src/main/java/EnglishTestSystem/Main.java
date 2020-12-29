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
       UserList uList= new UserList();
       uList= GetData.openGetDataUserList();
        System.out.println("Moi ban den voi he thong trac nghiem tieng anh sieu cap vjp pro\n"
                + "1. Dang nhap\n"
                + "2.Dang ki\n");
        if(s.nextInt()==1)
            do{
            System.out.println("Nhap ten: ");
            String inp= s.nextLine();
                if(uList.find(inp)!=null){
                    System.out.println("Dang nhap thanh cong\n");
                    System.out.println(uList.find(inp));}
                else
                    System.out.println("\nKhong tim thay ten trong he thong");
            } 
            while(uList.find(inp)==null);
      
       QuestionList list = new QuestionList();
       list = GetData.openGetData();
        System.out.println(list);
       


    }
    
}
