package me.zeroeightsix.jtcui.layout.layouts;

import me.zeroeightsix.jtcui.Space;
import me.zeroeightsix.jtcui.component.Component;
import me.zeroeightsix.jtcui.layout.Alignment;
import me.zeroeightsix.jtcui.layout.Grow;

import java.util.HashMap;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

/**
 * A self-sizing spaced layout that aligns components horizontally.
 *
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

            AtomicReference<Double> placeX = new AtomicReference<>(alignment.isLeft() ? x : 0);

            components.forEach(child -> {
                Optional.ofNullable(growMap.get(child)).ifPresent(grow -> child.getSpace().heightProperty().set(height * grow.getModifier()));
                if (alignment.isTop())
                    child.getSpace().yProperty().set(y);
                else if (alignment.isBottom())
                    child.getSpace().yProperty().set(y + height - child.getSpace().heightProperty().get());
                else
                    child.getSpace().yProperty().set(y + (height / 2d) - (child.getSpace().heightProperty().get() / 2d));

                if (alignment.isLeft())
                    child.getSpace().xProperty().set(placeX.get());
                placeX.updateAndGet(v -> v + child.getSpace().widthProperty().get() + getSpacing());
            });

            if (alignment.isRight() || alignment.isCenterHorizontal()) {
                double posX = x - placeX.get() + (alignment.isRight() ? width : width / 2d);
                for (Component child : components) {
                    child.getSpace().xProperty().set(posX);
                    posX += child.getSpace().widthProperty().get() + getSpacing();
                }
            }
        });
    }

    public static void setGrow(Component component, Grow grow) {
        growMap.put(component, grow);
    }

}
