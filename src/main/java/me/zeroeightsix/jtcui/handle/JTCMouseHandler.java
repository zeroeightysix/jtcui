package me.zeroeightsix.jtcui.handle;

import me.zeroeightsix.jtcui.JTC;

/**
 * Created by 086 on 23/04/2018.<br><br>
 *
 * The default JTC mouse handler<br>
 * Assumes the following buttons are:<br>
 * 0 - Left click<br>
 * 1 - Right click<br>
 * 2 - Middle mouse button click<br>
 * 3, 4, ... - Extra buttons<br>
 */
public class JTCMouseHandler {

    private final JTC theJTC;

    public JTCMouseHandler(JTC theJTC) {
        this.theJTC = theJTC;
    }

    /**
     * The specified button has been pressed down at location x, y
     * @param x
     * @param y
     * @param button
     */
    public void down(int x, int y, int button) {

    }

    /**
     * The specified button has been released at location x, y
     * @param x
     * @param y
     * @param button
     */
    public void up(int x, int y, int button) {

    }

    /**
     * The specified button has been moved to location x, y
     * @param x
     * @param y
     * @param button
     */
    public void move(int x, int y, int button) {

    }

}
