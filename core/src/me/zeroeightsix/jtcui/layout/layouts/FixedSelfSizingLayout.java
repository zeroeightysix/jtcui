package me.zeroeightsix.jtcui.layout.layouts;

import me.zeroeightsix.jtcui.component.Component;

/**
 * A layout that does not organise its components but will size itself.
 *
 * @author 086
 * @see SelfSizingLayout
 */
public class FixedSelfSizingLayout extends SelfSizingLayout {

    public FixedSelfSizingLayout(Type type) {
        super(type);
    }

    @Override
    public void organise(Component component) {
    }

}
