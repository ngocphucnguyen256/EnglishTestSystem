/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EnglishTestSystem;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author ACER
 */
public class User {
    private String name;
    private String homeTown;
    private String gender;
    private GregorianCalendar dateOfBirth;
    private GregorianCalendar dateStart = new GregorianCalendar();
    private List<Double> point = new ArrayList<>();
    private Double averagePoint;
    {
        averagePoint =  getPoint().stream().mapToDouble(val -> val).average().orElse(0.0);
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
    public List<Double> getPoint() {
        return point;
    }

    /**
     * @param point the point to set
     */
    public void setPoint(List<Double> point) {
        this.point = point;
    }

    @Override
    public String toString() {
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        return String.format("Ten: %s\nGioi tinh: %s\nQue quan: %s\n"
                + "Ngay Sinh: %s\nNgay gia nhap: %s\nDiem TB: %.1f\n", this.getName(), this.gender, this.homeTown, 
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
    public GregorianCalendar getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * @param dateOfBirth the dateOfBirth to set
     */
    public void setDateOfBirth(GregorianCalendar dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * @return the dateStart
     */
    public GregorianCalendar getDateStart() {
        return dateStart;
    }

    /**
     * @param dateStart the dateStart to set
     */
    public void setDateStart(GregorianCalendar dateStart) {
        this.dateStart = dateStart;
    }
    
    
    
}
