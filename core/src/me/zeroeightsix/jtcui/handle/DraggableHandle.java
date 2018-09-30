package me.zeroeightsix.jtcui.handle;

import me.zeroeightsix.jtcui.component.AbstractDraggable;

/**
 * @author 086
 */
public abstract class DraggableHandle<T extends AbstractDraggable> extends EmptyComponentHandle<T> {
    @Override
    public void onMouse(T component, InputHandler.MouseAction action, int x, int y, int button) {
        if (action == InputHandler.MouseAction.DOWN && component.getDragSpace().isPointInside(x, y)) {
            component.dragX = x;
            component.dragY = y;
            component.dragging = true;
        } else if (component.dragging && action == InputHandler.MouseAction.DRAG) {
            double diffX = component.dragX - x;
            double diffY = component.dragY - y;
            component.getSpace().xProperty().set(component.getSpace().xProperty().get() - diffX);
            component.getSpace().yProperty().set(component.getSpace().yProperty().get() - diffY);
        } else if (action == InputHandler.MouseAction.RELEASE)
            component.dragging = false;
    }
}
