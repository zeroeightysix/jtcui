package me.zeroeightsix.jtcui.desktop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import me.zeroeightsix.jtcui.handle.RenderHandler;

/**
 * @author 086
 */
public class GuiRenderer implements RenderHandler {

    @Override
    public void scissor(double top, double left, double bottom, double right) {
        Gdx.gl.glScissor((int) left, (int) top, (int) (right - left), (int) (bottom - top));
        Gdx.gl.glEnable(GL20.GL_SCISSOR_TEST);
    }

    @Override
    public void disableScissor() {
        Gdx.gl.glDisable(GL20.GL_SCISSOR_TEST);
    }

    @Override
    public void translate(double x, double y) {
        float xx = (float) x;
        float yy = (float) y;
        Launcher.camera.translate(xx, yy);
    }

    @Override
    public void resetTranslation() {
        Launcher.camera.position.x = 0;
        Launcher.camera.position.y = 0;
    }

}
