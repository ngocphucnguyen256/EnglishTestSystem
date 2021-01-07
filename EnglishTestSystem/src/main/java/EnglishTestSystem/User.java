/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EnglishTestSystem;

import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author ACER
 */
public class User {
    private String name;
    private String homeTown;
    private String gender;
    private Date dateOfBirth;
    private Date dateStart=new Date(System.currentTimeMillis());;
    private List<Double> point= new ArrayList<>();
    private Double averagePoint;
    {

        setAveragePoint((Double) getPoint().stream().mapToDouble(a->a).average().orElse(0));

    }
    public User(String name, String gender, String homeTown, Date dateOfBirth, Date dateStart,
            List<Double> point){
        this.name=name;
        this.gender=gender;
        this.homeTown=homeTown;
        this.dateOfBirth=dateOfBirth;
        this.dateStart=dateStart;
        this.point=point;
    }
    public User(String name, String gender, String homeTown, Date dateOfBirth){
        this.name=name;
        this.gender=gender;
        this.homeTown=homeTown;
        this.dateOfBirth=dateOfBirth;
    }
    /**
     * @return the homeTown
     */
    public String getHomeTown() {
        return homeTown;
    }

    /**
     * @param homeTown the homeTown to set
     */
    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    
  

    
   

    @Override
    public String toString() {
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        String str;
        int count=0;
        str="\nTen: "+ this.name +"\nGioi tinh: "+this.gender+"\n Que quan: "
                +this.homeTown +"\n Ngay sinh: "+f.format(this.dateOfBirth.getTime())+
                "\n Ngay bat dau: "+f.format(this.dateStart.getTime())+"\nCac lan lam kiem tra:\n"
                ;
        for(Double d: this.point){
            str+="\tLan "+ ++count +": "+ d+"\n";
        }
        return str+="Diem trung binh: "+this.averagePoint;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the dateOfBirth
     */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * @param dateOfBirth the dateOfBirth to set
     */
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * @return the dateStart
     */
    public Date getDateStart() {
        return dateStart;
    }

    /**
     * @param dateStart the dateStart to set
     */
    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

     public Double getAveragePoint() {
        return getPoint().stream().mapToDouble(a->a).average().orElse(0);
    }

    /**
     * @param averagePoint the averagePoint to set
     */
    public void setAveragePoint(Double averagePoint) {
        this.averagePoint = averagePoint;
    }

    /**
     * @return the point
     */
    public List<Double> getPoint() {
        return point;
    }

    /**
     * @param point the point to set
     */
    public void setPoint(List<Double> point) {
        this.point = point;
    }
    
    
}
