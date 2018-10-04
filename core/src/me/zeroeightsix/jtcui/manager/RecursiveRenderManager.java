package me.zeroeightsix.jtcui.manager;

import me.zeroeightsix.jtcui.JTC;
import me.zeroeightsix.jtcui.component.Component;

/**
 * Created by 086 on 4/10/2018.
 */
public class RecursiveRenderManager implements RenderManager {

    JTC theJTC;

    public RecursiveRenderManager(JTC theJTC) {
        this.theJTC = theJTC;
    }

    @Override
    public void renderRecursive(Component component) {
        theJTC.render.translate(component.getSpace().xProperty().get(), component.getSpace().yProperty().get());
        boolean hasChildren = component.getChildren() != null;
        theJTC.getComponentHandle(component).draw(component);
        if (hasChildren) {
            component.getChildren().forEach(this::renderRecursive);
        }
        theJTC.render.translate(-component.getSpace().xProperty().get(), -component.getSpace().yProperty().get());
    }

}
