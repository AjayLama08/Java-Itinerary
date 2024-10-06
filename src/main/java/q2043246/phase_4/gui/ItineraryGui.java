/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package q2043246.phase_4.gui;

/**
 *
 * @author lamaj
 */
public class ItineraryGui {
    private String leadAttendee;
    private int totalAttendees;
    private int totalActivities;
    private double totalCost;
    
    public ItineraryGui(String leadAttendee, int totalAttendees, int totalActivities, int totalCost){
        this.leadAttendee = leadAttendee;
        this.totalAttendees = totalAttendees;
        this.totalActivities = totalActivities;
        this.totalCost = totalCost;
    }
    
    //All the getters and setters for ItineraryGui class.
    
    public String getLeadAttendee(){
        return leadAttendee;
    }
    public int getTotalAttendees(){
        return totalAttendees;
    }
    public int getTotalActivities(){
        return totalActivities;
    }
    public double getTotalCost(){
        return totalCost;
    }
}
