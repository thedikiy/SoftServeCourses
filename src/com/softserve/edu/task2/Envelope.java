package com.softserve.edu.task2;

/**
 * Created by TDK on 30.05.2017.
 */
public class Envelope {
    private double width;
    private double height;

    /**
     * Creates an envelope object with:
     *
     * @param width
     * @param height
     */
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

    /**
     * Compares this. envelope with input one
     *
     * @param envelope
     * @return <code> 1 </code> if this. envelope is bigger
     * <code> -1 </code> if this. envelope is smaller
     * <code> 0 </code> other case
     */
    public int compare(Envelope envelope) {
        if (envelope == null)
            throw new IllegalArgumentException("Object can't be null");
        if (this.getWidth() > envelope.getWidth()
                && this.getHeight() > envelope.getHeight())
            return 1;
        if (this.getWidth() < envelope.getWidth()
                && this.getHeight() < envelope.getHeight())
            return -1;
        return 0;
    }
}
