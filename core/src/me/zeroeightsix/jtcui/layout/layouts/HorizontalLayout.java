package me.zeroeightsix.jtcui.layout.layouts;

import me.zeroeightsix.jtcui.Space;
import me.zeroeightsix.jtcui.component.Component;
import me.zeroeightsix.jtcui.layout.Alignment;
import me.zeroeightsix.jtcui.layout.Grow;

import java.util.HashMap;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author 086
 */
public class HorizontalLayout extends AlignedSpacedLayout {

    private static final HashMap<Component, Grow> growMap = new HashMap<>();

    public HorizontalLayout(Type type) {
        super(type);
    }

    @Override
    public void organise(Component component) {
        Optional.ofNullable(component.getChildren()).ifPresent(components -> {
            Space workspace = getSlimSpace(component);
            Alignment alignment = getAlignment();

            final double x = workspace.xProperty().get() - component.getSpace().xProperty().get();
            final double y = workspace.yProperty().get() - component.getSpace().yProperty().get();
            final double width = workspace.widthProperty().get();
            final double height = workspace.heightProperty().get();

            AtomicReference<Double> placeX = new AtomicReference<>(alignment.isLeft() ? x : (alignment.isRight() ? x + width : 0));

            final int multiplier = alignment.isRight() ? -1 : 1;

            components.forEach(child -> {
                Optional.ofNullable(growMap.get(child)).ifPresent(grow -> child.getSpace().heightProperty().set(height * grow.getModifier()));
                if (alignment.isTop())
                    child.getSpace().yProperty().set(y);
                else if (alignment.isRight())
                    child.getSpace().yProperty().set(y + height - child.getSpace().heightProperty().get());
                else
                    child.getSpace().yProperty().set(y + (height / 2d) - (child.getSpace().heightProperty().get() / 2d));

                if (!alignment.isCenterHorizontal())
                    child.getSpace().xProperty().set(placeX.get());
                placeX.updateAndGet(v -> multiplier * (v + child.getSpace().widthProperty().get() + getSpacing()));
            });

            if (alignment.isCenterHorizontal()) {
                // placeY is now the total height of our children combined, let's place them, centered now
                double posX = x + width / 2d - placeX.get();
                for (Component child : components) {
                    child.getSpace().yProperty().set(posX);
                    posX += child.getSpace().widthProperty().get() + getSpacing();
                }
            }
        });
    }

    public static void setGrow(Component component, Grow grow) {
        growMap.put(component, grow);
    }

}
