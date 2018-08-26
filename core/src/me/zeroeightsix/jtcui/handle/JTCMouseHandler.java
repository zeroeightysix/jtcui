package me.zeroeightsix.jtcui.handle;

import me.zeroeightsix.jtcui.JTC;
import me.zeroeightsix.jtcui.Point;
import me.zeroeightsix.jtcui.component.Component;

import java.util.Optional;

/**
 * The default JTC mouse handler. Implements mouse actions.
 *
 * @author 086
 */
public class JTCMouseHandler implements MouseHandler {

    final JTC theJTC;

    public JTCMouseHandler(JTC theJTC) {
        this.theJTC = theJTC;
    }

    @Override
    public void onMouse(MouseAction action, int x, int y, int button) {
        funnel(theJTC, x, y).ifPresent(c -> {
            Point position = JTC.getRealPosition(c);
            int nx = x - position.getX(), ny = y - position.getY();
            theJTC.getComponentHandle(c).onMouse(c, action, nx, ny, button);
            c.getMouseHandlers().forEach(mouseHandler -> mouseHandler.onMouse(action, nx, ny, button));
        });
    }

    @Override
    public void onScroll(int scrolled, int x, int y) {
        funnel(theJTC, x, y).ifPresent(c -> {
            Point position = JTC.getRealPosition(c);
            int nx = x - position.getX(), ny = y - position.getY();
            theJTC.getComponentHandle(c).onScroll(c, scrolled, nx, ny);
            c.getMouseHandlers().forEach(mouseHandler -> mouseHandler.onScroll(scrolled, nx, ny));
        });
    }

    protected Optional<Component> funnel(JTC theJTC, int x, int y) {
        if (x < theJTC.getRootComponent().getSpace().xProperty().get()
                || y < theJTC.getRootComponent().getSpace().yProperty().get())
            return Optional.empty();
        Component c = theJTC.getRootComponent().explore(x - theJTC.getRootComponent().getSpace().xProperty().get(), y - theJTC.getRootComponent().getSpace().yProperty().get());
        if (c.getMouseHandlers() != null) return Optional.of(c);
        return Optional.empty();
    }

    protected JTC getJTC() {
        return theJTC;
    }

}
