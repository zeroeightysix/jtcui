package me.zeroeightsix.jtcui.layout.layouts;

import me.zeroeightsix.jtcui.component.Component;
import me.zeroeightsix.jtcui.component.Container;
import me.zeroeightsix.jtcui.layout.Alignment;
import me.zeroeightsix.jtcui.layout.Grow;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by 086 on 23/04/2018.
 */
public class HBoxLayout extends SpacedLayout {
    private Alignment componentAlignment = Alignment.TOP_LEFT;

    @Override
    public void organise(Component component) {
//        Optional.of(component.getChildren()).ifPresent(children -> {
//            boolean cont = component instanceof Container;
//            final int padWidth = component.getWidth() - getPadding().getLeft() - getPadding().getRight() - (cont ? ((Container) component).getFatLeft() + ((Container) component).getFatRight() : 0);
//            final int padHeight = component.getHeight() - getPadding().getTop() - getPadding().getBottom() - (cont ? ((Container) component).getFatTop() + ((Container) component).getFatBottom() : 0);
//
//            AtomicInteger spaceLeft = new AtomicInteger(padHeight);
//
//            children.stream().filter(component1 -> getGrow(component1) == Grow.NONE).forEach(component1 -> {
//                component.setHeight(padHeight);
//                spaceLeft.addAndGet(- (component1.getWidth() + getSpacing()));
//            });
//
//            List<Component> growingComponents = children.stream().filter(component1 -> getGrow(component1) == Grow.ALWAYS).collect(Collectors.toList());
//            final int perNode = spaceLeft.get() - (spacing * growingComponents.size());
//            growingComponents.forEach(component1 -> {
//                component.setHeight(padHeight);
//                component.setWidth(perNode);
//            });
//
//            final int totalWidth = children.stream().mapToInt(Component::getWidth).sum() + (spacing * children.size());
//            int position = componentAlignment.isLeft() ? getPadding().getLeft() :
//                    componentAlignment.isRight() ? padWidth - totalWidth - (spacing * children.size()) :
//                            padWidth / 2 - totalWidth / 2;
//            for (Component c : children) {
//                c.setX(position);
//                c.setY(componentAlignment.isTop() ? getPadding().getTop() :
//                        (componentAlignment.isBottom() ? component.getHeight() - getPadding().getBottom() - c.getHeight() :
//                                padHeight / 2 - (c.getWidth() / 2)));
//                position += c.getHeight() + getSpacing();
//            }
//        });
    }
}
