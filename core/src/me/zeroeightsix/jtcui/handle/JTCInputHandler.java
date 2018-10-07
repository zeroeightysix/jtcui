package me.zeroeightsix.jtcui.handle;

import me.zeroeightsix.jtcui.JTC;
import me.zeroeightsix.jtcui.Point;
import me.zeroeightsix.jtcui.component.Component;

import java.util.Optional;

/**
 * The default JTC input handler. Implements input actions.
 *
 * @author 086
 */
public class JTCInputHandler implements InputHandler {

    final JTC theJTC;
    private Component held;
    private Component lastInteracted = null;
    private Component mouseOver = null;

    public JTCInputHandler(JTC theJTC) {
        this.theJTC = theJTC;
    }

    @Override
    public void onKey(KeyAction action, int key, char keyChar) {
        if (lastInteracted != null) {
            theJTC.getComponentHandle(lastInteracted).onKey(lastInteracted, action, key, keyChar);
            lastInteracted.getInputHandlers().forEach(inputHandler -> inputHandler.onKey(action, key, keyChar));
        }
    }

    @Override
    public void onMouse(MouseAction action, int x, int y, int button) {
        funnel(theJTC, x, y).ifPresent(c -> {
            switch (action) {
                case DOWN:
                    held = lastInteracted = c;
                    break;
                case DRAG:
                case RELEASE:
                    c = held;
                    break;
            }

            Point position = JTC.getRealPosition(c);
            int nx = x - position.getX(), ny = y - position.getY();

            if (action == MouseAction.MOVE && mouseOver != c) {
                Point position2 = JTC.getRealPosition(c);
                int nx2 = x - position2.getX(), ny2 = y - position2.getY();

                Component oldMouseOver = mouseOver;
                mouseOver = c; // We do this assignment so if the component's handle desires to know what component the mouse is in now, they can call #getMouseOver
                theJTC.getComponentHandle(oldMouseOver).onMouse(oldMouseOver, MouseAction.LEAVE_COMPONENT, nx2, ny2, button);
                theJTC.getComponentHandle(c).onMouse(c, MouseAction.ENTER_COMPONENT, nx, ny, button);
            }

            theJTC.getComponentHandle(c).onMouse(c, action, nx, ny, button);
            c.getInputHandlers().forEach(inputHandler -> inputHandler.onMouse(action, nx, ny, button));

            if (action == MouseAction.RELEASE)
                held = null;
        });
    }

    @Override
    public void onScroll(int scrolled, int x, int y) {
        coalesce(held, funnel(theJTC, x, y).orElse(null)).ifPresent(c -> {
            Point position = JTC.getRealPosition(c);
            int nx = x - position.getX(), ny = y - position.getY();
            theJTC.getComponentHandle(c).onScroll(c, scrolled, nx, ny);
            c.getInputHandlers().forEach(inputHandler -> inputHandler.onScroll(scrolled, nx, ny));
        });
    }

    protected Optional<Component> funnel(JTC theJTC, int x, int y) {
        if (x < theJTC.getRootComponent().getSpace().xProperty().get()
                || y < theJTC.getRootComponent().getSpace().yProperty().get())
            return Optional.empty();
        Component c = theJTC.getRootComponent().explore(x - theJTC.getRootComponent().getSpace().xProperty().get(), y - theJTC.getRootComponent().getSpace().yProperty().get());
        if (c.getInputHandlers() != null) return Optional.of(c);
        return Optional.empty();
    }

    public static <T> Optional<T> coalesce(T a, T b) {
        return Optional.ofNullable(a == null ? b : a);
    }

    protected JTC getJTC() {
        return theJTC;
    }

    public Component getLastInteracted() {
        return lastInteracted;
    }

    public Component getMouseOver() {
        return mouseOver;
    }
}
