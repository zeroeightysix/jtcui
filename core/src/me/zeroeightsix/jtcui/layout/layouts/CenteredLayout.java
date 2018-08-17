package me.zeroeightsix.jtcui.layout.layouts;

import me.zeroeightsix.jtcui.Space;
import me.zeroeightsix.jtcui.component.Component;

import java.util.Optional;

/**
 * @author 086
 */
public class CenteredLayout extends SelfSizingLayout {
    public CenteredLayout(Type type) {
        super(type);
    }

    @Override
    public void organise(Component component) {
        Optional.ofNullable(component.getChildren()).ifPresent(components -> {
            Space space = getSlimSpace(component);
            double centerX = space.xProperty().get() + (space.widthProperty().get() / 2) - component.getSpace().xProperty().get();
            double centerY = space.yProperty().get() + (space.heightProperty().get() / 2) - component.getSpace().yProperty().get();
            components.forEach(child -> {
                child.getSpace().xProperty().set(centerX - (child.getSpace().widthProperty().get() / 2));
                child.getSpace().yProperty().set(centerY - (child.getSpace().heightProperty().get() / 2));
            });
        });
    }
}
