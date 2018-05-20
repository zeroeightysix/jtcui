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
public class VBoxLayout extends FixedLayout {

    private Alignment componentAlignment = Alignment.TOP_LEFT;
    private HashMap<Component, Grow> growMap = new HashMap<>();
    private int spacing = 0;
    private Padding padding = Padding.NO_PADDING;

    @Override
    public void organise(Component component) {
        Optional.of(component.getChildren()).ifPresent(children -> {
            final int padWidth = component.getWidth() - getPadding().getLeft() - getPadding().getRight();
            final int padHeight = component.getHeight() - getPadding().getTop() - getPadding().getBottom();
            AtomicInteger spaceLeft = new AtomicInteger(padHeight);

            children.stream().filter(component1 -> getGrow(component1) == Grow.NONE).forEach(component1 -> {
                component.setWidth(padWidth);
                spaceLeft.addAndGet(-component.getHeight());
            });

            Stream<Component> componentStream = children.stream().filter(component1 -> getGrow(component1) == Grow.ALWAYS);
            final int perNode = (int) (spaceLeft.get()-(spacing*componentStream.count()));
            componentStream.forEach(component1 -> {
                component.setWidth(padWidth);
                component.setHeight(perNode);
            });

            final int totalHeight = children.stream().mapToInt(Component::getHeight).sum() + (spacing * children.size());
            int position = componentAlignment.isTop() ? getPadding().getTop() :
                    componentAlignment.isBottom() ? padHeight - totalHeight - (spacing * children.size()) :
                            padHeight / 2 - totalHeight / 2;
            for (Component c : children) {
                c.setX(componentAlignment.isLeft() ? getPadding().getLeft() :
                        (componentAlignment.isRight() ? component.getWidth() - getPadding().getRight() - c.getWidth() :
                                padWidth / 2  - (c.getWidth() / 2)));
                c.setY(position);
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
