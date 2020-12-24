/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EnglishTestSystem;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
//        Choice[] ds = new Choice[5];
//        String answer;
//        ds[0] = new Choice("Chao", "cac cau");
//        ds[1] = new Choice("AAAAA", "aaaaa");
//        ds[2] = new Choice("BBBBB", "bbbbb");
//        ds[3] = new Choice("CCCCC", "ccccccc");
//       
//        Question a = new MultipleChoice("AAAAA", 0, 0, ds, new Choice("Chao","cccc"));
//        Question b = new MultipleChoice("BBBBB", 0, 0, ds, new Choice("Chao","cccc"));
//        Question c = new MultipleChoice("CCCCC", 0, 0, ds, new Choice("Chao","cccc"));
//        Question d = new MultipleChoice("DDDDD", 0, 0, ds, new Choice("Chao","cccc"));
//        Question e = new MultipleChoice("EEEEE", 0, 0, ds, new Choice("Chao","cccc"));
//        Question f = new MultipleChoice("FFFFF", 0, 0, ds, new Choice("Chao","cccc"));
//        QuestionList duMa = new QuestionList();
//        duMa.addQuestion(a);
//        duMa.addQuestion(b);
//        duMa.addQuestion(c);
//        duMa.addQuestion(d);
//        duMa.addQuestion(e);
//        duMa.addQuestion(f);
//        System.out.println(duMa);
          User Fuck = new User();
          System.out.println("Moi dm ban dang ki: ");
          System.out.print("Ten: ");
          Fuck.setName(s.nextLine());
          System.out.print("Gioi Tinh: ");
          Fuck.setGender(s.nextLine());
          System.out.print("Que Quan: ");
          Fuck.setHomeTown(s.nextLine());
          int d, m, y;
          System.out.print("Ngay sinh: ");
          d = s.nextInt();
          m = s.nextInt();
          y = s.nextInt();
          Fuck.setDateOfBirth(new GregorianCalendar(y,--m,d));       
          System.err.println("dang ky thanh cong");
          
          System.out.println(Fuck);
          
  
       
      
        
    }
    
}
