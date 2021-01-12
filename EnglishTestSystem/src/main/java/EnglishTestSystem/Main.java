/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EnglishTestSystem;
import java.sql.Date;
import java.util.Scanner;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
/**
 *
 * @author Admin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        
//        QuestionList list = DataBase.openGetData();
//        System.out.println(list);
       Scanner s= new Scanner(System.in);
       //Nhap nguoi dung
       User studier;
       UserList uList= new UserList();
       uList= DataBase.openGetDataUserList();
       System.out.println(uList);
       String inp;
       int choose;
        do{
        System.out.println("Moi ban den voi he thong trac nghiem tieng anh sieu cap vjp pro\n"
                + "0.Thoat\n1. Dang nhap\n"
                + "2.Dang ki\n");
        System.out.println("Moi ban chon: ");
        choose=s.nextInt();
        s.nextLine();
        if(choose==1){
            System.out.println("Nhap ten: ");
            inp= s.nextLine();
            studier = uList.find(inp);
                if(studier != null){
                    System.out.println("Dang nhap thanh cong\n");
                    System.out.println(studier);
                    break;}
                else
                    System.out.println("\nKhong tim thay ten trong he thong");}
         if(choose==2){
             
             String name,home,gender;
             System.out.println("Nhap ten");
             name=s.nextLine();             
             System.out.println("Nhap noi sinh");
             home=s.nextLine();
             System.out.println("Nhap gioi tinh");
             gender=s.nextLine();
             System.out.println("Nhap ngay thang nam sinh");
             Date dateOfBirth = Date.valueOf(s.nextLine());
             User u = new User(name, gender, home, dateOfBirth);
             uList.addUser(u);
             DataBase.openSetDataUser(u);
         }
         if(choose==0){
             System.exit(0);
         }
        }
    while(true);
//    //Ket thuc nhap nguoi dung
//
//         QuestionList list = new QuestionList();
//         list = DataBase.openGetData();
//          System.out.println(list);
//          studier.getPoint().add(9.5);
//          System.out.println(studier);
//          uList.upDateDB();
       
        QuestionList listData = DataBase.openGetData();
  
        System.out.println("\n--------Luyen tap-----------\n Moi chon dang cau hoi:"
                + "\n1.Multiple choice\n 2.Incomplete \n3.Conversation\n Chon=: ");
        choose= s.nextInt();
        s.nextLine();
        
        if(choose==1)
        {
            QuestionList list = new QuestionList();
            System.out.println("\nNhap so cau hoi:");
            choose=s.nextInt();
            s.nextLine();
            list = listData.getMultiple();
//            Collections.shuffle((List<?>) list); //Trao list
            System.out.println(list.show(choose)); //Nhap cau tra loi xong xuat
        }
        else if(choose==2){
            QuestionList list = new QuestionList();
            System.out.println("\nNhap muc do cau hoi:");
            choose=s.nextInt();
            s.nextLine();
            list = listData.getIncomplete().find(choose);
            System.out.println(list.showIncomplete());
            //xu li
        }
        else{
            QuestionList list = new QuestionList();
            System.out.println("\nNhap muc do cau hoi:");
            choose=s.nextInt();
            s.nextLine();
            list = listData.getConversation().find(choose);
            System.out.println(list.showConversation());
            //xu li
        }
 
    }
    
}
