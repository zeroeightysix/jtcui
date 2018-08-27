package me.zeroeightsix.jtcui.layout.layouts;

import me.zeroeightsix.jtcui.component.Component;

/**
 * A class that manages the {@link me.zeroeightsix.jtcui.Space} of a component and its children, if any.
 *
 * @author 086
 */
public interface Layout {

    void organise(Component component);
    void update(Component component);

}
