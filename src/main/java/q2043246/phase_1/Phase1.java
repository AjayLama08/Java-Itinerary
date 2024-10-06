/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package q2043246.phase_1;

import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author q2043246
 */
public class Phase1 {

    public static void main(String[] args) {
        //Different activity objects are created
        Activity hikingActivity = new Activity("Hiking", "HIK-01", "Hike for health", 14.50, "Roseberry Top", LocalDateTime.now(), "3 hours", false);
        Activity boatingActivity = new Activity("Boating", "BOA-02", "Explore the beauty of the North Sea on a boat", 15.00, "North Sea", LocalDateTime.now(), "2 hours", true);
        Activity artActivity = new Activity("Art Class", "ART-03", "Learn the basics of how to art", 11.50, "Middlesbrough Art House", LocalDateTime.now(), "1 hour", false);

        //Different activity add ons objects are created
        ActivityAddOns insuranceAddOn = new ActivityAddOns("Insurance", "INR", 15.00);
        ActivityAddOns photographyAddOn = new ActivityAddOns("Photography", "PTG", 8.00);

        //photographyAddOn is added to the hiking activity
        hikingActivity.addActivitiesAddOns(photographyAddOn);

        //An itinerary is created
        Itinerary itinerary = new Itinerary("123", "AJAY", 5, 6, 10.5, 6.5);

        //hikingActivity is added to the itinerary
        itinerary.addActivity(hikingActivity);

        //Different itinerary add ons object are created
        ItineraryAddOns accomodationAddOn = new ItineraryAddOns("Accommodation", "ACM", 20.00);
        ItineraryAddOns lunchAddOn = new ItineraryAddOns("Lunch", "LUN", 10.00);

        //lunchAddOn is added to the itinerary
        itinerary.addItineraryAddOns(lunchAddOn);

        //For hiking activity,
        //To get the title,
        System.out.println(hikingActivity.getTitle());
        //To get the code,
        System.out.println(hikingActivity.getCode());
        //To get the description,
        System.out.println(hikingActivity.getDescription());
        //To get the baseCost,
        System.out.println(hikingActivity.getBaseCost());
        //To get the location,
        System.out.println(hikingActivity.getLocation());
        //To set the location,
        hikingActivity.setLocation("Your desired location");
        //To get the dateTime,
        System.out.println(hikingActivity.getDateTime());
        //To set the dateTime,
        hikingActivity.setLocalDateTime(LocalDateTime.MIN);
        //To get the duration,
        System.out.println(hikingActivity.getDuration());
        //To set the duration,
        hikingActivity.setDuration("Your desired duration");

        //For the ItineraryAddOns dinnerAddOns,
        //To get the title,
        System.out.println(lunchAddOn.getTitle());
        //To get the code,
        System.out.println(lunchAddOn.getCode());
        //To get the baseCost,
        System.out.println(lunchAddOn.getBaseCost());

        //For the ActivityAddOns insuranceAddOn,
        //To get the title,
        System.out.println(insuranceAddOn.getTitle());
        //To get the code,
        System.out.println(insuranceAddOn.getCode());
        //To get the baseCost, 
        System.out.println(insuranceAddOn.getBaseCost());

        //A list is created to store Activity object added to the itinerary.
        List<Activity> activitiesList = itinerary.getActivities();
        //For loop iterates over every activity in activitiesList and prints out its title.
        for (Activity activity : activitiesList) {
            System.out.println("Activities: " + (activity.getTitle()));
        }

        //A list is created to store Activity add ons object added to the hikingActivity.
        List<ActivityAddOns> activityAddOnsList = hikingActivity.getActivitiesAddOns();
        //For loop iterates over every activity add ons in activityAddOnsList and prints out its title.
        for (ActivityAddOns activityAddOns : activityAddOnsList) {
            System.out.println("Activity add ons: " + activityAddOns.getTitle());
        }

        //A list is created to store itinerary add ons object added to the itinerary
        List<ItineraryAddOns> itineraryAddOnsList = itinerary.getItineraryAddOns();
        //For loop iterates over every itinerary add ons in itineraryAddOnsList and prints out its title.
        for (ItineraryAddOns itineraryAddOns : itineraryAddOnsList) {
            System.out.println("Itinerary Add Ons: " + (itineraryAddOns.getTitle()));
        }

    }
}
