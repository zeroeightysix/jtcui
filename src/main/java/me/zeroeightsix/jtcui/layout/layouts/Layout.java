package me.zeroeightsix.jtcui.layout.layouts;

import me.zeroeightsix.jtcui.component.Component;

/**
 * Created by 086 on 23/04/2018.
 */
public interface Layout {

    Layout getParent();
    void organise(Component component);

}