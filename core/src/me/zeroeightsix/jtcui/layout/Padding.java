package me.zeroeightsix.jtcui.layout;

/**
 * Created by 086 on 23/04/2018.
 */
public class Padding {

    public static final Padding NO_PADDING = new Padding(0, 0, 0, 0);

    private int left, top, right, bottom;

    public Padding(int left, int top, int right, int bottom) {
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
    }

    public int getBottom() {
        return bottom;
    }

    public int getLeft() {
        return left;
    }

    public int getRight() {
        return right;
    }

    public int getTop() {
        return top;
    }

}
