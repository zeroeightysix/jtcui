package me.zeroeightsix.jtcui.component;

/**
 * A component with a border, where its children aren't supposed to be. Something like a window.
 * @author 086
 */
public class BorderedContainer extends SimpleContainer {

    private final int top;
    private final int left;
    private final int right;
    private final int bottom;

    public BorderedContainer(int top, int left, int right, int bottom) {
        this.top = top;
        this.left = left;
        this.right = right;
        this.bottom = bottom;
    }

    public BorderedContainer(int x, int y, int width, int height, int left, int top, int right, int bottom) {
        super(x, y, width, height);
        this.top = top;
        this.left = left;
        this.right = right;
        this.bottom = bottom;
    }

    @Override
    public int getFatTop() {
        return top;
    }

    @Override
    public int getFatRight() {
        return right;
    }

    @Override
    public int getFatLeft() {
        return left;
    }

    @Override
    public int getFatBottom() {
        return bottom;
    }

}
