package me.zeroeightsix.jtcui;

/**
 * The minimum and maximum dimensions for a component
 *
 * @author 086
 */
public class Requirements {

    private double minimumWidth;
    private double minimumHeight;
    private double maximumWidth;
    private double maximumHeight;

    public Requirements(double minimumWidth, double minimumHeight, double maximumWidth, double maximumHeight) {
        this.minimumWidth = minimumWidth;
        this.minimumHeight = minimumHeight;
        this.maximumWidth = maximumWidth;
        this.maximumHeight = maximumHeight;
    }

    public double getMinimumHeight() {
        return minimumHeight;
    }

    public double getMinimumWidth() {
        return minimumWidth;
    }

    public double getMaximumHeight() {
        return maximumHeight;
    }

    public double getMaximumWidth() {
        return maximumWidth;
    }

    public void setMinimumWidth(double minimumWidth) {
        this.minimumWidth = minimumWidth;
    }

    public void setMinimumHeight(double minimumHeight) {
        this.minimumHeight = minimumHeight;
    }

    public void setMaximumHeight(double maximumHeight) {
        this.maximumHeight = maximumHeight;
    }

    public void setMaximumWidth(double maximumWidth) {
        this.maximumWidth = maximumWidth;
    }

    @Override
    public String toString() {
        return String.format("Requirements[minW=%f, minH=%f, maxW=%f, maxH=%f]", getMinimumWidth(), getMinimumHeight(), getMaximumWidth(), getMaximumHeight());
    }

}
