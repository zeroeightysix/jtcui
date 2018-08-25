package me.zeroeightsix.jtcui.handle;

/**
 * Created by 086 on 21/05/2018.
 */
public interface MouseHandler {

    /**
     * @param action The action performed (e.g. drag)
     * @param x The x position of the mouse when the action occurred
     * @param y The y position of the mouse when the action occurred
     * @param button The button pressed on the mouse
     */
    void onMouse(MouseAction action, int x, int y, int button);

    /**
     * @param scrolled Value of mouse wheel scroll distance
     * @param x The x position of the mouse when the action occurred
     * @param y The y position of the mouse when the action occurred
     */
    void onScroll(int scrolled, int x, int y);

    enum MouseAction {
        DOWN,MOVE,DRAG, RELEASE
    }

}
