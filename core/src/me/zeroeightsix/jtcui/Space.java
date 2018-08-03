package me.zeroeightsix.jtcui;

import javafx.beans.property.SimpleDoubleProperty;
import me.zeroeightsix.jtcui.component.Component;
import me.zeroeightsix.jtcui.layout.layouts.AbstractLayout;

import java.util.Optional;

/**
 * @author 086
 */
public class Space {

    final Component parent;

    private SimpleDoubleProperty x = new SimpleDoubleProperty(this, "x", 0);
    private SimpleDoubleProperty y = new SimpleDoubleProperty(this, "y", 0);
    private SimpleDoubleProperty width = new SimpleDoubleProperty(this, "width", 0);
    private SimpleDoubleProperty height = new SimpleDoubleProperty(this, "height", 0);

    public Space(Component parent, double x, double y, double width, double height) {
        this.parent = parent;
        this.x.set(x);
        this.y.set(y);
        this.width.set(width);
        this.height.set(height);
    }

    public Space withAdded(double x, double y, double width, double height) {
        return new Space(parent, xProperty().get() + x, yProperty().get() + y, widthProperty().get() + width, heightProperty().get() + height);
    }

    public Space withoutFat(Fat fat) {
        return withAdded(fat.getLeft(), fat.getTop(), -(fat.getRight() + fat.getLeft()), -(fat.getBottom() + fat.getTop()));
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

    @Override
    public String toString() {
        return String.format("Space[x=%f, y=%f, width=%f, height=%f]", xProperty().get(), yProperty().get(), widthProperty().get(), heightProperty().get());
    }

    private class SimpleUpdatingDoubleProperty extends SimpleDoubleProperty {
        @Override
        protected void invalidated() {
            super.invalidated();
            Optional.ofNullable(parent.getParent()).ifPresent(parent2 -> Optional.of(parent2.getLayout()).ifPresent(layout -> layout.update(parent2)));
        }
    }

}
