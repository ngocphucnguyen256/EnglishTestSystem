/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EnglishTestSystem;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class MultipleChoice extends Question{
    private Choice[] choices= new Choice[5];
    private Choice answer;
    private static int count = 0;
    private int id;
    {
        id = ++count;
    }

    public MultipleChoice() {
        super(null, 0, 0);
    }
   
    
    public MultipleChoice(String content, int level, int kind, Choice[] choice, Choice answer) {
        super(content, level, kind);
        this.answer = answer;
        this.choices = choice;
    }

    public MultipleChoice(String content, Choice[] choice, Choice answer) {
        super(content, 0, 0);
        this.answer = answer;
        this.choices = choice;
    }
    
    public String showAnswer(){
           String str = this.getContent() + "\n";
           str += "Dap an: " + this.getAnswer().getContent();
           str += "\nGiai thich: " + this.getAnswer().getExplaination() + "\n";
           return str;
    }

    @Override
    public String toString() {
        return String.format(" %s \n A. %s \n B. %s \n C. %s\n D. %s",
                    super.toString() , this.getChoices()[0].getContent(),
                    this.getChoices()[1].getContent(), this.getChoices()[2].getContent(),
                    this.getChoices()[3].getContent());
        
         
    }
     public String checkAnswer(String ans) {
        int a = 65;
        int b = 97;
        int c = ans.charAt(0);
        for(int i = 0; i <= 3; i++){
            if (c == a++ || c == b++)
                ans = this.getChoices()[i].getContent();
        }
        if(ans.compareTo(this.getAnswer().getContent()) == 0)
            return("Dung");
        else
            return("Sai!!");
        
    }
    /**
     * @return the choices
     */
    public Choice[] getChoices() {
        return choices;
    }

    /**
     * @param choices the choices to set
     */
    public void setChoices(Choice[] choices) {
        this.choices = choices;
    }

    /**
     * @return the answer
     */
    public Choice getAnswer() {
        return answer;
    }

    /**
     * @param answer the answer to set
     */
    public void setAnswer(Choice answer) {
        this.answer = answer;
    }
    
    
    
    
}
