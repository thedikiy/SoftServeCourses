package com.softserve.edu.task2;

/**
 * Created by TDK on 30.05.2017.
 */
public class Envelope {
    private double width;
    private double height;

    public Envelope(double width, double height) {
        if (width < 0 || height < 0 || Double.compare(width, 0) == 0
                || Double.compare(height, 0) == 0)
            throw new IllegalArgumentException("Value must be more than zero");
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public int compare(Envelope envelope) {
        if (envelope == null)
            throw new IllegalArgumentException("Object can't be null");
        if (this.getWidth() > envelope.getWidth() && this.getHeight() > envelope
                .getHeight())
            return 1;
        if (this.getWidth() < envelope.getWidth() && this.getHeight() < envelope
                .getHeight())
            return -1;
        return 0;
    }
}
