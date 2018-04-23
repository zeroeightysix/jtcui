package me.zeroeightsix.jtcui.layout;

/**
 * Created by 086 on 23/04/2018.
 */
public enum Alignment {
    LEFT(false,true),
    RIGHT(false,true),
    CENTER(true,true),
    TOP(true,false),
    BOTTOM(true,false);

    boolean isVertical;
    boolean isHorizontal;

    Alignment(boolean isVertical, boolean isHorizontal) {
        this.isVertical = isVertical;
        this.isHorizontal = isHorizontal;
    }

    public boolean isHorizontal() {
        return isHorizontal;
    }

    public boolean isVertical() {
        return isVertical;
    }
}
