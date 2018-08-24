package me.zeroeightsix.jtcui.component;

import me.zeroeightsix.jtcui.Requirements;
import me.zeroeightsix.jtcui.Space;
import me.zeroeightsix.jtcui.handle.ComponentHandle;
import me.zeroeightsix.jtcui.handle.MouseHandler;
import me.zeroeightsix.jtcui.layout.layouts.Layout;

import java.util.List;

/**
 * Created by 086 on 23/04/2018.
 */
public interface Component {

    Space getSpace();

    Requirements getRequirements();

    Component getParent();

    void setParent(Component component);

    List<Component> getChildren();

    Layout getLayout();

    void setLayout(Layout layout);

    ComponentHandle getHandle();

    List<MouseHandler> getMouseHandlers();

    Component explore(double x, double y);

}
