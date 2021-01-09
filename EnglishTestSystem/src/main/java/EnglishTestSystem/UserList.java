package EnglishTestSystem;

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
    public User find (String name){
        for(User u: this.users){
            if(name.compareTo(u.getName()) == 0)
                return u;
        }
        return null;
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
