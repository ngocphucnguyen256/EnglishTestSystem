/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EnglishTestSystem;

/**
 *
 * @author Admin
 */
public class Incomplete extends Question{
        private MultipleChoice[] incompleteChoices = new MultipleChoice[5];

    public Incomplete(String content, int level, int kind, MultipleChoice[] incomplete) {
        super(content, level, kind);
        this.incompleteChoices = incomplete;
    }
    
    
     @Override
    public String showAnswer(){
         String str = super.toString() + "\n";
        for(int e = 1, i = 0; i < this.incompleteChoices.length ; i++){
            str += "\nCau " + e++ + " :\n";
            str += "\tDap an : " + this.incompleteChoices[i].getAnswer().getContent();
            str += "\n\t giai thich : " + this.incompleteChoices[i].getAnswer().getExplaination();
            }           
        return str;
    }
    
        @Override
    public int checkAnswer(String ans){
        String[] s = ans.split(",");
        int chance=0;
        int j=0;
        
        for(String item : s){
            Choice[] iC = new Choice[5];
            iC = this.incompleteChoices[j].getChoices();
            int a = 65;
            int b = 97;
            int c = item.charAt(0);
            for(int i = 0; i <= 3; i++){
                if (c == a++ || c == b++)
                    ans = iC[i].getContent();
            }
            if(ans.compareTo(this.incompleteChoices[j].getAnswer().getContent()) == 0){
                System.out.println("Cau " + ++j + ": Dung!!");
                chance+=1;}
            else
                System.out.println("Cau " + ++j + ": Sai!!");
            if(j > 5) break;
            }
        return chance;
    } 

    @Override
    public String toString() {
        String str = this.getContent() + "\n";
        for(int e = 0,i = 0; i <= 4; i++){
            str += "Cau " + ++e + ": " + this.incompleteChoices[i].getContent() +"\n";
            for(int k = 65,j = 0; j < 4; j++, k++){
                str += "\t" +(char)k +"."+ 
                        this.incompleteChoices[i].getChoices()[j].getContent() 
                        +"\n";
            }
            
        }
        return str;
               
    }
    /**
     * @return the incompleteChoices
     */
    public MultipleChoice[] getIncompleteChoices() {
        return incompleteChoices;
    }

    /**
     * @param incompleteChoices the incompleteChoices to set
     */
    public void setIncompleteChoices(MultipleChoice[] incompleteChoices) {
        this.incompleteChoices = incompleteChoices;
    }
    
 
    
}
