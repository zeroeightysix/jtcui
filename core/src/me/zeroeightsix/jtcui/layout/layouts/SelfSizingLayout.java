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

    private void expand(Component component) {
        Optional.ofNullable(component.getParent()).ifPresent(parent -> {
            Space space = getSlimSpace(parent);
            component.getSpace().xProperty().set(space.xProperty().get());
            component.getSpace().yProperty().set(space.yProperty().get());
            component.getSpace().widthProperty().set(space.widthProperty().get());
            component.getSpace().heightProperty().set(space.heightProperty().get());
        });
    }

    private void pack(Component component) {
        Optional.ofNullable(component.getChildren()).ifPresent(children -> {
            final double[] w = {0};
            final double[] h = {0};
            children.forEach(child -> {
                Space space = child.getSpace();
                w[0] = Math.max(w[0], Math.abs(space.xProperty().get()) + Math.abs(space.widthProperty().get()));
                h[0] = Math.max(h[0], Math.abs(space.yProperty().get()) + Math.abs(space.heightProperty().get()));
            });
            Space space = component.getSpace();
            int fw = 0, fh = 0;
            if (component instanceof Container) {
                Fat fat = ((Container) component).getFat();
                fw = fat.getRight();
                fh = fat.getBottom();
            }
            space.widthProperty().set(w[0]+fw);
            space.heightProperty().set(h[0]+fh);
        });
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
        }
    }

    public enum Type {
        PACKING, EXPANDING
    }

}
