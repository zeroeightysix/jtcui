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
            int nx = x - position.getX(), ny = y - position.getY();
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

    public static <T> Optional<T> coalesce(T a, T b) {
        return Optional.ofNullable(a == null ? b : a);
    }

    protected JTC getJTC() {
        return theJTC;
    }

}
