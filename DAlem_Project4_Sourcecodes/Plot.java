//package com.dalem.management;
public class Plot {
    private int x; // X coordinate of the upper left corner
    private int y; // Y coordinate of the upper left corner
    private int width; // Horizontal extent of the plot
    private int depth; // Vertical extent of the plot

    // Default constructor initializes a 1x1 plot at (0,0)
    public Plot() {
        this.x = 0;
        this.y = 0;
        this.width = 1;
        this.depth = 1;
    }

    // Parameterized constructor
    public Plot(int x, int y, int width, int depth) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.depth = depth;
    }

    // Getters
    public int getX() { return x; }
    public int getY() { return y; }
    public int getWidth() { return width; }
    public int getDepth() { return depth; }

    // Setters
    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }
    public void setWidth(int width) { this.width = width; }
    public void setDepth(int depth) { this.depth = depth; }

    // Checks if this plot overlaps with another plot
    public boolean overlaps(Plot p) {
        // Calculate coordinates for the right and bottom edges of both plots
        int thisRight = this.x + this.width;
        int thisBottom = this.y + this.depth;
        int otherRight = p.getX() + p.getWidth();
        int otherBottom = p.getY() + p.getDepth();

        // Check for no overlap (if one plot is completely on one side of the other)
        return !(this.x >= otherRight || p.getX() >= thisRight || this.y >= otherBottom || p.getY() >= thisBottom);
    }

    // Checks if this plot completely encompasses another plot (inclusive of edges)
    public boolean encompasses(Plot p) {
        // Calculate coordinates for the right and bottom edges of both plots
        int thisRight = this.x + this.width;
        int thisBottom = this.y + this.depth;
        int otherRight = p.getX() + p.getWidth();
        int otherBottom = p.getY() + p.getDepth();

        // Check if this plot fully contains the other plot (including edges)
        return this.x <= p.getX() && this.y <= p.getY() && thisRight >= otherRight && thisBottom >= otherBottom;
    }

    // Returns a string representation of the plot in format: [x],[y],[width],[depth]
    @Override
    public String toString() {
        return String.format("[%d],[%d],[%d],[%d]", x, y, width, depth);
    }
}
