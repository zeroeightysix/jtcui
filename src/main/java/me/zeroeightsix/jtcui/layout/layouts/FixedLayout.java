package me.zeroeightsix.jtcui.layout.layouts;

import me.zeroeightsix.jtcui.component.Component;

/**
 * Created by 086 on 23/04/2018.
 *
 * A layout that doesn't organise anything at all. Positions of objects remain unmodified.
 */
public class FixedLayout extends ParentLayout {

    public FixedLayout() {
        super(null);
    }

    @Override
    public void organise(Component component) {
        // Do nothing
    }
}
