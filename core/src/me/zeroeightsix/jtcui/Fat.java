package me.zeroeightsix.jtcui;

/**
 * @author 086
 */
public class Fat {

    public static final Fat NO_FAT = new Fat(0,0,0,0);

    private final int left;
    private final int right;
    private final int top;
    private final int bottom;

    public Fat(int left, int right, int top, int bottom) {
        this.left = left;
        this.right = right;
        this.top = top;
        this.bottom = bottom;
    }

    public int getLeft() {
        return left;
    }

    public int getBottom() {
        return bottom;
    }

    public int getRight() {
        return right;
    }

    public int getTop() {
        return top;
    }

    @Override
    public String toString() {
        return String.format("Fat[left=%d, right=%d, top=%d, bottom=%d]", getLeft(), getRight(), getTop(), getBottom());
    }

}
