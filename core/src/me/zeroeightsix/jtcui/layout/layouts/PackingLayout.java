package me.zeroeightsix.jtcui.layout.layouts;

import me.zeroeightsix.jtcui.component.Component;

/**
 * @author 086
 */
public abstract class PackingLayout extends AbstractLayout {
    public void pack(Component component) {
        // TODO: Pack this component
    }

    @Override
    public void update(Component component) {
        organise(component);
        pack(component);
    }
}
