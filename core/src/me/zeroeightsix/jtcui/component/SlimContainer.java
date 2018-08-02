package me.zeroeightsix.jtcui.component;

/**
 * @author 086
 */
abstract class SlimContainer extends SimpleComponent implements Container {

    public SlimContainer() {}

    public SlimContainer(int x, int y) {
        super(x, y);
    }

    public SlimContainer(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public int getFatBottom() {
        return 0;
    }

    @Override
    public int getFatLeft() {
        return 0;
    }

    @Override
    public int getFatRight() {
        return 0;
    }

    @Override
    public int getFatTop() {
        return 0;
    }
}
