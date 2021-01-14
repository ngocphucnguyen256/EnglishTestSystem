package EnglishTestSystem;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserList {
    private List<User> users = new ArrayList<>();
    public void addUser (User u){
        this.users.add(u);
    }
    public void removeUser (User u){
        this.users.remove(u);
    }
    /**
     * tim kiem theo ten
     * @param name
     * @return 
     */
    public User find (String name){
        for(User u: this.users){
            if(name.compareTo(u.getName()) == 0)
                return u;
        }
        return null;
    }
    /**
     * tim kiem theo que quan
     * @param home
     * @return 
     */
        public UserList findHome (String home){
            UserList temp = new UserList();
            this.users.stream().filter(u -> (home.compareTo(u.getHomeTown()) == 0)).forEachOrdered(u -> {
                temp.addUser(u);
        });
            return temp;
        }
    /**
     * tim kiem theo gioi tinh
     * @param gender
     * @return 
     */
        public UserList findGenDer (String gender){
                UserList temp = new UserList();
                this.users.stream().filter(u -> (gender.compareTo(u.getGender()) == 0)).forEachOrdered(u -> {
                    temp.addUser(u);
        });
        return temp;
        }
    /**
     * tim kiem theo ngay sinh
     * @param birth
     * @return 
     */   
        public UserList findBirth (Date birth){
            UserList temp = new UserList();
            this.users.stream().filter(u -> (birth == u.getDateOfBirth())).forEachOrdered(u -> {
                temp.addUser(u);
        });
            return temp;
        }
            
    /**
     * update du lieu trong data base jdbc
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public void upDateDB() throws SQLException, ClassNotFoundException{
        int count = 1;
        for(User u : this.users){
            DataBase.openUpDateDataUser(u, count++);
        }
    }
    
    
    @Override
    public String toString() {
        int count=1;
        String str="User list: \n";
        for(User u: this.users){
            str+="STT: " + count++;
            str+=u;
        }
        return str;
    }
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

}
