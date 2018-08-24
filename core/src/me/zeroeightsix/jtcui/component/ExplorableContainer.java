package me.zeroeightsix.jtcui.component;

import me.zeroeightsix.jtcui.Fat;
import me.zeroeightsix.jtcui.Space;

/**
 * @author 086
 */
abstract class ExplorableContainer extends BaseContainer {

    ExplorableContainer() {
    }

    ExplorableContainer(int x, int y) {
        super(x, y);
    }

    ExplorableContainer(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public Component explore(double x, double y) {
        Fat fat = getFat();
        Space space = getSpace();
        if (x <= fat.getLeft()
                || y <= fat.getTop()
                || x > space.widthProperty().get() - fat.getRight()
                || y > space.heightProperty().get() - fat.getBottom())
            return this;
        return this.exploreSelf(x, y);
    }

    protected final Component exploreSelf(double x, double y) {
        for (Component child : getChildren()) {
            Space space = child.getSpace();
            double xc = space.xProperty().get();
            double yc = space.yProperty().get();
            double wc = space.widthProperty().get();
            double hc = space.heightProperty().get();
            if (x >= xc
                    && y >= yc
                    && x <= xc + wc
                    && y <= yc + hc)
                return child.explore(x - xc, y - yc);
        }
        return this;
    }

}
