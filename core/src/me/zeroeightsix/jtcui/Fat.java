package me.zeroeightsix.jtcui;

/**
 * A class to describe the size of a containers borders
 *
 * @author 086
 */
public class Fat {

    /**
     * A constant value used when all borders are 0 in size
     */
    public static final Fat NO_FAT = new Fat(0, 0, 0, 0);

    /**
     * The width of the left border
     */
    private final int left;

    /**
     * The width of the right border
     */
    private final int right;

    /**
     * The height of the top border
     */
    private final int top;

    /**
     * The height of the bottom border
     */
    private final int bottom;

    public Fat(int left, int right, int top, int bottom) {
        this.left = left;
        this.right = right;
        this.top = top;
        this.bottom = bottom;
    }

    /**
     * @return The width of the left border
     */
    public int getLeft() {
        return left;
    }

    /**
     * @return The height of the bottom border
     */
    public int getBottom() {
        return bottom;
    }

    /**
     * @return The width of the right border
     */
    public int getRight() {
        return right;
    }

    /**
     * @return The height of the top border
     */
    public int getTop() {
        return top;
    }

    @Override
    public String toString() {
        return String.format("Fat[left=%d, right=%d, top=%d, bottom=%d]", getLeft(), getRight(), getTop(), getBottom());
    }

}
