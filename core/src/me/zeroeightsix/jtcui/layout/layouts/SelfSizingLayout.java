package me.zeroeightsix.jtcui.layout.layouts;

import me.zeroeightsix.jtcui.Fat;
import me.zeroeightsix.jtcui.Space;
import me.zeroeightsix.jtcui.component.Component;
import me.zeroeightsix.jtcui.component.Container;

import java.util.Optional;

/**
 * A layout that sizes itself.
 *
 * @author 086
 */
public abstract class SelfSizingLayout extends AbstractLayout {

    final Type type;

    public SelfSizingLayout(Type type) {
        this.type = type;
    }

    public static Space getExpandedSpace(Component component) {
        return Optional.ofNullable(component.getParent()).map(parent -> {
            Space space = getSlimSpace(parent);
            space.xProperty().set(space.xProperty().get() - parent.getSpace().xProperty().get());
            space.yProperty().set(space.yProperty().get() - parent.getSpace().yProperty().get());
            space.widthProperty().set(space.widthProperty().get());
            space.heightProperty().set(space.heightProperty().get());
            return space;
        }).orElse(component.getSpace());
    }

    private void expand(Component component) {
        component.getSpace().adaptTo(getExpandedSpace(component));
    }

    public static Space getPackedSpace(Component component) {
        return Optional.ofNullable(component.getChildren()).map(children -> {
            final double[] w = {0};
            final double[] h = {0};
            children.forEach(child -> {
                Space space = child.getSpace();
                w[0] = Math.max(w[0], Math.abs(space.xProperty().get()) + Math.abs(space.widthProperty().get()));
                h[0] = Math.max(h[0], Math.abs(space.yProperty().get()) + Math.abs(space.heightProperty().get()));
            });
            int fw = 0, fh = 0;
            if (component instanceof Container) {
                Fat fat = ((Container) component).getFat();
                fw = fat.getRight();
                fh = fat.getBottom();
            }
            return component.getSpace().copyNoParent().withSize(w[0] + fw, h[0] + fh);
        }).orElse(component.getSpace());
    }

    private void pack(Component component) {
        component.getSpace().adaptTo(getPackedSpace(component));
    }

    @Override
    public void update(Component component) {
        switch (type) {
            case PACKING:
                organise(component);
                pack(component);
                break;
            case EXPANDING:
                expand(component);
                organise(component);
                break;
            case FIXED: // Fixed layouts do not self-size
                organise(component);
                break;
        }
    }

    public enum Type {
        PACKING, FIXED, EXPANDING
    }

}
