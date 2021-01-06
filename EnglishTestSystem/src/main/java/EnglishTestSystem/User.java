/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EnglishTestSystem;

import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.Arrays;

/**
 *
 * @author ACER
 */
public class User {
    private String name;
    private String homeTown;
    private String gender;
    private Date dateOfBirth;
    private Date dateStart;
    private Double[] point;
    private Double averagePoint;
    {
        averagePoint =  Arrays.stream(point).mapToDouble(Double::intValue)
      .sum();
    }
    public User(String name, String gender, String homeTown, Date dateOfBirth, Date dateStart,
            Double[] point, Double aPoint){
        this.name=name;
        this.gender=gender;
        this.homeTown=homeTown;
        this.dateOfBirth=dateOfBirth;
        this.dateStart=dateStart;
        this.point=point;
        this.averagePoint=aPoint;
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

    
    /**
     * @return the point
     */
    public Double[] getPoint() {
        return point;
    }

     /**
     * @param point the point to set
     */
    public void setPoint(Double[] point) {
        this.point = point;
    }
    
   

    @Override
    public String toString() {
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        return String.format("Ten: %s\nGioi tinh: %s\nQue quan: %s\n"
                + "Ngay Sinh: %s\nNgay gia nhap: %s\nDiem TB: %.1f\n", 
                this.getName(), this.gender, this.homeTown, 
                f.format(this.dateOfBirth.getTime()),
                f.format(this.dateStart.getTime()), this.averagePoint);
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

   
    
    
}
