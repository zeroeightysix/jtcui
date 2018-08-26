package me.zeroeightsix.jtcui.handle;

/**
 * The render handler takes care of translations and scissor testing.
 *
 * @author 086
 */
public interface RenderHandler {

    /**
     * Defines the scissor box. See openGL's glScissor.
     * This method is expected to also enable a scissor test.
     *
     * @param top    The y coordinate of the top left corner
     * @param left   The x coordinate of the top left corner
     * @param bottom The y coordinate of the bottom right corner
     * @param right  The x coordinate of the bottom right corner
     */
    void scissor(double top, double left, double bottom, double right);

    /**
     * Disable the scissor test
     */
    void disableScissor();

    /**
     * Move the current translation
     *
     * @param x Amount to withAdded to the current translation on the x axis
     * @param y Amount to withAdded to the current translation on the y axis
     */
    void translate(double x, double y);

    /**
     * Reset the current translation to the origin point
     */
    void resetTranslation();

}
