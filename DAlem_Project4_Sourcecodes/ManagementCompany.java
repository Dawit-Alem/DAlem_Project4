//package com.dalem.management;
public class ManagementCompany {
    private static final int MAX_PROPERTY = 5; // Max number of properties
    private static final int MGMT_WIDTH = 10;  // Width of the management company's plot
    private static final int MGMT_DEPTH = 10;  // Depth of the management company's plot

    private String name; // Name of the management company
    private String taxId; // Tax ID of the management company
    private double managementFee; // Management fee percentage
    private Plot plot; // The plot of the management company
    private Property[] properties; // Array to store properties managed by the company
    private int numberOfProperties; // Tracks the current number of properties

    // Default constructor
    public ManagementCompany() {
        this.name = "";
        this.taxId = "";
        this.managementFee = 0.0;
        this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
        this.properties = new Property[MAX_PROPERTY];
        this.numberOfProperties = 0;
    }

    // Constructor with name, tax ID, and management fee
    public ManagementCompany(String name, String taxId, double managementFee) {
        this.name = name;
        this.taxId = taxId;
        this.managementFee = managementFee;
        this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
        this.properties = new Property[MAX_PROPERTY];
        this.numberOfProperties = 0;
    }

    // Constructor with name, tax ID, management fee, and custom plot dimensions
    public ManagementCompany(String name, String taxId, double managementFee, int x, int y, int width, int depth) {
        this.name = name;
        this.taxId = taxId;
        this.managementFee = managementFee;
        this.plot = new Plot(x, y, width, depth);
        this.properties = new Property[MAX_PROPERTY];
        this.numberOfProperties = 0;
    }

    // Getter and Setter methods
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getTaxId() { return taxId; }
    public void setTaxId(String taxId) { this.taxId = taxId; }

    public double getManagementFee() { return managementFee; }
    public void setManagementFee(double managementFee) { this.managementFee = managementFee; }

    public Plot getPlot() { return plot; }

    public int getMAX_PROPERTY() { return MAX_PROPERTY; }

    // Add property methods
    public int addProperty(Property property) {
        if (property == null) return -2;
        if (numberOfProperties >= MAX_PROPERTY) return -1;
        if (!plot.encompasses(property.getPlot())) return -3;

        for (int i = 0; i < numberOfProperties; i++) {
            if (properties[i].getPlot().overlaps(property.getPlot())) return -4;
        }

        properties[numberOfProperties] = new Property(property);
        return numberOfProperties++;
    }

    public int addProperty(String name, String city, double rent, String owner) {
        return addProperty(new Property(name, city, rent, owner));
    }

    public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
        return addProperty(new Property(name, city, rent, owner, x, y, width, depth));
    }

    // Method to calculate the total rent of all properties
    public double getTotalRent() {
        double totalRent = 0;
        for (int i = 0; i < numberOfProperties; i++) {
            totalRent += properties[i].getRentAmount();
        }
        return totalRent;
    }

    // Method to get the property with the highest rent
    public Property getHighestRentProperty() {
        if (numberOfProperties == 0) return null;

        Property highestRentProperty = properties[0];
        for (int i = 1; i < numberOfProperties; i++) {
            if (properties[i].getRentAmount() > highestRentProperty.getRentAmount()) {
                highestRentProperty = properties[i];
            }
        }
        return highestRentProperty;
    }

    // Method to remove the last property in the array
    public void removeLastProperty() {
        if (numberOfProperties > 0) {
            properties[--numberOfProperties] = null;
        }
    }

    // Check if properties array is full
    public boolean isPropertiesFull() {
        return numberOfProperties >= MAX_PROPERTY;
    }

    // Get the number of properties
    public int getPropertiesCount() {
        return numberOfProperties;
    }

    // Check if management fee is valid (0-100)
    public boolean isManagementFeeValid() {
        return managementFee >= 0 && managementFee <= 100;
    }

    // Override toString to display properties and total management fee
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("List of the properties for ").append(name).append(", taxID: ").append(taxId);
        result.append("\n______________________________________________________\n");

        for (int i = 0; i < numberOfProperties; i++) {
            result.append(properties[i]).append("\n");
        }

        result.append("______________________________________________________\n");
        double totalFee = getTotalRent() * (managementFee / 100);
        result.append(" total management Fee: ").append(totalFee);

        return result.toString();
    }

}