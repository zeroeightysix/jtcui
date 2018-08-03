package me.zeroeightsix.jtcui.layout.layouts;

import me.zeroeightsix.jtcui.Space;
import me.zeroeightsix.jtcui.component.Component;

import java.util.Optional;

/**
 * @author 086
 */
public class CenteredLayout extends ExpandingLayout {
    @Override
    public void organise(Component component) {
        Optional.ofNullable(component.getChildren()).ifPresent(components -> {
            Space space = getSlimSpace(component);
            System.out.println("--");
            System.out.println(component.getSpace());
            System.out.println(space);

            double centerX = space.widthProperty().get() / 2;
            double centerY = space.heightProperty().get() / 2;
            components.forEach(child -> {
                System.out.println(child.getSpace().widthProperty().get());
                child.getSpace().xProperty().set(space.xProperty().get() + centerX - child.getSpace().widthProperty().get() / 2);
                child.getSpace().yProperty().set(space.yProperty().get() + centerY - child.getSpace().heightProperty().get() / 2);
            });
        });
    }
}
