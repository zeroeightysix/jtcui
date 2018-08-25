package me.zeroeightsix.jtcui.layout;

/**
 * Created by 086 on 23/04/2018.
 */
public enum Alignment {
    TOP_LEFT(true, false, true, false),
    TOP_CENTER(true, false, false, false),
    TOP_RIGHT(true, false, false, true),
    CENTER_LEFT(false, false, true, false),
    CENTER(false, false, false, false),
    CENTER_RIGHT(false, false, false, true),
    BOTTOM_LEFT(false, true, true, false),
    BOTTOM_CENTER(false, true, false, false),
    BOTTOM_RIGHT(false, true, false, true);

    boolean isTop;
    boolean isBottom;
    boolean isLeft;
    boolean isRight;

    Alignment(boolean isTop, boolean isBottom, boolean isLeft, boolean isRight) {
        this.isTop = isTop;
        this.isBottom = isBottom;
        this.isLeft = isLeft;
        this.isRight = isRight;
    }

    public boolean isTop() {
        return isTop;
    }

    public boolean isBottom() {
        return isBottom;
    }

    public boolean isLeft() {
        return isLeft;
    }

    public boolean isRight() {
        return isRight;
    }

    public boolean isCenterVertical() {
        return !(isTop() || isBottom());
    }

    public boolean isCenterHorizontal() {
        return !(isLeft() || isRight());
    }

}
