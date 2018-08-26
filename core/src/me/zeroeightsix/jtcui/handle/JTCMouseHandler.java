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

    final JTC theJTC;
    private Component focus;

    public JTCMouseHandler(JTC theJTC) {
        this.theJTC = theJTC;
    }

    @Override
    public void onMouse(MouseAction action, int x, int y, int button) {
        funnel(theJTC, x, y).ifPresent(c -> {
            switch (action) {
                case DOWN:
                    focus = c;
                    break;
                case DRAG:
                case RELEASE:
                    c = focus;
                    break;
            }

            Point position = JTC.getRealPosition(c);
            int nx = x-position.getX(), ny = y-position.getY();
            theJTC.getComponentHandle(c).onMouse(c, action, nx, ny, button);
            c.getMouseHandlers().forEach(mouseHandler -> mouseHandler.onMouse(action, nx, ny, button));

            if (action == MouseAction.RELEASE)
                focus = null;
        });
    }

    @Override
    public void onScroll(int scrolled, int x, int y) {
        coalesce(focus, funnel(theJTC, x, y).orElse(null)).ifPresent(c -> {
            Point position = JTC.getRealPosition(c);
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
        if (c.getMouseHandlers() != null) return Optional.of(c);
        return Optional.empty();
    }

    public static <T> Optional<T> coalesce(T a, T b) {
        return Optional.ofNullable(a == null ? b : a);
    }

    protected JTC getJTC() {
        return theJTC;
    }

}
