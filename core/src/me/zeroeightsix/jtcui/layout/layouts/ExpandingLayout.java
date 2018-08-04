package me.zeroeightsix.jtcui.layout.layouts;

import me.zeroeightsix.jtcui.Space;
import me.zeroeightsix.jtcui.component.Component;

import java.util.Optional;

/**
 * @author 086
 */
public abstract class ExpandingLayout extends AbstractLayout {
    public void expand(Component component) {
        Optional.ofNullable(component.getParent()).ifPresent(parent -> {
            Space space = getSlimSpace(parent);
            component.getSpace().xProperty().set(space.xProperty().get());
            component.getSpace().yProperty().set(space.yProperty().get());
            component.getSpace().widthProperty().set(space.widthProperty().get());
            component.getSpace().heightProperty().set(space.heightProperty().get());
        });
    }

    @Override
    public void update(Component component) {
        expand(component);
        organise(component);
    }
}
