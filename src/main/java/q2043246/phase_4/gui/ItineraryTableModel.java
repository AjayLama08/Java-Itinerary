/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package q2043246.phase_4.gui;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author lamaj
 */
public class ItineraryTableModel extends AbstractTableModel {

    private static final String[] COLUMN_NAMES = {"Lead Attendee", "Total Attendees", "Total Activities", "Total Cost"};
    private final List<ItineraryGui> itineraries;
    
    public ItineraryTableModel(List<ItineraryGui> itineraries){
        this.itineraries = itineraries;
    }
    
    @Override
    public int getRowCount() {
        return itineraries.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ItineraryGui itineraryGui = itineraries.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return itineraryGui.getLeadAttendee();
            case 1:
                return itineraryGui.getTotalAttendees();
            case 2:
                return itineraryGui.getTotalActivities();
            case 3:
                return itineraryGui.getTotalCost();
        }
        return null;
    }
    public String getColumnName(int columnIndex) {
        return COLUMN_NAMES[columnIndex];
    }

}
