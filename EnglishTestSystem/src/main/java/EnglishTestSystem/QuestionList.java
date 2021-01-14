/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EnglishTestSystem;

import java.util.ArrayList;
import java.util.Collections;
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
    public QuestionList find(int l)
    {
      QuestionList temp =new QuestionList();
      this.questions.stream().filter(q -> (q.getLevel()==l)).forEachOrdered(q -> {
          temp.addQuestion(q);
         });
        return temp;
    }
    /**
     * tim kiem theo content
     * @param kw: chuoi ky tu
     * @return List cau hoi
     */
    public QuestionList find(String kw){
        QuestionList temp = new QuestionList();
        this.questions.stream().filter(q -> (q.getContent().contains(kw))).forEachOrdered(q -> {
            temp.addQuestion(q);
         });
        return temp;
    }
    /**
     * tim kiem theo loai cau hoi
     * @param k: so nguyen
     * @return List cau hoi
     */
    public QuestionList findKind(int k){
        QuestionList temp =new QuestionList();
        this.questions.stream().filter(q -> (q.getKind()==k)).forEachOrdered(q -> {
            temp.addQuestion(q);
         });
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

    /**
     * 
     * @param choose
     * @return 
     */
    public Double showMultiple(int choose){
        Scanner s= new Scanner(System.in);
        String str="\n";
        int chance=0; //ti le tra loi dung
        int count=1;
        Collections.shuffle(this.questions);
        while (count <= choose){
        for(Question q: this.questions){
                    System.out.println("\nCau " + count + q); 
                    System.out.println("\nNhap cau tra loi:");
                    String ans= s.nextLine();
                    str+= "Cau"+count+": "+ q.showAnswer();                    
                    if (q.checkAnswer(ans)== 1){
                        chance+=1;
                        str += "\tTra loi: Dung !!\n\n";
                    }
                    else 
                        str += "\tTra loi: Sai !!\n\n";
                    

                    count++;
                    if(count > choose)
                        break;
                } 
        }
        System.out.println(str+ "So cau tra loi dung: "+chance+"/"+choose+"\n");
        System.out.println("Diem: " + 10.0/choose*chance);
        return 10.0/choose*chance;
    }
    
    public Double showIncomplete(){
        Scanner s = new Scanner(System.in);
        String ans = "";
        int chance = 0;
        double countPoint = 5.0;
        Collections.shuffle(this.questions);
        for(Question a : this.questions){
            System.out.println("=======Incomplete======");
            System.out.println(a);
            System.out.println("Nhap cau tra loi(?,?,?,..) : ");
            for(int j = 1, i = 0; i < 5; i++){
                System.out.println("Cau " + j++ + " : ");
                String temp = s.nextLine();
                ans += temp + ",";
            }
            chance = a.checkAnswer(ans);
            System.out.println(a.showAnswer());
            break;
        }
        System.out.println("So cau tra loi dung: "+chance+"/" + (int)countPoint + "\n");
        System.out.println("Diem: " + 10.0/countPoint*chance);
        return 10.0/countPoint * chance;
    }
    
    public Double showConversation(){
        Scanner s = new Scanner(System.in);
        String ans= "";
        int chance = 0;
        double countPoint = 10.0;
        Collections.shuffle(this.questions);
        for(Question a : this.questions){
            System.out.println("=======CONVERSATION======");
            System.out.println(a);
            System.out.println("Nhap cau tra loi(?,?,?,..) : ");
            for(int j = 1, i = 0; i < 10; i++){
                System.out.println("Cau " + j++ + " : ");
                String temp = s.nextLine();
                ans += temp + ",";
            }
            chance = a.checkAnswer(ans);
            System.out.println(a.showAnswer());
            break;
        }
        System.out.println("So cau tra loi dung: "+chance+"/" + (int)countPoint + "\n");
        System.out.println("Diem: " + 10.0/countPoint*chance);
        return 10.0/countPoint * chance;
    }
    /**
     * lay ra list cau hoi Multiple
     * @return 
     */
    public QuestionList getMultiple(){
        QuestionList list = new QuestionList();
        this.questions.stream().filter(a -> (a instanceof MultipleChoice)).forEachOrdered(a -> {
            list.addQuestion(a);
         });
        return list;
    }
    /**
     * lay ra list cau hoi incomplete
     * @return 
     */
    public QuestionList getIncomplete(){
        QuestionList list = new QuestionList();
        this.questions.stream().filter(a -> (a instanceof Incomplete)).forEachOrdered(a -> {
            list.addQuestion(a);
         });
        return list;
    }
    /**
     * lay ra list cau hoi conversation
     * @return 
     */
    public QuestionList getConversation(){
        QuestionList list = new QuestionList();
        this.questions.stream().filter(a -> (a instanceof Conversation)).forEachOrdered(a -> {
            list.addQuestion(a);
         });
        return list;
    }
}
