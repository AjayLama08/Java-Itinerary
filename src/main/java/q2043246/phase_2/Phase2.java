package q2043246.phase_2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import q2043246.phase_1.Activity;
import q2043246.phase_1.ActivityAddOns;
import q2043246.phase_1.Itinerary;
import q2043246.phase_1.ItineraryAddOns;

public class Phase2 {

    public static void main(String[] args) {
        //A scanner is created.
        Scanner input = new Scanner(System.in);
        //An itinerary object is created with createItinerary(input) method.
        Itinerary itinerary = createItinerary(input);
        //A list is created to hold selected activity object.
        List<Activity> selectedActivities = new ArrayList<>();
        //activityAddOnsList is created that can hold a list of lists of ActivityAddOns objects.
        //The outer list (activityAddOnsList) represent all activity add ons, 
        //and each inner list represent the add-ons associated with a specific activity.
        List<List<ActivityAddOns>> activityAddOnsList = new ArrayList<>();
        //A list is created to hold itinerary add ons object.
        List<ItineraryAddOns> itineraryAddOns = new ArrayList<>();

        // A do-while loop is introduced to let the user add another activity
        do {
            //selectActivity method is called where input is read as a string.
            String activityChoice = selectActivity(input);
            //addSelectedActivity is called to let the user add the activity to,
            //selectedActivitiesList and itinerary.
            Activity selectedActivity = addSelectedActivity(activityChoice, itinerary, selectedActivities, activityAddOnsList);
            //addActivityAddOns method is called where input is read an int.
            int activityAddOnsInput = addActivityAddOns(input);
            //processActivityAddOns method is called.
            processActivityAddOns(activityAddOnsInput, activityAddOnsList);
            //additineraryAddOns method is  called where input is read as int.
            int itineraryAddOnsInput = addItineraryAddOns(input);
            createItineraryAddOns(itineraryAddOnsInput, itineraryAddOns);

        } while (addMoreActivities(input));
        //getNumberOfAttendees method is called where input is read as an int.
        int clientNumber = getNumberOfAttendees(input);
        //calculateAndDisplayCost method is called.
        calculateAndDisplayCost(itinerary, selectedActivities, activityAddOnsList, itineraryAddOns, clientNumber);
    }

    //An itinerary is created  in this method.
    private static Itinerary createItinerary(Scanner input) {
        Itinerary itinerary = null;
        while (true) {
            try {
                System.out.println("Please enter your full name:");
                String userName = input.nextLine();
                int spaceIndex = userName.indexOf(" ");
                if (userName.strip().isEmpty()) {
                    System.out.println("\nNull!!! Please try again.\n");
                } else if (spaceIndex <= -1) {
                    System.out.println("\nSurname not recognized. Please use a space between your first and last name.\n");
                } else if (userName.length() > 20) {
                    System.out.println("\nClient name exceeded 20 characters. Please try again.\n");
                } else if (userName.length() <= 20) {
                    itinerary = new Itinerary("", userName, 0, 0, 0, 0);
                    System.out.println("\nHi " + itinerary.getClient() + "!!!");
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("\nInvalid input. Please type your full name.\n");
            }
        }
        return itinerary;
    }

    //Activity menu option is displayed for the user to select activity in this method.
    private static String selectActivity(Scanner input) {
        String activityChoice;
        while (true) {
            System.out.println("\nHere are the list of available activities with their codes.");
            System.out.println("ACTIVITY:  \t  CODE:");
            System.out.println("Hiking\t\t -> HIK-01");
            System.out.println("Boating\t\t -> BOA-02");
            System.out.println("Art Class\t -> ART-03");
            System.out.println("Futsal\t\t -> FUT-04");
            System.out.println("Paragliding\t -> PAR-05");
            System.out.println("Rafting\t\t -> RAF-06");
            System.out.println("Cycling\t\t -> CYC-07");
            System.out.println("Beach Volleyball -> BVO-08");
            System.out.println("\nWhat activity would you like to do?");
            System.out.println("Please type the activity code in same format as example.");
            System.out.println("** Example: ABC-01 **");
            System.out.println("** Must include capital letters and a hyphen '-' **");
            activityChoice = input.nextLine();
            if (isValidActivityCode(activityChoice)) {
                break;
            } else {
                System.out.println("\nInvalid input. Please type the activity code in the same format as shown next to the activity name.");
                System.out.println("**Must use capital letters and a hyphen '-' in between as well. **\n");
            }
        }
        return activityChoice;
    }

    //Activity codes are stored in the list and this method validates the users input with the actual code.
    private static boolean isValidActivityCode(String code) {
        List<String> validCodes = Arrays.asList("HIK-01", "BOA-02", "ART-03", "FUT-04", "PAR-05", "RAF-06", "CYC-07", "BVO-08");
        return validCodes.contains(code);
    }

    //This method creates the activity object based on the user input.
    //The selected activity is also added to the selected activity list and itinerary.
    private static Activity addSelectedActivity(String activityChoice, Itinerary itinerary, List<Activity> selectedActivities, List<List<ActivityAddOns>> activityAddOnsList) {
        Activity selectedActivity = null;

        switch (activityChoice) {
            case "HIK-01":
                selectedActivity = new Activity("Hiking", "HIK-01", "Hike for health", 14.50, "Roseberry Top", LocalDateTime.now(), "3 hours", false);
                break;
            case "BOA-02":
                selectedActivity = new Activity("Boating", "BOA-02", "Explore the beauty of the North Sea on a boat", 15.00, "North Sea", LocalDateTime.now(), "2 hours", true);
                break;
            case "ART-03":
                selectedActivity = new Activity("Art Class", "ART-03", "Learn the basics of how to art", 11.50, "Middlesbrough Art House", LocalDateTime.now(), "1 hour", false);
                break;
            case "FUT-04":
                selectedActivity = new Activity("Futsal", "FUT-04", "Play futsal with your friends", 30.00, "Middlesbrough FUtsal Ground", LocalDateTime.now(), "1 hour", false);
                break;
            case "PAR-05":
                selectedActivity = new Activity("Paragliding", "PAR-05", "Fly among the birds", 40.00, "Eype Village", LocalDateTime.now(), "30 minutes", true);
                break;
            case "RAF-06":
                selectedActivity = new Activity("Rafting", "RAF-06", "Experience what a real adventure feels like", 50.00, "Lake district", LocalDateTime.now(), "30 minutes", true);
                break;
            case "CYC-07":
                selectedActivity = new Activity("Cycling", "CYC-07", "Pollute less, Pedal  more", 15.00, "The Cuckoo Trail, Sussex", LocalDateTime.now(), "3 hour", false);
                break;
            case "BVO-08":
                selectedActivity = new Activity("Beach volleyball", "BVO-08", "Jump like there's no tomorrow.", 10.50, "Redcar Beach", LocalDateTime.now(), "1 hour", false);
                break;
            default:
                System.out.println("\nInvalid input. Please try again.\n");
                break;
        }

        if (selectedActivity != null) {
            System.out.println("\nYou chose " + selectedActivity.getTitle() + "\n");
            itinerary.addActivity(selectedActivity);
            selectedActivities.add(selectedActivity);
        }

        return selectedActivity;
    }

    //This method creates activity add ons object.
    //Activity add ons object are then added to the activity add ons list.
    private static void createActivityAddOn(int activityAddOnsInput, List<ActivityAddOns> activityAddOns) {
        String title;
        double cost;
        String code;
        switch (activityAddOnsInput) {
            case 1:
                title = "Insurance";
                code = "INR";
                cost = 15.00;
                break;
            case 2:
                title = "Photography";
                code = "PTG";
                cost = 8.00;
                break;
            default:
                return;
        }

        activityAddOns.add(new ActivityAddOns(title, code, cost));
    }

    //This method displays the menu to add activity add ons to the activity,
    //and handle the cases for the user input.
    private static int addActivityAddOns(Scanner input) {
        int activityAddOnsInput;
        while (true) {
            try {
                System.out.println("\nHere are the list of available activity add ons.\n1.Insurance\n2. Photography");
                System.out.println("Do you want to add any activity add ons?");
                System.out.println("If yes, press 1 to add Insurance and 2 for Photography.");
                System.out.println("If you don't want any activity add ons, press 0");
                activityAddOnsInput = Integer.parseInt(input.nextLine());
                if (activityAddOnsInput != 1 && activityAddOnsInput != 2 && activityAddOnsInput != 0) {
                    System.out.println("\nError. Please type 1 to add Insurance and 2 for Photography\nOR\nPress 0 if you don't want to add any activity add ons.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("\nInvalid input. Please try again.");
            }
        }
        return activityAddOnsInput;
    }

    //Activity add ons object are then processed based on the user input.
    private static void processActivityAddOns(int activityAddOnsInput, List<List<ActivityAddOns>> activityAddOnsList) {
        switch (activityAddOnsInput) {

            case 1:
            case 2:
                //For input 1 and 2, the activity add ons object are added to list named currentActivittyAddOns.
                List<ActivityAddOns> currentActivityAddOns = new ArrayList<>();
                //The value of currentActivityAddOns is then passed to the createActivityAddOn method.
                createActivityAddOn(activityAddOnsInput, currentActivityAddOns);
                //CurrentActivityAddOns is added to list named activityAddOnsList.
                activityAddOnsList.add(new ArrayList<>(currentActivityAddOns));
                break;
            case 0:
                //In case of no add ons to the activity,
                //A separate list is created to hold empty add ons.
                activityAddOnsList.add(new ArrayList<>());
                break;
            default:
                break;

        }
    }

    //A menu option to add itinerary add ons is displayed with,
    //validations as per the user input.
    private static int addItineraryAddOns(Scanner input) {
        int itineraryAddOnsInput;
        while (true) {
            try {
                System.out.println("\nHere are the list of available itinerary add ons.\n1. Accommodation\n2. Lunch");
                System.out.println("Do you want to add any itinerary add ons?");
                System.out.println("If yes, press 1 to add Accomodation and 2 for Lunch.");
                System.out.println("If you don't want any activity add ons, press 0");
                itineraryAddOnsInput = Integer.parseInt(input.nextLine());
                if (itineraryAddOnsInput != 1 && itineraryAddOnsInput != 2 && itineraryAddOnsInput != 0) {
                    System.out.println("\nError. Please type 1 to add Accommodation and 2 for Lunch\nOR\nPress 0 if you don't want to add any itinerary add ons.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("\nInvalid input. Please try again.");
            }
        }
        return itineraryAddOnsInput;
    }

    //This method creates itinerary add ons object.
    //Activity add ons object are then added to the tinerary add ons list.
    private static void createItineraryAddOns(int itineraryAddOnsInput, List<ItineraryAddOns> itineraryAddOns) {
        String title;
        String code;
        double cost;

        switch (itineraryAddOnsInput) {
            case 1:
                title = "Accomodation";
                code = "ACM";
                cost = 40.00;
                break;
            case 2:
                title = "Lunch";
                code = "LUN";
                cost = 5.00;
                break;
            default:
                return;
        }
        itineraryAddOns.add(new ItineraryAddOns(title, code, cost));
    }

    //A menu to ask the user if he/she wants to any more activity is displayed.
    private static boolean addMoreActivities(Scanner input) {
        int addActivity;
        while (true) {
            try {
                System.out.println("\nDo you want to add any more activities?");
                System.out.println("Please type 1 for Yes OR 2 for No.");
                System.out.println("1. Yes\n2. No");
                addActivity = Integer.parseInt(input.nextLine());
                if (addActivity != 1 && addActivity != 2) {
                    System.out.println("\nError. Please type 1 for Yes OR 2 for No.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("\nPlease enter a valid number.");
            }
        }
        return addActivity == 1;
    }

    //A menu is displayed to allow the user to input the nuber of attendees.
    //The user input is read as an integer.
    private static int getNumberOfAttendees(Scanner input) {
        int clientNumber;
        while (true) {
            try {
                System.out.println("\nHow many attendees are doing the activity?");
                String attendeesNumber = input.nextLine();
                clientNumber = Integer.parseInt(attendeesNumber);
                break;
            } catch (NumberFormatException e) {
                System.out.println("\nInvalid number. Please type a valid number");
            }
        }
        return clientNumber;
    }

    //Total activity cost is calculated.
    private static double calculateActivityCost(List<Activity> selectedActivities, int clientNumber) {
        double activityCost = 0;
        for (Activity activity : selectedActivities) {
            activityCost += activity.getBaseCost() * clientNumber;
        }
        return activityCost;
    }

    //Total activity add ons cost is calculated.
    private static double calculateActivityAddOnsCost(List<ActivityAddOns> activityAddOns, int clientNumber) {
        double activityAddOnsCost = 0;
        for (ActivityAddOns addOn : activityAddOns) {
            activityAddOnsCost += addOn.getBaseCost() * clientNumber;
        }
        return activityAddOnsCost;
    }

    //Total itinerary add ons cost is calculated.
    private static double calculateItineraryAddOnsCost(List<ItineraryAddOns> itineraryAddOns, int clientNumber) {
        double itineraryAddOnsCost = 0;
        for (ItineraryAddOns itAddOns : itineraryAddOns) {
            itineraryAddOnsCost += itAddOns.getBaseCost() * clientNumber;
        }
        return itineraryAddOnsCost;
    }

    //Itinerary add ons are displyed with their title and total cost.
    private static void displayItineraryAddOns(List<ItineraryAddOns> itineraryAddOns, int clientNumber) {
        if (itineraryAddOns.isEmpty()) {
            System.out.println(" ** No itinerary add ons selected **\t\t\t\t\t");
        } else {
            System.out.println(" \nItinerary Add-Ons\t\t\t\t\t\t\t");
        }

        for (ItineraryAddOns itAddOns : itineraryAddOns) {
            System.out.println(" - " + itAddOns.getTitle() + " @ £" + itAddOns.getBaseCost() + " x " + clientNumber
                    + "\t\t\t\t\t\t" + "\n\t\t\t\t\tSub-Total: £ " + (itAddOns.getBaseCost() * clientNumber) + "\t");
        }
    }

    //Activity add ons are displayed with their title and total cost.
    private static void displayActivityAndAddOns(List<Activity> selectedActivities, List<List<ActivityAddOns>> activityAddOnsList, int clientNumber) {
        System.out.println(" \n Activities\t\t\t\t\t\t");
        for (int i = 0; i < selectedActivities.size(); i++) {
            Activity activity = selectedActivities.get(i);
            List<ActivityAddOns> addOnsList = activityAddOnsList.get(i);
            System.out.println(" " + (selectedActivities.indexOf(activity) + 1) + ". " + activity.getTitle()
                    + " @ £" + activity.getBaseCost() + " x " + clientNumber + ("\t\t\t\t\t") + "\n\t\t\t\tSub-Total: £ " + (activity.getBaseCost() * clientNumber) + "\t");

            boolean insuranceAdded = addOnsList.stream().anyMatch(addOn -> addOn.getTitle().equals("Insurance"));
            if (activity.needsInsurance() && !insuranceAdded) {
                System.out.println(" ** Insurance required but not added **\t\t\t\t");
            }

            for (ActivityAddOns addOn : addOnsList) {
                System.out.println(" Add-on: " + addOn.getTitle() + " @ £" + addOn.getBaseCost() + " x " + clientNumber
                        + "\t\t\t\t\t" + "\n\t\t\t\tSub-Total: £ " + (addOn.getBaseCost() * clientNumber) + "\t");

            }
        }
    }

    //Total itinerary cost is calculated.
    // All the itinerary details are displayed.
    private static void calculateAndDisplayCost(Itinerary itinerary, List<Activity> selectedActivities, List<List<ActivityAddOns>> activityAddOnsList, List<ItineraryAddOns> itineraryAddOns, int clientNumber) {
        double activityCost = calculateActivityCost(selectedActivities, clientNumber);
        double activityAddOnsCost = 0;

        for (List<ActivityAddOns> addOnsList : activityAddOnsList) {
            for (ActivityAddOns addOn : addOnsList) {
                activityAddOnsCost += addOn.getBaseCost();
            }
        }
        activityAddOnsCost *= clientNumber;

        double itineraryAddOnsCost = calculateItineraryAddOnsCost(itineraryAddOns, clientNumber);
        double totalCost = (activityCost + activityAddOnsCost + itineraryAddOnsCost);
        itinerary.setAttendeesNumber(clientNumber);

        itinerary.setActivitiesNumberPrint(selectedActivities.size());

        itinerary.setDiscount(selectedActivities.size(), clientNumber);

        itinerary.setDiscountAmount(totalCost);
        itinerary.setCost(totalCost, clientNumber);

        // Display the final cost
        System.out.println("+====================================================================+");
        System.out.println("\t\t\t\t\t\t\t\t");
        System.out.println("\tClient: " + itinerary.getClient() + "\t\t\t\t\tRef: " + itinerary.getReferenceNumber() + "\t");
        System.out.println("\t  Date: " + LocalDate.now() + "\t\t\t\t\t\t");
        System.out.println("    Activities: " + itinerary.getActivitiesNumberPrint() + "\t\t\t\t  Attendees: " + itinerary.getAttendeesNumberPrint() + "\t");
        System.out.println("\t\t\t\t\t\t\t\t\t");
        System.out.println("\t  Cost: £ " + itinerary.getCost() + "\t\t\t\t\t\t\t");
        System.out.println("\t\t\t\t\t\t\t\t\t");
        System.out.println("\t\t\t\tCost Breakdown\t\t\t\t");
        System.out.println("\t\t\t\t\t\t\t\t\t");

        displayItineraryAddOns(itineraryAddOns, clientNumber);
        displayActivityAndAddOns(selectedActivities, activityAddOnsList, clientNumber);

        System.out.println("                                                    ");
        System.out.println(" " + itinerary.getFormattedDiscount() + " Discount                    Sub-Total: £ " + itinerary.getDiscountAmount() + "  ");
        System.out.println("+====================================================================+");
    }
}
