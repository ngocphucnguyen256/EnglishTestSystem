/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EnglishTestSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ACER
 */
public class QuestionList {
     private List<Question> questions = new ArrayList<>();
    /**
     * them vao cau hoi
     * @param q cau hoi
     */
    public void addQuestion(Question q)
    {
        this.questions.add(q);
     
    }
    /**
     * xoa cau hoi
     * @param q 
     */
//    public void removeQuestion(Question q)
//    {
//        this.questions.remove(q);
//    }
    /**
     * tim kiem theo level
     * @param l: muc do cau hoi(1,2,3)
     * @return List cau hoi
     */
    public List<Question> find(int l)
    {
      List <Question> temp =new ArrayList<>();
        for(Question q : this.questions)
        {
            if(q.getLevel()==l)
                temp.add(q);
        }
        return temp;
    }
    /**
     * tim kiem theo content
     * @param c: chuoi ky tu
     * @return List cau hoi
     */
    public List<Question> find(String kw){
        List<Question> temp = new ArrayList<>();
        for(Question q : this.questions){
            if(q.getContent().contains(kw))
                temp.add(q);
        }
        return temp;
    }
    /**
     * tim kiem theo loai cau hoi
     * @param k: so nguyen
     * @return List cau hoi
     */
    public List<Question> findKind(int k){
        List <Question> temp =new ArrayList<>();
        for(Question q : this.questions)
        {
            if(q.getKind()==k)
                temp.add(q);
        }
        return temp;
    }

    @Override
    public String toString() {
        String str = "danh sach:\n";
        int i = 1;
        for(Question s : this.questions){
            str += "\nCau " + i++ + ". "+ s;
        }
        return str;
    }

    
    public String show(int choose){
        Scanner s= new Scanner(System.in);
        String str="\n";
        int chance=0; //ti le tra loi dung
        int count=1;
        for(Question q: this.questions){
                while (count<=choose){
            
                    System.out.println("\nCau " + count++ + q); 
                    System.out.println("\nNhap cau tra loi:");
                    String ans= s.nextLine();
                    str+= "Cau"+count+": ";
                    str+= q.checkAnswer(ans)+"\n";
                    if (q.checkAnswer(ans)=="Dung"){
                        chance+=1;
                    }
                } 
        }
       return str+ "So cau tra loi dung: "+chance+"/"+choose+"\n";
    }
   
}
