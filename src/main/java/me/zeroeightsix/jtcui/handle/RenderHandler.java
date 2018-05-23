package me.zeroeightsix.jtcui.handle;

/**
 * Created by 086 on 21/05/2018.
 */
public interface RenderHandler {

    /**
     * Render the current scene
     */
    void render();

    /**
     * Defines the scissor box. See openGL's glScissor.
     * @param top The y coordinate of the top left corner
     * @param left The x coordinate of the top left corner
     * @param bottom The y coordinate of the bottom right corner
     * @param right The x coordinate of the bottom right corner
     */
    void scisssor(int top, int left, int bottom, int right);

    /**
     * Move the current translation
     * @param x Amount to add to the current translation on the x axis
     * @param y Amount to add to the current translation on the y axis
     */
    void translate(int x, int y);

    /**
     * Reset the current translation to the origin point
     */
    void resetTranslation();

}
