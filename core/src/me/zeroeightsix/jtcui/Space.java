package me.zeroeightsix.jtcui;

import javafx.beans.property.SimpleDoubleProperty;
import me.zeroeightsix.jtcui.component.Component;
import me.zeroeightsix.jtcui.layout.layouts.AbstractLayout;

/**
 * The location and dimensions of a component
 *
 * @author 086
 */
public class Space {

    final Component parent;

    private final SimpleDoubleProperty x = new SimpleUpdatingDoubleProperty(this, "x", 0);
    private final SimpleDoubleProperty y = new SimpleUpdatingDoubleProperty(this, "y", 0);
    private final SimpleDoubleProperty width = new SimpleUpdatingDoubleProperty(this, "width", 0);
    private final SimpleDoubleProperty height = new SimpleUpdatingDoubleProperty(this, "height", 0);

    public Space(Component parent, double x, double y, double width, double height) {
        this.parent = parent;
        this.x.set(x);
        this.y.set(y);
        this.width.set(width);
        this.height.set(height);
    }

    public Space withAdded(double x, double y, double width, double height) {
        return new Space(null, xProperty().get() + x, yProperty().get() + y, widthProperty().get() + width, heightProperty().get() + height);
    }

    public Space withoutFat(Fat fat) {
        return withAdded(fat.getLeft(), fat.getTop(), -(fat.getRight() + fat.getLeft()), -(fat.getBottom() + fat.getTop()));
    }

    public Space withWidth(double newWidth) {
        return new Space(null, xProperty().get(), yProperty().get(), newWidth, heightProperty().get());
    }

    public Space withHeight(double newHeight) {
        return new Space(null, xProperty().get(), yProperty().get(), widthProperty().get(), newHeight);
    }

    public Space withSize(double width, double height) {
        return new Space(null, xProperty().get(), yProperty().get(), width, height);
    }

    public Space withoutFat() {
        return withoutFat(AbstractLayout.getFat(parent));
    }

    public SimpleDoubleProperty xProperty() {
        return x;
    }

    public SimpleDoubleProperty yProperty() {
        return y;
    }

    public SimpleDoubleProperty widthProperty() {
        return width;
    }

    public SimpleDoubleProperty heightProperty() {
        return height;
    }

    public boolean isPointInside(Point point) {
        return isPointInside(point.getX(), point.getY());
    }

    public boolean isPointInside(double x, double y) {
        return x >= xProperty().get() && x <= xProperty().get() + widthProperty().get() && y >= yProperty().get() && y <= yProperty().get() + heightProperty().get();
    }

    /**
     * @param otherSpace space to compare to
     * @return true if this space fully encapsulates otherSpace
     */
    public boolean encapsulates(Space otherSpace) {
        return xProperty().get() <= otherSpace.xProperty().get()
                && yProperty().get() <= otherSpace.yProperty().get()
                && xProperty().get() + widthProperty().get() >= otherSpace.xProperty().get() + otherSpace.widthProperty().get()
                && yProperty().get() + heightProperty().get() >= otherSpace.yProperty().get() + otherSpace.heightProperty().get();
    }

    /**
     * @param otherSpace space to compare to
     * @return true if both spaces are equal
     */
    public boolean equals(Space otherSpace) {
        return xProperty().get() == otherSpace.xProperty().get()
                && yProperty().get() == otherSpace.yProperty().get()
                && widthProperty().get() == otherSpace.widthProperty().get()
                && heightProperty().get() == otherSpace.heightProperty().get();
    }

    /**
     * @param otherSpace space to compare to
     * @return true if otherSpace fully encapsulates this space
     */
    public boolean isInside(Space otherSpace) {
        return otherSpace.encapsulates(this);
    }

    @Override
    public String toString() {
        return String.format("Space[x=%f, y=%f, width=%f, height=%f]", xProperty().get(), yProperty().get(), widthProperty().get(), heightProperty().get());
    }

    public void adaptTo(Space otherSpace) {
        xProperty().set(otherSpace.xProperty().getValue());
        yProperty().set(otherSpace.yProperty().getValue());
        widthProperty().set(otherSpace.widthProperty().getValue());
        heightProperty().set(otherSpace.heightProperty().getValue());
    }

    public Space copyNoParent() {
        return new Space(parent, xProperty().get(), yProperty().get(), widthProperty().get(), heightProperty().get());
    }

    private class SimpleUpdatingDoubleProperty extends SimpleDoubleProperty {
        public SimpleUpdatingDoubleProperty(Object bean, String name, double initialValue) {
            super(bean, name, initialValue);
        }

        @Override
        protected void invalidated() {
            super.invalidated();
            if (parent != null)
                JTC.update(JTC.getRootParent(parent));
        }
    }

}
