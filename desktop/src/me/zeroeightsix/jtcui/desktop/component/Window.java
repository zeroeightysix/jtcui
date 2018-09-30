package me.zeroeightsix.jtcui.desktop.component;

import me.zeroeightsix.jtcui.Fat;
import me.zeroeightsix.jtcui.JTC;
import me.zeroeightsix.jtcui.component.AbstractDraggable;
import me.zeroeightsix.jtcui.component.Component;
import me.zeroeightsix.jtcui.desktop.Fonts;
import me.zeroeightsix.jtcui.desktop.handle.SimpleHandle;
import me.zeroeightsix.jtcui.handle.DraggableHandle;
import me.zeroeightsix.jtcui.handle.MouseHandler;

/**
 * @author 086
 */
@JTC.Install(Window.WindowHandle.class)
public class Window extends AbstractDraggable {

    private final int titleHeight;

    public Window(String title, int titleHeight, int borderThickness) {
        this(0, 0, 0, 0, title, titleHeight, borderThickness);
    }

    public Window(int x, int y, int width, int height, String title, int titleHeight, int borderThickness) {
        super(x, y, width, height, new Fat(borderThickness, borderThickness, borderThickness + titleHeight, borderThickness), 0, 0, width, titleHeight);
        this.titleHeight = titleHeight;
        setText(title);
    }

    public static class WindowHandle extends DraggableHandle<Window> {

        @Override
        public void draw(Window component) {
            SimpleHandle.drawBox(component.getSpace(), 1, 1, 1);
            SimpleHandle.drawBox(component.getSpace().withHeight(component.titleHeight), .9f, .9f, .9f);
            Fonts.draw(Fonts.robotoCondensedBold, component.getText(), 5, component.titleHeight / 2 - 5);
        }

        @Override
        public void onMouse(Window component, MouseHandler.MouseAction action, int x, int y, int button) {
            super.onMouse(component, action, x, y, button);
        }

        @Override
        public void onScroll(Window component, int scrolled, int x, int y) {

        }

        @Override
        public int getRenderLevel(Component component) {
            return 0;
        }

    }

}
