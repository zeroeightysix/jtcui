package me.zeroeightsix.jtcui.layout.layouts;

import me.zeroeightsix.jtcui.Space;
import me.zeroeightsix.jtcui.component.Component;
import me.zeroeightsix.jtcui.layout.Alignment;
import me.zeroeightsix.jtcui.layout.Grow;

import java.util.HashMap;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

/**
 * A self-sizing spaced layout that aligns components vertically.
 *
 * @author 086
 */
public class VerticalLayout extends AlignedSpacedLayout {

    private static final HashMap<Component, Grow> growMap = new HashMap<>();

    public VerticalLayout(Type type) {
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

            AtomicReference<Double> placeY = new AtomicReference<>(alignment.isTop() ? y : 0);

            components.stream().filter(Component::isVisible).forEach(child -> {
                Optional.ofNullable(growMap.get(child)).ifPresent(grow -> child.getSpace().widthProperty().set(width * grow.getModifier()));
                if (alignment.isLeft())
                    child.getSpace().xProperty().set(x);
                else if (alignment.isRight())
                    child.getSpace().xProperty().set(x + width - child.getSpace().widthProperty().get());
                else
                    child.getSpace().xProperty().set(x + (width / 2d) - (child.getSpace().widthProperty().get() / 2d));

                if (alignment.isTop())
                    child.getSpace().yProperty().set(placeY.get());
                placeY.updateAndGet(v -> v + child.getSpace().heightProperty().get() + getSpacing());
            });

            if (alignment.isBottom() || alignment.isCenterVertical()) {
                double posY = y - placeY.get() + (alignment.isBottom() ? height : height / 2d);
                for (Component child : components) {
                    if (!child.isVisible()) continue;
                    child.getSpace().yProperty().set(posY);
                    posY += child.getSpace().heightProperty().get() + getSpacing();
                }
            }
        });
    }

    public static void setGrow(Component component, Grow grow) {
        growMap.put(component, grow);
    }

}
