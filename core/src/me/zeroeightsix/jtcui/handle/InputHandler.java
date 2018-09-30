package me.zeroeightsix.jtcui.handle;

/**
 * A input handler receives input events and turns them into an action for JTC to process.
 *
 * @author 086
 */
public interface InputHandler {

    /**
     * @param action The action performed (e.g. drag)
     * @param x      The x position of the input when the action occurred
     * @param y      The y position of the input when the action occurred
     * @param button The button pressed on the input
     */
    void onMouse(MouseAction action, int x, int y, int button);

    /**
     * @param scrolled Value of input wheel scroll distance
     * @param x        The x position of the input when the action occurred
     * @param y        The y position of the input when the action occurred
     */
    void onScroll(int scrolled, int x, int y);

    /**
     * @param action  The action performed (e.g. drag)
     * @param key     The keycode of the key pressed
     * @param keyChar The character representation of the key pressed
     */
    void onKey(KeyAction action, int key, char keyChar);

    enum MouseAction {
        DOWN, MOVE, DRAG, RELEASE
    }

    enum KeyAction {
        DOWN, REPEAT, RELEASE
    }
}
