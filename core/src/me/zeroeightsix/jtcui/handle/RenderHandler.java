package me.zeroeightsix.jtcui.handle;

import me.zeroeightsix.jtcui.JTC;

/**
 * Created by 086 on 21/05/2018.
 */
public interface RenderHandler {

    /**
     * Defines the scissor box. See openGL's glScissor.
     * This method is expected to also enable the scissor test.
     *
     * @param top    The y coordinate of the top left corner
     * @param left   The x coordinate of the top left corner
     * @param bottom The y coordinate of the bottom right corner
     * @param right  The x coordinate of the bottom right corner
     */
    void scissor(int top, int left, int bottom, int right);

    /**
     * Disable the scissor test
     */
    void disableScissor();

    /**
     * Move the current translation
     *
     * @param x Amount to add to the current translation on the x axis
     * @param y Amount to add to the current translation on the y axis
     */
    void translate(int x, int y);

    /**
     * Reset the current translation to the origin point
     */
    void resetTranslation();

}
