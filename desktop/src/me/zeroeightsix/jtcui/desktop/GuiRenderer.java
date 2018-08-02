package me.zeroeightsix.jtcui.desktop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import me.zeroeightsix.jtcui.handle.RenderHandler;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GLContext;

/**
 * @author 086
 */
public class GuiRenderer implements RenderHandler {

    private int translatedX = 0, translatedY = 0;

    @Override
    public void scissor(int top, int left, int bottom, int right) {
        Gdx.gl.glScissor(left, top, right-left, bottom-top);
        Gdx.gl.glEnable(GL20.GL_SCISSOR_TEST);
    }

    @Override
    public void disableScissor() {
        Gdx.gl.glDisable(GL20.GL_SCISSOR_TEST);
    }

    @Override
    public void translate(int x, int y) {
        GL11.glTranslated(x, y, 0);
        translatedX += x;
        translatedY += y;
    }

    @Override
    public void resetTranslation() {
        GL11.glTranslated(-translatedX, -translatedY, 0);
        translatedX = 0;
        translatedY = 0;
    }

}
