package me.zeroeightsix.jtcui.desktop.component;

import com.badlogic.gdx.graphics.glutils.ImmediateModeRenderer20;
import me.zeroeightsix.jtcui.Fat;
import me.zeroeightsix.jtcui.JTC;
import me.zeroeightsix.jtcui.Space;
import me.zeroeightsix.jtcui.component.BorderedContainer;
import me.zeroeightsix.jtcui.component.Draggable;
import me.zeroeightsix.jtcui.desktop.Launcher;
import me.zeroeightsix.jtcui.desktop.handle.SimpleHandle;
import me.zeroeightsix.jtcui.handle.ComponentHandle;
import me.zeroeightsix.jtcui.handle.MouseHandler;
import org.lwjgl.opengl.GL11;

/**
 * @author 086
 */
@JTC.Install(Window.WindowHandle.class)
public class Window extends BorderedContainer implements Draggable {

    Space dragSpace;

    boolean dragging = false;
    double dragX;
    double dragY;

    public Window(int titleHeight, int borderThickness) {
        this(0, 0, 0, 0, titleHeight, borderThickness);
    }

    public Window(int x, int y, int width, int height, int titleHeight, int borderThickness) {
        super(x, y, width, height, new Fat(borderThickness, borderThickness, borderThickness + titleHeight, borderThickness));
        dragSpace = new Space(this, 0, 0, width, titleHeight);
        dragSpace.widthProperty().bind(getSpace().widthProperty());
    }

    @Override
    public Space getDragSpace() {
        return dragSpace;
    }

    public static class WindowHandle extends SimpleHandle<Window> {

        @Override
        public void onMouse(Window component, MouseHandler.MouseAction action, int x, int y, int button) {
            if (action == MouseHandler.MouseAction.DOWN && component.dragSpace.isPointInside(x, y)) {
                component.dragX = x;
                component.dragY = y;
                component.dragging = true;
            } else if (component.dragging && action == MouseHandler.MouseAction.DRAG) {
                double diffX = component.dragX - x;
                double diffY = component.dragY - y;
                component.getSpace().xProperty().set(component.getSpace().xProperty().get() - diffX);
                component.getSpace().yProperty().set(component.getSpace().yProperty().get() - diffY);
            }
        }

        @Override
        public void onScroll(Window component, int scrolled, int x, int y) {

        }
    }

}
