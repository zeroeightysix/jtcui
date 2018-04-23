package me.zeroeightsix.jtcui.layout.layouts;

import me.zeroeightsix.jtcui.component.Component;

/**
 * Created by 086 on 23/04/2018.<br>
 *
 * A layout that relies on its parent to organise for them.
 * Layouts are so spoiled these days. Sigh.
 */
public class ParentLayout implements Layout {

    Layout parent;

    public ParentLayout(Layout parent) {
        this.parent = parent;
    }

    @Override
    public Layout getParent() {
        return parent;
    }

    @Override
    public void organise(Component component) {
        parent.organise(component);
    }
}
