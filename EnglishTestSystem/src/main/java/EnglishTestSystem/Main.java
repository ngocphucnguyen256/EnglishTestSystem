/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EnglishTestSystem;
import java.sql.Date;
import java.util.Scanner;
import java.sql.*;
import java.util.*;
/**
 *
 * @author Admin
 */
public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
       Scanner s= new Scanner(System.in);
       //Nhap nguoi dung
       User studier;
       UserList uList= new UserList();
       uList= DataBase.openGetDataUserList();
       String inp;
       int choose;
        do{
            try{
                System.out.println("******Moi ban den voi he thong trac nghiem "
                        + "tieng anh*******\n"
                        + "0.Thoat\n1.Dang nhap\n"
                        + "2.Dang ki\n");
                System.out.println(">Moi ban chon: ");
                choose=s.nextInt();
                s.nextLine();
                if(choose==1){
                    System.out.println(">Nhap ten: ");
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
                     System.out.println(">Nhap ten");
                     name=s.nextLine();             
                     System.out.println(">Nhap noi sinh");
                     home=s.nextLine();
                     System.out.println(">Nhap gioi tinh");
                     gender=s.nextLine();
                     System.out.println(">Nhap nam thang ngay sinh(!nam-thang-ngay!)");
                     Date dateOfBirth = Date.valueOf(s.nextLine());
                     User u = new User(name, gender, home, dateOfBirth);
                     uList.addUser(u);
                     DataBase.openSetDataUser(u);
                 }
                 if(choose==0){
                     System.exit(0);
                 }
             }
        catch(InputMismatchException ex){
            System.out.println("Nhap sai!!!!!!!!!");}
        }
        while(true);
//Ket thuc nhap nguoi dung
 do{
       try{
           System.out.println("******HE THONG TRAC NGHIEM TIENG ANH******");
           System.out.println("1.Luyen tap.");
           System.out.println("2.Xem thong tin.");
           System.out.println("3.Sua thong tin ca nhan.");
           System.out.println("0.Luu va thoat.");
           choose=s.nextInt();
           s.nextLine();
           QuestionList listData = DataBase.openGetData();
           QuestionList list = new QuestionList();
           if(choose==1){
                System.out.println("\n--------Luyen tap-----------\n Moi chon dang cau hoi:"
                        + "\n1.Multiple choice\n 2.Incomplete \n3.Conversation\n>Chon: ");
                choose= s.nextInt();
                s.nextLine();
                if(choose==1)
                { 
                    System.out.println("\n>Nhap so luong cau hoi ban muon lam:");
                    choose=s.nextInt();
                    s.nextLine();
                    list = listData.getMultiple();
                    studier.getPoint().add(list.showMultiple(choose));
                }
                else if(choose==2){
                    System.out.println("\n>Nhap muc do cau hoi ban muon lam:"
                            + "\n 1.De \n 2.Trung binh \n 3.Kho"
                            + "\n>Chon:");
                    choose=s.nextInt();
                    s.nextLine();
                    list = listData.getIncomplete().find(choose);
                    studier.getPoint().add(list.showIncomplete());
                }
                else if(choose==3){
                    System.out.println("\n>Nhap muc do cau hoi ban muon lam:"
                            + "\n 1.De \n 2.Trung binh \n 3.Kho"
                            + "\n>Chon:");
                    choose=s.nextInt();
                    s.nextLine();
                    list = listData.getConversation().find(choose);
                    studier.getPoint().add(list.showConversation());
                }
           }
           else if(choose==2){
               System.out.println("\n-------Thong tin hoc vien---------");
               System.out.println(studier);
           }
           else if(choose == 3){
               System.out.println("===Chinh sua thong tin====");
               studier.upDateUser();
               System.out.println("====Thong tin cap nhat====");
               System.out.println(studier);
           }
           else if(choose==0){
               uList.upDateDB();
               System.out.println("---------Luu thanh cong--------------");
               System.out.println("=============Ket thuc================");
               System.exit(0);
           }
       }catch(InputMismatchException ex){
           System.out.println("Nhap sai!!!!!!!!!");}
  }while(true);
    }
}
