/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package q2043246.phase_1;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author q2043246
 */
public class Activity {

    private final String title;
    private final String description;
    private final double baseCost;
    private String location;
    private LocalDateTime dateTime;
    private String duration;
    private final boolean insurance;
    private final String code;
    private final List<ActivityAddOns> activitiesAddOns;

    public Activity(String title, String code, String description, double baseCost, String location, LocalDateTime dateTime, String duration, boolean insurance) {
        this.title = title;
        this.code = code;
        this.description = description;
        this.baseCost = baseCost;
        this.location = location;
        this.dateTime = dateTime;
        this.duration = duration;
        this.insurance = insurance;
        //List to store any activity add ons to the activity
        this.activitiesAddOns = new ArrayList<>();
    }
 
    //All the getters and setters methods of Activity class
    
    public String getTitle() {
        return title;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public double getBaseCost() {

        return baseCost;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setLocalDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public boolean needsInsurance() {
        return insurance;
    }

    public List<ActivityAddOns> getActivitiesAddOns() {
        return activitiesAddOns;
    }

    public void addActivitiesAddOns(ActivityAddOns activity) {
        activitiesAddOns.add(activity);
    }
}
