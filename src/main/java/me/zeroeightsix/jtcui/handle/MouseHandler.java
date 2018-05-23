package me.zeroeightsix.jtcui.handle;

import me.zeroeightsix.jtcui.JTC;

/**
 * Created by 086 on 21/05/2018.
 */
public interface MouseHandler {

    /**
     * The specified button has been pressed down at location x, y
     * @param x
     * @param y
     * @param button
     */
    void down(JTC theJTC, int x, int y, int button);
    /**
     * The specified button has been released at location x, y
     * @param x
     * @param y
     * @param button
     */
    void up(JTC theJTC, int x, int y, int button);
    /**
     * The specified button has been moved to location x, y
     * @param x
     * @param y
     * @param button
     */
    void move(JTC theJTC, int x, int y, int button);

}
