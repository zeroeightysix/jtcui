package me.zeroeightsix.jtcui.desktop.component;

import com.badlogic.gdx.graphics.glutils.ImmediateModeRenderer20;
import me.zeroeightsix.jtcui.Fat;
import me.zeroeightsix.jtcui.JTC;
import me.zeroeightsix.jtcui.Space;
import me.zeroeightsix.jtcui.component.AbstractDraggable;
import me.zeroeightsix.jtcui.component.BorderedContainer;
import me.zeroeightsix.jtcui.component.Component;
import me.zeroeightsix.jtcui.component.Draggable;
import me.zeroeightsix.jtcui.desktop.Launcher;
import me.zeroeightsix.jtcui.desktop.handle.SimpleHandle;
import me.zeroeightsix.jtcui.handle.ComponentHandle;
import me.zeroeightsix.jtcui.handle.DraggableHandle;
import me.zeroeightsix.jtcui.handle.MouseHandler;
import org.lwjgl.opengl.GL11;

import static me.zeroeightsix.jtcui.desktop.handle.SimpleHandle.drawBox;

/**
 * @author 086
 */
@JTC.Install(Window.WindowHandle.class)
public class Window extends AbstractDraggable {


    public Window(int titleHeight, int borderThickness) {
        this(0, 0, 0, 0, titleHeight, borderThickness);
    }

    public Window(int x, int y, int width, int height, int titleHeight, int borderThickness) {
        super(x, y, width, height, new Fat(borderThickness, borderThickness, borderThickness + titleHeight, borderThickness), 0, 0, width, titleHeight);
    }

    public static class WindowHandle extends DraggableHandle<Window> {

        @Override
        public void draw(Window component) {
            drawBox(component.getSpace());
        }

        @Override
        public void onMouse(Window component, MouseHandler.MouseAction action, int x, int y, int button) {
            super.onMouse(component, action, x, y, button);
        }

        @Override
        public void onScroll(Window component, int scrolled, int x, int y) {

        }

    }

}
