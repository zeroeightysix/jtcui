package me.zeroeightsix.jtcui.handle;

import me.zeroeightsix.jtcui.JTC;
import me.zeroeightsix.jtcui.component.Component;
import me.zeroeightsix.jtcui.component.Container;

import java.util.List;

/**
 * The default JTC Render handler.<br>
 * Will perform all component looping and logic for you.
 */
public abstract class JTCRenderHandler implements RenderHandler {

    private void recursiveRender(JTC theJTC, Component component) {
        theJTC.getComponentHandle(component).draw(component);
        List<Component> children = component.getChildren();
        if (children != null && !children.isEmpty())
            for (Component child : children) recursiveRender(theJTC, component);
    }

    @Override
    public void render(JTC theJTC) {
        Container root = theJTC.getRootComponent();
        recursiveRender(theJTC, root);
    }

}
