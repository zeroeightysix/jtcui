package me.zeroeightsix.jtcui.layout.layouts;

import me.zeroeightsix.jtcui.Space;
import me.zeroeightsix.jtcui.component.Component;

import java.util.Optional;

/**
 * A layout that places all of its components at the component's origin, including its fat
 */
public class OriginLayout extends SelfSizingLayout {

    public OriginLayout(Type type) {
        super(type);
    }

    @Override
    public void organise(Component component) {
        Optional.ofNullable(component.getChildren()).ifPresent(components -> {
            Space slim = getSlimSpace(component);
            final double x = slim.xProperty().get() - component.getSpace().xProperty().get();
            final double y = slim.yProperty().get() - component.getSpace().yProperty().get();

            components.forEach(child -> {
                child.getSpace().xProperty().set(x);
                child.getSpace().yProperty().set(y);
            });
        });
    }

}
