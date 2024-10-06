/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package q2043246.phase_1;

/**
 *
 * @author q2043246
 */
public class ActivityAddOns {
    private final String title;
    private final double baseCost;
    private final String code;
    
    
    public ActivityAddOns( String title, String code, double baseCost){
        this.title = title;
        this.code = code;
        this.baseCost = baseCost;
    }
    
    //All the getters and setters of Activity add ons class
    
    public String getTitle(){
        return title;
    }
    public String getCode(){
        return code;
    }
    public double getBaseCost(){
        return baseCost;
    }
}
