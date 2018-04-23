package me.zeroeightsix.jtcui.layout.layouts;

import me.zeroeightsix.jtcui.component.Component;
import me.zeroeightsix.jtcui.layout.*;

import java.util.HashMap;
import java.util.Optional;

/**
 * Created by 086 on 23/04/2018.
 */
public class VerticalLayout extends FixedLayout {

    private HashMap<Component, Alignment> alignmentMap = new HashMap<>();
    private HashMap<Component, Grow> growMap = new HashMap<>();
    private Padding padding = Padding.NO_PADDING;

    /**
     * Won't adjust the fed components height if true
     */
    boolean lockHeight = false;

    private Alignment getAlignment(Component component) {
        return alignmentMap.getOrDefault(component, Alignment.LEFT);
    }

    private void grow(Component parent, Component component) {
        if (growMap.containsKey(component)) {
            Grow grow = growMap.get(component);
            switch (grow) {
                case HORIZONTAL:

                    break;
                default:
                    throw new IllegalGrowException(this, grow);
            }
        }
    }

    @Override
    public void organise(Component component) {
        Optional.of(component.getChildren()).ifPresent(components -> {
            int y = padding.getTop();
            int x = padding.getLeft();

            for (Component c : components) {
                Alignment alignment = getAlignment(c);
                switch (alignment) {
                    case LEFT:
                        c.setX(x);
                        break;
                    case RIGHT:
                        c.setX(component.getWidth()-c.getWidth()-padding.getRight());
                        break;
                    case CENTER:
                        c.setX(component.getWidth()/2-c.getWidth()/2);
                        break;
                    default:
                        throw new IllegalAlignmentException(this, alignment);
                }

                y += c.getHeight();
            }
        });
    }

    public void setPadding(Padding padding) {
        this.padding = padding;
    }

    public void setDoLockHeight(boolean lockHeight) {
        this.lockHeight = lockHeight;
    }

}
