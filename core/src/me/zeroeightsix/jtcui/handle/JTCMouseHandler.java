package me.zeroeightsix.jtcui.handle;

import me.zeroeightsix.jtcui.JTC;
import me.zeroeightsix.jtcui.Point;
import me.zeroeightsix.jtcui.component.Component;

import java.util.Optional;

/**
 * Created by 086 on 23/04/2018.<br><br>
 * <p>
 * The default JTC mouse handler<br>
 * Assumes the following buttons are:<br>
 * 0 - Left click<br>
 * 1 - Right click<br>
 * 2 - Middle mouse button click<br>
 * 3, 4, ... - Extra buttons
 */
public class JTCMouseHandler implements MouseHandler {

    JTC theJTC;

    public JTCMouseHandler(JTC theJTC) {
        this.theJTC = theJTC;
    }

    @Override
    public void onMouse(MouseAction action, int x, int y, int button) {
        funnel(theJTC, x, y).ifPresent(c -> {
            Point position = theJTC.getRealPosition(c);
            int nx = x-position.getX(), ny = y-position.getY();
            theJTC.getComponentHandle(c).onMouse(c, action, nx, ny, button);
            c.getMouseHandlers().forEach(mouseHandler -> mouseHandler.onMouse(action, nx, ny, button));
        });
    }

    @Override
    public void onScroll(int scrolled, int x, int y) {
        funnel(theJTC, x, y).ifPresent(c -> {
            Point position = theJTC.getRealPosition(c);
            int nx = x-position.getX(), ny = y-position.getY();
            theJTC.getComponentHandle(c).onScroll(c, scrolled, nx, ny);
            c.getMouseHandlers().forEach(mouseHandler -> mouseHandler.onScroll(scrolled, nx, ny));
        });
    }

    protected Optional<Component> funnel(JTC theJTC, int x, int y) {
        if (x < theJTC.getRootComponent().getSpace().xProperty().get()
                || y < theJTC.getRootComponent().getSpace().yProperty().get())
            return Optional.empty();
        Component c = theJTC.getRootComponent().explore(x - theJTC.getRootComponent().getSpace().xProperty().get(), y - theJTC.getRootComponent().getSpace().yProperty().get());
        if (c.getMouseHandlers() != null) return Optional.ofNullable(c);
        return Optional.empty();
    }
}
