package me.zeroeightsix.jtcui;

/**
 * @author 086
 */
public class Requirements {

    private int minimumWidth;
    private int minimumHeight;
    private int maximumWidth;
    private int maximumHeight;

    public Requirements(int minimumWidth, int minimumHeight, int maximumWidth, int maximumHeight) {
        this.minimumWidth = minimumWidth;
        this.minimumHeight = minimumHeight;
        this.maximumWidth = maximumWidth;
        this.maximumHeight = maximumHeight;
    }

    public int getMinimumHeight() {
        return minimumHeight;
    }

    public int getMinimumWidth() {
        return minimumWidth;
    }

    public int getMaximumHeight() {
        return maximumHeight;
    }

    public int getMaximumWidth() {
        return maximumWidth;
    }

    public void setMinimumWidth(int minimumWidth) {
        this.minimumWidth = minimumWidth;
    }

    public void setMinimumHeight(int minimumHeight) {
        this.minimumHeight = minimumHeight;
    }

    public void setMaximumHeight(int maximumHeight) {
        this.maximumHeight = maximumHeight;
    }

    public void setMaximumWidth(int maximumWidth) {
        this.maximumWidth = maximumWidth;
    }

    @Override
    public String toString() {
        return String.format("Requirements[minW=%d, minH=%d, maxW=%d, maxH=%d]", getMinimumWidth(), getMinimumHeight(), getMaximumWidth(), getMaximumHeight());
    }

}
