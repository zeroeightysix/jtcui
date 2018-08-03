package me.zeroeightsix.jtcui.layout.layouts;

import me.zeroeightsix.jtcui.Space;
import me.zeroeightsix.jtcui.component.Component;
import me.zeroeightsix.jtcui.layout.Alignment;
import me.zeroeightsix.jtcui.layout.Grow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * @author 086
 */
public class GrowingLayout extends PackingLayout {

    private static Set<Component> growSet = new HashSet<>();
    Alignment alignment = Alignment.TOP_LEFT;

    public static boolean doesGrow(Component component) {
        return growSet.contains(component);
    }

    public Alignment getAlignment() {
        return alignment;
    }

    public void setAlignment(Alignment alignment) {
        this.alignment = alignment;
    }

    public void setGrow(Component component, boolean grow) {
        if (grow)
            growSet.add(component);
        else
            growSet.remove(component);
        Optional.ofNullable(component.getParent()).ifPresent(parent -> parent.getLayout().organise(parent));
    }

    @Override
    public void organise(Component component) {
        Optional.ofNullable(component.getChildren()).ifPresent(components -> {
            Space space = getSlimSpace(component);
            components.stream().forEach(child -> {
                if (doesGrow(child)) {
                    child.getSpace().widthProperty().set(space.widthProperty().get());
                    child.getSpace().heightProperty().set(space.heightProperty().get());
                } else {
                    if (alignment.isLeft()) {
                        child.getSpace().xProperty().set(space.xProperty().get());
                        child.getSpace().yProperty().set(space.yProperty().get());
                    } else {
                        child.getSpace().xProperty().set(space.widthProperty().get() - child.getSpace().widthProperty().get());
                        child.getSpace().yProperty().set(space.heightProperty().get() - child.getSpace().heightProperty().get());
                    }
                }
            });
        });
    }

}
