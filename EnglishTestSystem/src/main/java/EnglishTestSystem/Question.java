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
abstract class Question {
    private static int count;
    private int id;
    private String content;
    private int level;
    private int kind;
    {
        id = ++count;
    }

    public Question(String content, int level, int kind) {
        this.content = content;
        this.level = level;
        this.kind = kind;
    }
    
    public String showAnswer(){
        return null;
    }
    public int checkAnswer(String ans){
         return 0;
    }

    @Override
    public String toString() {
        return this.content; //To change body of generated methods, choose Tools | Templates.
    }
    
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
     * @return the level
     */
    public int getLevel() {
        return level;
    }

    /**
     * @param level the level to set
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * @return the kind
     */
    public int getKind() {
        return kind;
    }

    /**
     * @param kind the kind to set
     */
    public void setKind(int kind) {
        this.kind = kind;
    }
    
    
}
