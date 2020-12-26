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
public class Conversation extends Question{
    private MultipleChoice[] conversationChoices = new MultipleChoice[10];

    public Conversation(String content, int level, int kind, MultipleChoice[] conversationChoices) {
        super(content, level, kind);
        this.conversationChoices = conversationChoices;
    }
    
    
    @Override
    public void checkAnswer(String ans){
        String[] s = ans.split(",");
        int j=0;
        for(String item : s){
            System.out.println(item);
            Choice[] cC = new Choice[5];
            cC = this.conversationChoices[j].getChoices();
            int a = 65;
            int b = 97;
            int c = item.charAt(0);
            for(int i = 0; i <= 3; i++){
                if (c == a++ || c == b++)
                    ans = cC[i].getContent();
            }
            if(ans.compareTo(this.conversationChoices[j].getAnswer().getContent()) == 0)
                System.out.println("Dung");
            else
                System.out.println("Sai!!");
            j++;
            }

    }
    /**
     * ghi đè toString
     * @return 
     */
    @Override
    public String toString() {
        String str = super.toString() + "\n";
        for(int e = 0,i = 0; i <= 4; i++){
            str += "Cau " + ++e + ": " + this.conversationChoices[i].getContent() +"\n";
            for(int k = 65,j = 0; j < 4; j++, k++){
                str += "\t" +(char)k +"."+ 
                        this.conversationChoices[i].getChoices()[j].getContent() 
                        +"\n";
            }            
        }
        return str;
               
    }
    /**
     * @return the conversationChoices
     */
    public MultipleChoice[] getConversationChoices() {
        return conversationChoices;
    }

    /**
     * @param conversationChoices the conversationChoices to set
     */
    public void setConversationChoices(MultipleChoice[] conversationChoices) {
        this.conversationChoices = conversationChoices;
    }
    
    
}
