package me.zeroeightsix.jtcui.desktop.handle;

import me.zeroeightsix.jtcui.component.Component;
import me.zeroeightsix.jtcui.component.DirectionalSpacedContainer;
import me.zeroeightsix.jtcui.handle.ComponentHandle;
import me.zeroeightsix.jtcui.handle.MouseHandler;

/**
 * @author 086
 */
public class DBoxHandle implements ComponentHandle<DirectionalSpacedContainer> {

    @Override
    public void draw(DirectionalSpacedContainer component) {

    }

    @Override
    public void onMouse(DirectionalSpacedContainer component, MouseHandler.MouseAction action, int x, int y, int button) {

    }

    @Override
    public void onScroll(DirectionalSpacedContainer component, int scrolled, int x, int y) {

    }

    @Override
    public int getRenderLevel(Component component) {
        return 0;
    }

}
