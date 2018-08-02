package me.zeroeightsix.jtcui.layout.layouts;

import me.zeroeightsix.jtcui.component.Component;
import me.zeroeightsix.jtcui.layout.Grow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * @author 086
 */
public class GrowingLayout extends PaddedLayout {

    private static Set<Component> growSet = new HashSet<>();

    public static boolean doesGrow(Component component) {
        return growSet.contains(component);
    }

    public void setGrow(Component component, boolean grow) {
        if (grow)
            growSet.add(component);
        else
            growSet.remove(component);
        Optional.of(component.getParent()).ifPresent(parent -> parent.getLayout().organise(parent));
    }

    @Override
    public void organise(Component component) {
        super.organise(component);
        Optional.of(component.getChildren()).ifPresent(components -> components.stream().filter(GrowingLayout::doesGrow).forEach(child -> {
            child.setX(getPadding().getLeft());
            child.setY(getPadding().getTop());
            child.setWidth(component.getWidth() - getPadding().getLeft() - getPadding().getRight());
            child.setHeight(component.getHeight() - getPadding().getTop() - getPadding().getBottom());
        }));
    }

}
