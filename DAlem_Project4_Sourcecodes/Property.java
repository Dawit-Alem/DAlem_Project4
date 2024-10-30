//package com.dalem.management;
public class Property {
    private String name;    // Property name
    private String city;    // City where the property is located
    private String owner;   // Owner of the property
    private double rentAmount; // Rent amount for the property
    private Plot plot;      // Plot details of the property

    // Default constructor
    public Property() {
        this.name = "";
        this.city = "";
        this.owner = "";
        this.rentAmount = 0;
        this.plot = new Plot();
    }

    // Constructor without plot details
    public Property(String name, String city, double rentAmount, String owner) {
        this.name = name;
        this.city = city;
        this.rentAmount = rentAmount;
        this.owner = owner;
        this.plot = new Plot(); // Default plot
    }

    // Constructor with plot details
    public Property(String name, String city, double rentAmount, String owner, int x, int y, int width, int depth) {
        this.name = name;
        this.city = city;
        this.rentAmount = rentAmount;
        this.owner = owner;
        this.plot = new Plot(x, y, width, depth); // Custom plot
    }

    // Copy constructor
    public Property(Property property) {
        this.name = property.getPropertyName();
        this.city = property.getCity();
        this.rentAmount = property.getRentAmount();
        this.owner = property.getOwner();
        this.plot = new Plot(property.getPlot().getX(), property.getPlot().getY(), property.getPlot().getWidth(), property.getPlot().getDepth());
    }

    // Getters
    public String getCity() { return city; }
    public String getOwner() { return owner; }
    public Plot getPlot() { return plot; }
    public String getPropertyName() { return name; }
    public double getRentAmount() { return rentAmount; }

    // Setters
    public void setCity(String city) { this.city = city; }
    public void setOwner(String owner) { this.owner = owner; }
    public void setPropertyName(String name) { this.name = name; }
    public void setRentAmount(double rentAmount) { this.rentAmount = rentAmount; }

    // Provides a formatted string representation of the property
    @Override
    public String toString() {
        return String.format("%s,%s,%s,%.2f", name, city, owner, rentAmount);
    }
}
