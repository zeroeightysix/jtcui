package me.zeroeightsix.jtcui.layout.layouts;

import me.zeroeightsix.jtcui.component.Component;

import java.util.Optional;

/**
 * @author 086
 */
public class CenteredLayout extends PaddedLayout {

    @Override
    public void organise(Component component) {
        Optional.of(component.getChildren()).ifPresent(components -> {
            int centerX = getPadding().getLeft() + (component.getWidth() - getPadding().getLeft() - getPadding().getRight()) / 2;
            int centerY = getPadding().getTop() + (component.getHeight() - getPadding().getTop() - getPadding().getBottom()) / 2;
            components.forEach(child -> {
                child.setX(centerX - child.getWidth() / 2);
                child.setY(centerY - child.getHeight() / 2);
            });
        });
    }
}
