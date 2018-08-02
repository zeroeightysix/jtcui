package me.zeroeightsix.jtcui.component;

/**
 * @author 086
 */
abstract class ExplorableContainer extends SlimContainer {

    public ExplorableContainer() {
    }

    public ExplorableContainer(int x, int y) {
        super(x, y);
    }

    public ExplorableContainer(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public Component explore(int x, int y) {
        if (x <= getFatLeft() || y <= getFatTop() || x > getWidth()-getFatRight() || y > getHeight()-getFatBottom()) return this;
        return this.exploreSelf(x - getFatLeft(), y - getFatTop());
    }

    protected final Component exploreSelf(int x, int y) {
        for (Component child : getChildren()) {
            int xc = child.getX();
            int yc = child.getY();
            int wc = child.getWidth();
            int hc = child.getHeight();
            if (x >= xc
                    && y >= yc
                    && x <= xc + wc
                    && y <= yc + hc)
                return child.explore(x - xc, y - yc);
        }
        return this;
    }

}
