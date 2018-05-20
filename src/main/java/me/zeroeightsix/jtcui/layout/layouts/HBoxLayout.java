package me.zeroeightsix.jtcui.layout.layouts;

import me.zeroeightsix.jtcui.component.Component;
import me.zeroeightsix.jtcui.layout.Alignment;
import me.zeroeightsix.jtcui.layout.Grow;
import me.zeroeightsix.jtcui.layout.Padding;

import java.util.HashMap;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

/**
 * Created by 086 on 23/04/2018.
 */
public class HBoxLayout extends FixedLayout {

    private Alignment componentAlignment = Alignment.TOP_LEFT;
    private HashMap<Component, Grow> growMap = new HashMap<>();
    private int spacing = 0;
    private Padding padding = Padding.NO_PADDING;

    @Override
    public void organise(Component component) {
        Optional.of(component.getChildren()).ifPresent(children -> {
            final int padWidth = component.getWidth() - getPadding().getLeft() - getPadding().getRight();
            final int padHeight = component.getHeight() - getPadding().getTop() - getPadding().getBottom();
            AtomicInteger spaceLeft = new AtomicInteger(padWidth);

            children.stream().filter(component1 -> getGrow(component1) == Grow.NONE).forEach(component1 -> {
                component.setHeight(padHeight);
                spaceLeft.addAndGet(-component.getWidth());
            });

            Stream<Component> componentStream = children.stream().filter(component1 -> getGrow(component1) == Grow.ALWAYS);
            final int perNode = (int) (spaceLeft.get()-(spacing*componentStream.count()));
            componentStream.forEach(component1 -> {
                component.setHeight(padHeight);
                component.setWidth(perNode);
            });

            final int totalWidth = children.stream().mapToInt(Component::getWidth).sum() + (spacing * children.size());
            int position = componentAlignment.isLeft() ? getPadding().getLeft() :
                    componentAlignment.isRight() ? padWidth - totalWidth - (spacing * children.size()) :
                            padWidth / 2 - totalWidth / 2;
            for (Component c : children) {
                c.setX(position);
                c.setY(componentAlignment.isTop() ? getPadding().getTop() :
                        (componentAlignment.isBottom() ? component.getHeight() - getPadding().getBottom() - c.getHeight() :
                                padHeight / 2  - (c.getWidth() / 2)));
                position += c.getHeight() + getSpacing();
            }
        });
    }

    public Padding getPadding() {
        return padding;
    }

    public void setPadding(Padding padding) {
        this.padding = padding;
    }

    public int getSpacing() {
        return spacing;
    }

    public void setSpacing(int spacing) {
        this.spacing = spacing;
    }

    protected Grow getGrow(Component component) {
        return growMap.getOrDefault(component, Grow.NONE);
    }

}
