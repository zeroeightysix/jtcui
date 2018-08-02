package me.zeroeightsix.jtcui.layout.layouts;

import me.zeroeightsix.jtcui.component.Component;
import me.zeroeightsix.jtcui.component.Container;
import me.zeroeightsix.jtcui.layout.Alignment;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by 086 on 23/04/2018.
 */
public class VBoxLayout extends SpacedLayout {
    private Alignment componentAlignment = Alignment.TOP_LEFT;
    private static Set<Component> fillWidth = new HashSet<>();

    @Override
    public void organise(Component component) {
        Optional.of(component.getChildren()).ifPresent(components -> {
            int fullWidth = component.getWidth() - getPadding().getLeft() - getPadding().getRight();
            int fullHeight = component.getHeight() - getPadding().getTop() - getPadding().getBottom();
            final int finalLeft = getPadding().getLeft();
            if (component instanceof Container) {
                Container container = (Container) component;
                fullWidth -= finalLeft + container.getFatRight() + container.getFatLeft();
                fullHeight -= container.getFatTop() + container.getFatBottom();
            }
            final int finalFullWidth = fullWidth;
            List<Component> toGrow = new ArrayList<>();
            AtomicInteger spaceLeft = new AtomicInteger(fullHeight - components.size() * getSpacing());
            components.forEach(child -> {
                if (doesFillWidth(child)) {
                    child.setWidth(finalFullWidth);
                    child.setX(finalLeft);
                } else
                    align(finalLeft, finalFullWidth, child);
                if (doesGrow(component))
                    toGrow.add(component);
                else
                    spaceLeft.addAndGet(-component.getHeight());
            });
            if (!toGrow.isEmpty()) {
                int per = spaceLeft.get() / toGrow.size();
                toGrow.forEach(child -> child.setHeight(per));
            }
            AtomicInteger y = new AtomicInteger(getPadding().getTop());
            components.forEach(child -> {
                child.setY(y.get());
                y.addAndGet(child.getHeight() + getSpacing());
            });
        });
    }

    private void align(int left, int fullWidth, Component child) {
        if (componentAlignment.isLeft()) child.setX(0);
        else if (componentAlignment.isCenterHorizontal()) child.setX(left + fullWidth / 2 + child.getWidth() / 2);
        else child.setX(left + fullWidth - child.getWidth());
    }

    public static void setFillWidth(Component component, boolean fillWidth) {
        if (fillWidth)
            VBoxLayout.fillWidth.add(component);
        else
            VBoxLayout.fillWidth.remove(component);
        Optional.of(component.getParent()).ifPresent(parent -> parent.getLayout().organise(parent));
    }

    public static boolean doesFillWidth(Component component) {
        return VBoxLayout.fillWidth.contains(component);
    }

}
