/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package q2043246.phase_1;

/**
 *
 * @author q2043246
 */
public class ItineraryAddOns {
    private final String title;
    private final String code;
    private final double baseCost;
    
    public ItineraryAddOns( String title, String code, double baseCost){
        this.title = title;
        this.code = code;
        this.baseCost = baseCost;
    }
    
    //All the getters and setters of Itinerary Add Ons Class
    
    public String getTitle(){
        return title;
    }
    public double getBaseCost(){
        return baseCost;
    }
    public String getCode(){
        return code;
    }
}
