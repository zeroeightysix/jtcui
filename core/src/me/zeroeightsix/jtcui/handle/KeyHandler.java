package me.zeroeightsix.jtcui.handle;

/**
 * A mouse handler receives mouse events and turns them into an action for JTC to process.
 *
 * @author 086
 */
public interface KeyHandler {

    /**
     * @param action  The action performed (e.g. drag)
     * @param key     The keycode of the key pressed
     * @param keyChar The character representation of the key pressed
     */
    void onKey(KeyAction action, int key, char keyChar);

    enum KeyAction {
        DOWN, REPEAT, RELEASE
    }

}
