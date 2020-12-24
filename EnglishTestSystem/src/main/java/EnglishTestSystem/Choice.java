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
public class Choice {
    private String content;
    private String explaination;

    public Choice(String content, String explaination) {
        this.content = content;
        this.explaination = explaination;
    }

//    @Override
//    public String toString() {
//        return String.format(""); //To change body of generated methods, choose Tools | Templates.
//    }
    

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return the explaination
     */
    public String getExplaination() {
        return explaination;
    }

    /**
     * @param explaination the explaination to set
     */
    public void setExplaination(String explaination) {
        this.explaination = explaination;
    }

    int compareTo(String ans) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
